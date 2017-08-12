/*
 * Copyright 2017 nosemaj.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.nosemaj.ctci.cstrings;

/**
 * Reverse a string in place.
 */
public final class ReverseInPlace {

    /**
     * The NUL character.
     */
    private static final char NUL = '\0';

    /**
     * Disallows instantiation of this utility class.
     */
    private ReverseInPlace() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * Reveres the provided string in place.
     *
     * <p>Uses O(1) space, runs in O(n) time.
     *
     * @param string A C-style array of characters
     */
    public static void reverse(final char[] string) {
        if (string == null) {
            return;
        }

        int length = 0;
        int index;
        char placeholder;

        while (string[length] != NUL) {
            length++;
        }

        for (index = 0; index < length / 2; index++) {
            placeholder = string[length - 1 - index];
            string[length - 1 - index] = string[index];
            string[index] = placeholder;
        }
    }
}
