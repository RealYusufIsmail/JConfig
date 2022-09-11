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
    var string: String

    var int: Int

    var bigInt: BigInteger

    var double: Double

    var boolean: Boolean

    var byte: Byte

    var short: Short

    var long: Long

    var float: Float

    var char: Char

    var number: Number

    var decimal: BigDecimal

    var array: Array<JConfigObject>

    var map: Map<String, JConfigObject>

    var any: Any
}
