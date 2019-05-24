/*
 * Copyright 2019 Eric VILLARD <dev@eviweb.fr>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.evidev.netbeans.caseconverter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities for string operations
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
public final class StringUtils {

    public static String capitalizeFirstChar(String text) {
        return text.isEmpty() ? text : text.substring(0, 1).toUpperCase().concat(text.substring(1));
    }
    
    public static String uncapitalizeFirstChar(String text) {
        return text.isEmpty() ? text : text.substring(0, 1).toLowerCase().concat(text.substring(1));
    }

    public static String capitalizePattern(String text, String pattern) {
        Matcher m = Pattern.compile("(" + pattern + ")").matcher(text);
        StringBuilder sb = new StringBuilder();
        int last = 0;

        while (m.find()) {
            sb.append(text.substring(last, m.start()));
            sb.append(m.group(1).toUpperCase());
            last = m.end();
        }
        sb.append(text.substring(last));

        return sb.toString();
    }

    public static String puncuateWithUnique(String text, String punctuationMark) {
        return text.endsWith(punctuationMark) ? text : text.concat(punctuationMark);
    }

    public static String replaceDuplicatesWithUnique(String text, String pattern, String replacement) {
        return text.replaceAll(pattern, replacement);
    }

    public static String stripPatternFrom(String text, String pattern) {
        return stripLeadingPatternFrom(stripTrailingPatternFrom(text, pattern), pattern);
    }

    public static String stripLeadingPatternFrom(String text, String pattern) {
        return text.replaceFirst("^" + escapeMetaChars(pattern), "");
    }

    public static String stripTrailingPatternFrom(String text, String pattern) {
        return text.replaceFirst(escapeMetaChars(pattern) + "$", "");
    }

    public static String prefixPatternWith(String text, String pattern, String prefix) {
        return text.replaceAll("(" + pattern + ")", prefix + "$1");
    }

    public static String escapeMetaChars(String text) {
        String pattern = "([\\<\\>\\(\\)\\[\\]\\{\\}\\\\\\^\\-\\=\\$\\!\\ \\|\\?\\*\\+\\.])";

        return text.replaceAll(pattern, "\\\\$1");
    }
}
