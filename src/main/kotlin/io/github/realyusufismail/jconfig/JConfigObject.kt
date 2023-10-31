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

import com.fasterxml.jackson.databind.JsonNode
import io.github.realyusufismail.jconfig.classes.JsonEntry
import java.math.BigDecimal
import java.math.BigInteger

/** Used to get a value as a certain type. */
interface JConfigObject {
    /**
     * Get the value as a [String].
     *
     * @return The value as a [String].
     */
    val asString: String

    /**
     * Get the value as a [Int].
     *
     * @return The value as a [Int].
     */
    val asInt: Int

    /**
     * Get the value as a [BigInteger].
     *
     * @return The value as a [BigInteger].
     */
    val asBigInt: BigInteger

    /**
     * Get the value as a [Double].
     *
     * @return The value as a [Double].
     */
    val asDouble: Double

    /**
     * Get the value as a [Boolean].
     *
     * @return The value as a [Boolean].
     */
    val asBoolean: Boolean

    /**
     * Get the value as a [Byte].
     *
     * @return The value as a [Byte].
     */
    val asByte: Byte

    /**
     * Get the value as a [Short].
     *
     * @return The value as a [Short].
     */
    val asShort: Short

    /**
     * Get the value as a [Long].
     *
     * @return The value as a [Long].
     */
    val asLong: Long

    /**
     * Get the value as a [Float].
     *
     * @return The value as a [Float].
     */
    val asFloat: Float

    /**
     * Get the value as a [BigDecimal].
     *
     * @return The value as a [BigDecimal].
     */
    val asChar: Char

    /**
     * Get the value as a [BigDecimal].
     *
     * @return The value as a [BigDecimal].
     */
    val asNumber: Number

    /**
     * Get the value as a [BigDecimal].
     *
     * @return The value as a [BigDecimal].
     */
    val asDecimal: BigDecimal

    /**
     * Get the value as a [JsonEntry].
     *
     * @return The value as a [JsonEntry].
     */
    val asJsonEntry: JsonEntry

    /**
     * Gets the value as a [JsonNode].
     *
     * @return The value as a [JsonNode].
     */
    val asJsonNode: JsonNode

    /**
     * Parses the value as a String.
     *
     * @return The value as a String.
     */
    val parseAsString: String
}
