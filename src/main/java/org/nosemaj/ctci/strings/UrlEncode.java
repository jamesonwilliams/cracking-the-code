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
 * Utility for encoding spaces into URL format.
 */
public final class UrlEncode {

    /**
     * Disallows instantiation of this utility class.
     */
    private UrlEncode() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Replaces all instances of a space character by %20.
     *
     * @param string A string that may contain spaces
     *
     * @return A string whose spaces have become %20
     */
    public static String encodeSpaces(final String string) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == ' ') {
                builder.append("%20");
            } else {
                builder.append(string.charAt(index));
            }
        }

        return builder.toString();
    }
}
