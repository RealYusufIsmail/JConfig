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

import java.util.*
import java.util.stream.Collectors

/**
 * Used to store the values which are read from the config file which then can be retrieved and
 * used.
 */
class JsonEntry

/**
 * Creates a new JsonEntry instance.
 *
 * @param key The key of the entry.
 * @param value The value of the entry.
 */
(
    /**
     * Gets the key of the entry.
     *
     * @return The key of the entry.
     */
    val key: String,
    /**
     * Gets the value of the entry.
     *
     * @return The value of the entry.
     */
    val value: Any
) {

    override fun toString(): String {
        return "JsonEntry{key='$key', value=$value}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val jsonEntry = other as JsonEntry
        return key == jsonEntry.key && value == jsonEntry.value
    }

    override fun hashCode(): Int {
        return Objects.hash(key, value)
    }

    companion object {
        fun toMap(entries: List<JsonEntry>): Map<String, Any> {
            return entries
                .stream()
                .collect(
                    Collectors.toMap(
                        { obj: JsonEntry -> obj.key }, { obj: JsonEntry -> obj.value }))
        }
    }
}
