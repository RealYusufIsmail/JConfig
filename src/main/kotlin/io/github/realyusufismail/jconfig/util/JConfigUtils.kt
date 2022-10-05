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
package io.github.realyusufismail.jconfig.util

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
        @JvmStatic
        fun getString(key: String): String? {
            return jConfig[key]?.asString
        }

        /**
         * Gets the value as a String. If the value is not found, the default value will be
         * returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a String.
         */
        @JvmStatic
        fun getString(key: String, defaultValue: String): String {
            return jConfig[key, defaultValue].asString
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        @JvmStatic
        fun getInt(key: String): Int? {
            return jConfig[key]?.asInt
        }

        /**
         * Gets the value as an Int. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as an Int.
         */
        @JvmStatic
        fun getInt(key: String, defaultValue: Int): Int {
            return jConfig[key, defaultValue].asInt
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        @JvmStatic
        fun getBoolean(key: String): Boolean? {
            return jConfig[key]?.asBoolean
        }

        /**
         * Gets the value as a Boolean. If the value is not found, the default value will be
         * returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Boolean.
         */
        @JvmStatic
        fun getBoolean(key: String, defaultValue: Boolean): Boolean {
            return jConfig[key, defaultValue].asBoolean
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        @JvmStatic
        fun getDouble(key: String): Double? {
            return jConfig[key]?.asDouble
        }

        /**
         * Gets the value as a Double. If the value is not found, the default value will be
         * returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Double.
         */
        @JvmStatic
        fun getDouble(key: String, defaultValue: Double): Double {
            return jConfig[key, defaultValue].asDouble
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        @JvmStatic
        fun getLong(key: String): Long? {
            return jConfig[key]?.asLong
        }

        /**
         * Gets the value as a Long. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Long.
         */
        @JvmStatic
        fun getLong(key: String, defaultValue: Long): Long {
            return jConfig[key, defaultValue].asLong
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        @JvmStatic
        fun getFloat(key: String): Float? {
            return jConfig[key]?.asFloat
        }

        /**
         * Gets the value as a Float. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Float.
         */
        @JvmStatic
        fun getFloat(key: String, defaultValue: Float): Float {
            return jConfig[key, defaultValue].asFloat
        }

        /**
         * Gets the value as a List.
         *
         * @param key The key to get the value of.
         * @return The value as a List.
         */
        @JvmStatic
        fun getListNode(key: String): List<*>? {
            return jConfig[key]?.asList
        }

        /**
         * Gets the value as a List. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a List.
         */
        @JvmStatic
        fun getListNode(key: String, defaultValue: List<*>): List<*> {
            return jConfig[key, defaultValue].asList
        }

        /**
         * Gets the value as a Map.
         *
         * @param key The key to get the value of.
         * @return The value as a Map.
         */
        @JvmStatic
        fun getMapNode(key: String): Map<*, *>? {
            return jConfig[key]?.asMap
        }

        /**
         * Gets the value as a Map. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as a Map.
         */
        @JvmStatic
        fun getMapNode(key: String, defaultValue: Map<*, *>): Map<*, *> {
            return jConfig[key, defaultValue].asMap
        }

        /**
         * Gets the value of the specified key.
         *
         * @param key The key to get the value of.
         * @return The value of the specified key.
         */
        @JvmStatic
        operator fun get(key: String): Any? {
            return jConfig[key]?.asAny
        }

        /**
         * Gets the value as an Any. If the value is not found, the default value will be returned.
         *
         * @param key The key to get the value from.
         * @param defaultValue The default value to return if the value is not found.
         * @return The value as an Any.
         */
        @JvmStatic
        operator fun get(key: String, defaultValue: Any): Any {
            return jConfig[key, defaultValue].asAny
        }
    }
}
