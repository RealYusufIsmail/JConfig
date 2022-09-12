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

import io.github.realyusufismail.jconfig.JConfigObject
import java.math.BigDecimal
import java.math.BigInteger

class JConfigObjectImpl(private val value: Any) : JConfigObject {

    override val asString: String
        get() {
            if (value is String) {
                return value
            } else {
                throw ClassCastException("Cannot cast ${value::class.java} to String")
            }
        }

    override val asInt: Int
        get() {
            if (value is Int) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Int")
            }
        }

    override val asBigInt: BigInteger
        get() {
            if (value is BigInteger) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to BigInteger")
            }
        }

    override val asDouble: Double
        get() {
            if (value is Double) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Double")
            }
        }

    override val asBoolean: Boolean
        get() {
            if (value is Boolean) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Boolean")
            }
        }

    override val asByte: Byte
        get() {
            if (value is Byte) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Byte")
            }
        }

    override val asShort: Short
        get() {
            if (value is Short) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Short")
            }
        }

    override val asLong: Long
        get() {
            if (value is Long) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Long")
            }
        }

    override val asFloat: Float
        get() {
            if (value is Float) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Float")
            }
        }

    override val asChar: Char
        get() {
            if (value is Char) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Char")
            }
        }

    override val asNumber: Number
        get() {
            if (value is Number) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Number")
            }
        }

    override val asDecimal: BigDecimal
        get() {
            if (value is BigDecimal) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to BigDecimal")
            }
        }

    override val asArray: Array<JConfigObject>
        get() {
            if (value is Array<*>) {
                return value
                    .map { it?.let { it1 -> JConfigObjectImpl(it1) } ?: JConfigObjectImpl("") }
                    .toTypedArray()
            } else {
                throw ClassCastException("Cannot cast $value to Array")
            }
        }

    override val asList: List<JConfigObject>
        get() {
            if (value is List<*>) {
                return value.map {
                    it?.let { it1 -> JConfigObjectImpl(it1) } ?: JConfigObjectImpl("")
                }
            } else {
                throw ClassCastException("Cannot cast $value to List")
            }
        }

    override val asMap: Map<String, JConfigObject>
        get() {
            if (value is Map<*, *>) {
                return value
                    .map {
                        it.key.toString() to
                            (it.value?.let { it1 -> JConfigObjectImpl(it1) }
                                ?: JConfigObjectImpl(""))
                    }
                    .toMap()
            } else {
                throw ClassCastException("Cannot cast $value to Map")
            }
        }

    override val asAny: Any
        get() {
            return value
        }
}
