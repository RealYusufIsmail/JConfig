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

import java.math.BigDecimal
import java.math.BigInteger

/** Used to get a value as a certain type. */
interface JConfigObject {
    /** Get the value as a [String]. */
    val asString: String

    /** Get the value as an [Int]. */
    val asInt: Int

    /** Get the value as a [BigInteger]. */
    val asBigInt: BigInteger

    /** Get the value as a [Double]. */
    val asDouble: Double

    /** Get the value as a [Boolean]. */
    val asBoolean: Boolean

    /** Get the value as a [Byte]. */
    val asByte: Byte

    /** Get the value as a [Short]. */
    val asShort: Short

    /** Get the value as a [Long]. */
    val asLong: Long

    /** Get the value as a [Float]. */
    val asFloat: Float

    /** Get the value as a [Char]. */
    val asChar: Char

    /** Get the value as a [Number]. */
    val asNumber: Number

    /** Get the value as a [BigDecimal]. */
    val asDecimal: BigDecimal

    /** Get the value as an [Array]. */
    val asArray: Array<JConfigObject>

    /** Get the value as a [List]. */
    val asList: List<JConfigObject>

    /** Get the value as a [Map]. */
    val asMap: Map<String, JConfigObject>

    /** Get the value as an [Any]. */
    val asAny: Any
}
