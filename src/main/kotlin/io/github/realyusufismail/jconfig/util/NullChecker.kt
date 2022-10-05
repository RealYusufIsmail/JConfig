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

import io.github.realyusufismail.jconfig.classes.JConfigException

/**
 * Based on java 8's Optional, but with some changes. Used to check if a value is present or not.
 */
class NullChecker<T>(private val value: T) {
    private val EMPTY: NullChecker<*> = NullChecker<Any?>(null)

    /** Returns an empty NullChecker instance. No value is present for this NullChecker. */
    fun empty(): NullChecker<T> {
        return EMPTY as NullChecker<T>
    }

    /** Checks if the value is null. */
    fun isEmpty(): Boolean {
        return value == null
    }

    /** Checks if the value is not null. */
    fun isPresent(): Boolean {
        return value != null
    }

    /** Returns the value if null. */
    fun ifEmpty(block: () -> Unit) {
        if (isEmpty()) {
            block()
        }
    }

    /** Returns the value if not null. */
    fun ifPresent(block: (T) -> Unit) {
        if (isPresent()) {
            block(value)
        }
    }

    /** Returns the value if not null else returns the default value. */
    fun ifPresentOrElse(block: (T) -> Unit, elseBlock: () -> Unit) {
        if (isPresent()) {
            block(value!!)
        } else {
            elseBlock()
        }
    }

    /**
     * If a value is present, returns the value, otherwise throws `NoSuchElementException`.
     *
     * @apiNote The preferred alternative to this method is [.orElseThrow].
     *
     * @return the non-`null` value described by this `Optional`
     * @throws JConfigException if there is no value present
     */
    fun get(): T {
        if (value == null) {
            throw JConfigException("No value present")
        }
        return value
    }
}
