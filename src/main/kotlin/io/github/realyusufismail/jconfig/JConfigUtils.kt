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

import com.fasterxml.jackson.databind.node.*
import io.github.realyusufismail.jconfig.JConfig.Companion.builder

/** A utility class used to get values from the config file. */
class JConfigUtils {
    companion object {
        private val jConfig = builder().build()

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        fun getString(key: String): String {
            if (jConfig[key] is TextNode) {
                return (jConfig[key] as TextNode).asText()
            } else {
                throw JConfigException("The value at the key $key is not a string.")
            }
        }

        /**
         * Gets the value as a String. If the value is not found, the default value will be
         * returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a String.
         */
        fun getString(key: String, defaultValue: String): String {
            return if (jConfig[key] is TextNode) {
                (jConfig[key] as TextNode).asText()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        fun getInt(key: String): Int {
            return if (jConfig[key] is IntNode) {
                (jConfig[key] as IntNode).asInt()
            } else {
                throw JConfigException("The value at the key $key is not an integer.")
            }
        }

        /**
         * Gets the value as an Int. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as an Int.
         */
        fun getInt(key: String, defaultValue: Int): Int {
            return if (jConfig[key] is IntNode) {
                (jConfig[key] as IntNode).intValue()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        fun getBoolean(key: String): Boolean {
            return if (jConfig[key] is BooleanNode) {
                (jConfig[key] as BooleanNode).booleanValue()
            } else {
                throw JConfigException("The value at the key $key is not a boolean.")
            }
        }

        /**
         * Gets the value as a Boolean. If the value is not found, the default value will be
         * returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Boolean.
         */
        fun getBoolean(key: String, defaultValue: Boolean): Boolean {
            return if (jConfig[key, defaultValue] is BooleanNode) {
                (jConfig[key, defaultValue] as BooleanNode).booleanValue()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        fun getDouble(key: String): Double {
            return if (jConfig[key] is DoubleNode) {
                (jConfig[key] as DoubleNode).doubleValue()
            } else {
                throw JConfigException("The value at the key $key is not a double.")
            }
        }

        /**
         * Gets the value as a Double. If the value is not found, the default value will be
         * returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Double.
         */
        fun getDouble(key: String, defaultValue: Double): Double {
            return if (jConfig[key] is DoubleNode) {
                (jConfig[key] as DoubleNode).doubleValue()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        fun getLong(key: String): Long {
            return if (jConfig[key] is LongNode) {
                (jConfig[key] as LongNode).longValue()
            } else {
                throw JConfigException("The value at the key $key is not a long.")
            }
        }

        /**
         * Gets the value as a Long. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Long.
         */
        fun getLong(key: String, defaultValue: Long): Long {
            return if (jConfig[key] is LongNode) {
                (jConfig[key] as LongNode).longValue()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        fun getFloat(key: String): Float {
            return if (jConfig[key] is FloatNode) {
                (jConfig[key] as FloatNode).floatValue()
            } else {
                throw JConfigException("The value at the key $key is not a float.")
            }
        }

        /**
         * Gets the value as a Float. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Float.
         */
        fun getFloat(key: String, defaultValue: Float): Float {
            return if (jConfig[key, defaultValue] is FloatNode) {
                (jConfig[key, defaultValue] as FloatNode).floatValue()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value as a List.
         *
         * @param key The key to get the value of.
         * @return The value as a List.
         */
        fun getListNode(key: String): List<*> {
            return if (jConfig[key] is ArrayNode) {
                (jConfig[key] as ArrayNode).toList()
            } else {
                throw JConfigException("The value at the key $key is not a list.")
            }
        }

        /**
         * Gets the value as a List. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a List.
         */
        fun getListNode(key: String, defaultValue: List<*>): List<*> {
            return if (jConfig[key, defaultValue] is ArrayNode) {
                (jConfig[key, defaultValue] as ArrayNode).toList()
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value as a Map.
         *
         * @param key The key to get the value of.
         * @return The value as a Map.
         */
        fun getMapNode(key: String): Map<*, *> {
            return if (jConfig[key] is ObjectNode) {
                (jConfig[key] as ObjectNode).fields().asSequence().associate { it.key to it.value }
            } else {
                throw JConfigException("The value at the key $key is not a map.")
            }
        }

        /**
         * Gets the value as a Map. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Map.
         */
        fun getMapNode(key: String, defaultValue: Map<*, *>): Map<*, *> {
            return if (jConfig[key, defaultValue] is ObjectNode) {
                (jConfig[key, defaultValue] as ObjectNode).fields().asSequence().associate {
                    it.key to it.value
                }
            } else {
                defaultValue
            }
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        operator fun get(key: String): Any {
            return jConfig[key]
        }

        /**
         * Gets the value as an Any. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as an Any.
         */
        operator fun get(key: String, defaultValue: Any): Any {
            return jConfig[key, defaultValue]
        }
    }
}
