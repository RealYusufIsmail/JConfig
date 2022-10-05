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
package io.github.realyusufismail.jconfig

import io.github.realyusufismail.jconfig.classes.JConfigBuilder
import io.github.realyusufismail.jconfig.classes.JsonEntry

/** Used to get a value from the config.json file. Also creates a new JConfig instance. */
interface JConfig {
    /**
     * Used to get all the entries in the config file.
     *
     * @return A list of all the entries in the config file.
     */
    val entries: Set<JsonEntry>

    /**
     * Gets the value of the key from the config file.
     *
     * @param key The key of the value.
     * @return The value of the key.
     */
    operator fun get(key: String): JConfigObject?

    /**
     * Gets the value of the key from the config file.
     *
     * @param key The key of the value.
     * @param defaultValue The default value to return if the key does not exist.
     * @return The value of the key.
     */
    operator fun get(key: String, defaultValue: Any): JConfigObject

    /**
     * Used to set a value in the config file.
     *
     * @param key The key of the value.
     * @param value The value to set.
     * @return The value of the key.
     */
    operator fun set(key: String, value: Any)

    /**
     * Used to set a value in the config file.
     *
     * @param key The key of the value.
     * @param value The value to set.
     * @return The value of the key.
     */
    operator fun set(key: String, value: JConfigObject)

    /**
     * Used to check if the value is present
     *
     * @param key The key of the value.
     * @return True if the value is present, false otherwise.
     */
    operator fun contains(key: String): Boolean

    companion object {
        /**
         * Gets the builder for the JConfig instance.
         *
         * @return The builder for the JConfig instance.
         */
        @JvmStatic
        fun builder(): JConfigBuilder {
            return JConfigBuilder()
        }

        /**
         * Used to build a new JConfig instance.
         *
         * @return A new JConfigBuilder instance.
         * @throws JConfigException If an error occurs while trying to read the config file.
         */
        fun build(): JConfig {
            return JConfigBuilder().build()
        }
    }
}
