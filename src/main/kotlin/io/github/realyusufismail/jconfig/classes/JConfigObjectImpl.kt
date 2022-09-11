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

    override var string: String
        get() {
            if (value is String) {
                return value
            } else {
                throw ClassCastException("Cannot cast ${value::class.java} to String")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var int: Int
        get() {
            if (value is Int) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Int")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var bigInt: BigInteger
        get() {
            if (value is BigInteger) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to BigInteger")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var double: Double
        get() {
            if (value is Double) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Double")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var boolean: Boolean
        get() {
            if (value is Boolean) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Boolean")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var byte: Byte
        get() {
            if (value is Byte) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Byte")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var short: Short
        get() {
            if (value is Short) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Short")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var long: Long
        get() {
            if (value is Long) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Long")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var float: Float
        get() {
            if (value is Float) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Float")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var char: Char
        get() {
            if (value is Char) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Char")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var number: Number
        get() {
            if (value is Number) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to Number")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var decimal: BigDecimal
        get() {
            if (value is BigDecimal) {
                return value
            } else {
                throw ClassCastException("Cannot cast $value to BigDecimal")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var array: Array<JConfigObject>
        get() {
            if (value is Array<*>) {
                return value
                    .map { it?.let { it1 -> JConfigObjectImpl(it1) } ?: JConfigObjectImpl("") }
                    .toTypedArray()
            } else {
                throw ClassCastException("Cannot cast $value to Array")
            }
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var map: Map<String, JConfigObject>
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
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }

    override var any: Any
        get() {
            return value
        }
        set(value) {
            throw UnsupportedOperationException("Cannot set value of JConfigObject")
        }
}
