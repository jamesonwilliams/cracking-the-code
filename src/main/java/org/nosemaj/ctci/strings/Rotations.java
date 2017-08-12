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
 * Utility to determine if one string is a rotation of another, and
 * vice-versa.
 */
public final class Rotations {

    /**
     * Disallows instantiation of this utility class.
     */
    private Rotations() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if one string is rotation of the other.
     *
     * <p>e.g. watterbottle and erbottlewat
     *
     * @param first A string
     * @param second Another string
     *
     * @return true if the strings are rotations of eachother; false,
     *         otherwise
     */
    public static boolean check(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        return (first + first).contains(second);
    }
}
