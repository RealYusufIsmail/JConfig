/*
 * Copyright 2022 Yusuf Arfan Ismail (RealYusufIsmail)
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.jconfig.classes

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.realyusufismail.jconfig.JConfig
import java.io.File
import java.io.IOException

/** Used to build a [JConfigBuilder] object. */
class JConfigBuilder {
    private var extension = ".json"
    private var filename = "config$extension"
    private var directoryPath = "./"
    private var environmentVariable = false


    /**
     * Sets the directory path of the config file.
     *
     * @param directoryPath The directory path of the config file.
     */
    fun setDirectoryPath(directoryPath: String): JConfigBuilder {
        this.directoryPath = directoryPath
        return this
    }


    @Throws(JConfigException::class)
    fun build(): JConfig {
        val mapper = ObjectMapper()

        if (!File(directoryPath).exists()) {
            throw JConfigException("Directory path does not exist!")
        }

        if (!File(directoryPath).isDirectory) {
            throw JConfigException("Directory path is not a directory!")
        }


        if (!filename.endsWith(extension)) {
            throw JConfigException("JConfig only supports JSON files!")
        }

        // need to check if path ends with / if not add it

        if (!directoryPath.endsWith("/")) {
            directoryPath += "/"
        }

        val json = File(directoryPath + filename)

        if (!json.exists()) {
            throw JConfigException("Config file does not exist!")
        }

        return try {
            val root = mapper.readTree(json)
            val entries: MutableList<JsonEntry> = ArrayList()
            val it = root.fields()
            while (it.hasNext()) {
                val (key, value) = it.next()
                entries.add(JsonEntry(key, value))
            }

            val config = JConfigImpl(entries)

            if (environmentVariable) {
                config.values.forEach { (key, value) ->
                    System.setProperty(key, value.parseAsString)
                }
            }

            config
        } catch (e: IOException) {
            throw JConfigException("Could not read the config file.", e)
        }
    }
}
