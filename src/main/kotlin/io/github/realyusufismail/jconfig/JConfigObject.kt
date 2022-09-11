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
    val string: String

    /** Get the value as an [Int]. */
    val int: Int

    /** Get the value as a [BigInteger]. */
    val bigInt: BigInteger

    /** Get the value as a [Double]. */
    val double: Double

    /** Get the value as a [Boolean]. */
    val boolean: Boolean

    /** Get the value as a [Byte]. */
    val byte: Byte

    /** Get the value as a [Short]. */
    val short: Short

    /** Get the value as a [Long]. */
    val long: Long

    /** Get the value as a [Float]. */
    val float: Float

    /** Get the value as a [Char]. */
    val char: Char

    /** Get the value as a [Number]. */
    val number: Number

    /** Get the value as a [BigDecimal]. */
    val decimal: BigDecimal

    /** Get the value as an [Array]. */
    val array: Array<JConfigObject>

    /** Get the value as a [List]. */
    val list: List<JConfigObject>

    /** Get the value as a [Map]. */
    val map: Map<String, JConfigObject>

    /** Get the value as an [Any]. */
    val any: Any
}
