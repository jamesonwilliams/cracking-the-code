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
 * Check if two strings are one edit apart, where permissible edits are:
 * (1) remove a character, (2) replace a character, (3) insert a
 * character.
 */
public final class OneWay {

    /**
     * Disallows instantiation of this utility class.
     */
    private OneWay() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * Checks if one string can be made into the other by only one of
     * the allowed operations.
     *
     * @param input A non-null string
     * @param output Another non-null string
     *
     * @return true if input can be transformed to output with one of
     *         the permissable operations
     */
    public static boolean areOneOperationApart(final String input,
            final String output) {

        boolean foundDiff = false;
        int in = 0;
        int out = 0;

        if (Math.abs(input.length() - output.length()) > 1) {
            return false;
        }

        while (in < input.length() && out < output.length()) {
            if (input.charAt(in) == output.charAt(out)) {
                in++;
                out++;
            } else if (foundDiff) {
                return false;
            } else if (in + 1 < input.length()
                    && input.charAt(in + 1) == output.charAt(out)) {
                in++;
                foundDiff = true;
            } else if (out + 1 < output.length()
                    && output.charAt(out + 1) == input.charAt(in)) {
                out++;
                foundDiff = true;
            } else {
                // Replacement?
                in++;
                out++;
                foundDiff = true;
            }
        }

        return true;
    }
}
