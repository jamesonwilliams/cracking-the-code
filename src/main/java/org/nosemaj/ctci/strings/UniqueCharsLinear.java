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

import java.util.HashSet;
import java.util.Set;

/**
 * Checks if a string contains unqiue characters, in linear time, but
 * using O(n) space.
 */
public final class UniqueCharsLinear {

    /**
     * Disallows instantiation of this utility class.
     */
    private UniqueCharsLinear() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if the provided string is composed of all unique
     * characters.
     *
     * <p>Uses O(n) space, and runs in O(n) time.
     *
     * @param string The string to check for unique characters
     *
     * @return true if all characters in string are unique; false,
     *         otherwise.
     */
    public static boolean unique(final String string) {
        Set<Character> seenChars = new HashSet<>();

        for (int index = 0; index < string.length(); index++) {
            if (seenChars.contains(string.charAt(index))) {
                return false;
            }

            seenChars.add(string.charAt(index));
        }

        return true;
    }
}
