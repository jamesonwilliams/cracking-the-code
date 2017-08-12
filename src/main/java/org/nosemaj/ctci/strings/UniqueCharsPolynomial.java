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

package org.nosemaj.ctci.strings;

/**
 * Check for unique characters in a string in polynomial time, but with
 * constant space.
 */
public final class UniqueCharsPolynomial {

    /**
     * Disallows instantiation of this utility class.
     */
    private UniqueCharsPolynomial() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if the provided string is composed of all unique
     * characters.
     *
     * <p>Uses O(1) space, but runs in O(n^2) time.
     *
     * @param string String to check for unique characters
     *
     * @return true if all charactres in string are unique; false,
     *         otherwise.
     */
    public static boolean unique(final String string) {
        for (int outer = 0; outer < string.length(); outer++) {
            for (int inner = outer + 1; inner < string.length(); inner++) {
                if (string.charAt(outer) == string.charAt(inner)) {
                    return false;
                }
            }
        }

        return true;
    }
}
