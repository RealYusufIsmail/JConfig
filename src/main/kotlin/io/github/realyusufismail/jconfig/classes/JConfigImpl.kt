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

import com.fasterxml.jackson.databind.JsonNode
import io.github.realyusufismail.jconfig.JConfig
import io.github.realyusufismail.jconfig.JConfigObject
import io.github.realyusufismail.jconfig.util.NullChecker

class JConfigImpl(entries: List<JsonEntry>) : JConfig {

    private var mapEntries: Map<String, Any> = HashMap()
    private var jsonEntries: Set<JsonEntry> = HashSet()

    init {
        this.mapEntries = JsonEntry.toMap(entries)
        jsonEntries = this.mapEntries.map { JsonEntry(it.key, it.value) }.toSet()
    }

    override val entries: Set<JsonEntry>
        get() = jsonEntries

    override fun get(key: String): NullChecker<JConfigObject> {
        // mapEntries[key] ?: throw NoSuchElementException("No value present for key: $key")

        val value =
            mapEntries[key] ?: throw NoSuchElementException("No value present for key: $key")

        if (value is JsonNode) {
            return when {
                value.isInt -> NullChecker(JConfigObjectImpl(value.asInt()))
                value.isLong -> NullChecker(JConfigObjectImpl(value.asLong()))
                value.isDouble -> NullChecker(JConfigObjectImpl(value.asDouble()))
                value.isBoolean -> NullChecker(JConfigObjectImpl(value.asBoolean()))
                value.isTextual -> NullChecker(JConfigObjectImpl(value.asText()))
                value.isArray -> NullChecker(JConfigObjectImpl(value.map { it.asText() }))
                value.isBigDecimal -> NullChecker(JConfigObjectImpl(value.decimalValue()))
                value.isBigInteger -> NullChecker(JConfigObjectImpl(value.bigIntegerValue()))
                value.isFloat -> NullChecker(JConfigObjectImpl(value.floatValue()))
                value.isShort -> NullChecker(JConfigObjectImpl(value.shortValue()))
                value.isBinary -> NullChecker(JConfigObjectImpl(value.binaryValue()))
                value.isObject ->
                    NullChecker(
                        JConfigObjectImpl(
                            value
                                .fields()
                                .asSequence()
                                .map { it.key to it.value.asText() }
                                .toMap()))
                value.isNull -> throw JConfigException("The value of the key $key is null")
                else ->
                    throw JConfigException("The key $key is not a valid type or is not supported")
            }
        } else {
            throw JConfigException("Unknown type: ${value.javaClass}")
        }
    }

    override fun get(key: String, defaultValue: Any): NullChecker<JConfigObject> {
        return if (mapEntries.containsKey(key)) {
            get(key)
        } else {
            NullChecker(JConfigObjectImpl(defaultValue))
        }
    }

    override fun set(key: String, value: Any) {
        mapEntries = mapEntries.toMutableMap().apply { put(key, value) }.toMap()
    }

    override fun set(key: String, value: JConfigObject) {
        mapEntries = mapEntries.toMutableMap().apply { put(key, value) }.toMap()
    }

    override fun contains(key: String): Boolean {
        return mapEntries.containsKey(key)
    }
}
