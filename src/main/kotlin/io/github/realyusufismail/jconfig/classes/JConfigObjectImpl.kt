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
import io.github.realyusufismail.jconfig.JConfigObject
import java.math.BigDecimal
import java.math.BigInteger

class JConfigObjectImpl(private val value: JsonNode
) : JConfigObject {

    override val asString: String
        get() {
            if (value.isTextual) {
                return value.asText()
            } else {
                throw ClassCastException("Cannot get $value as String")
            }
        }

    override val asInt: Int
        get() {
            if (value.isInt) {
                return value.asInt()
            } else {
                throw ClassCastException("Cannot get $value as Int")
            }
        }

    override val asBigInt: BigInteger
        get() {
            if (value.isBigInteger) {
                return value.bigIntegerValue()
            } else {
                throw ClassCastException("Cannot get $value as BigInteger")
            }
        }

    override val asDouble: Double
        get() {
            if (value.isDouble) {
                return value.asDouble()
            } else {
                throw ClassCastException("Cannot get $value as Double")
            }
        }

    override val asBoolean: Boolean
        get() {
            if (value.isBoolean) {
                return value.asBoolean()
            } else {
                throw ClassCastException("Cannot get $value as Boolean")
            }
        }

    override val asByte: Byte
        get() {
            if (value.isBinary) {
                return value.binaryValue()[0]
            } else {
                throw ClassCastException("Cannot get $value as Byte")
            }
        }

    override val asShort: Short
        get() {
            if (value.isShort) {
                return value.shortValue()
            } else {
                throw ClassCastException("Cannot get $value as Short")
            }
        }

    override val asLong: Long
        get() {
            if (value.isLong) {
                return value.asLong()
            } else {
                throw ClassCastException("Cannot get $value as Long")
            }
        }

    override val asFloat: Float
        get() {
            if (value.isFloat) {
                return value.floatValue()
            } else {
                throw ClassCastException("Cannot get $value as Float")
            }
        }

    override val asChar: Char
        get() {
            if (value.isTextual && value.asText().length == 1) {
                return value.asText()[0]
            } else {
                throw ClassCastException("Cannot get $value as Char")
            }
        }

    override val asNumber: Number
        get() {
            if (value.isNumber) {
                return value.numberValue()
            } else {
                throw ClassCastException("Cannot get $value as Number")
            }
        }

    override val asDecimal: BigDecimal
        get() {
            if (value.isBigDecimal) {
                return value.decimalValue()
            } else {
                throw ClassCastException("Cannot get $value as BigDecimal")
            }
        }

    override val asJsonEntry: JsonEntry
        get() = JsonEntry("", value)

    override val asJsonNode: JsonNode
        get() = value

    override val parseAsString: String
        get() = value.toString()

}
