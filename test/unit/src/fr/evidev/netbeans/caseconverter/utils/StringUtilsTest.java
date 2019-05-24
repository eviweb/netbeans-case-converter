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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
public class StringUtilsTest {

    /**
     * Test of capitalizeFirstChar method, of class StringUtils.
     */
    @Test
    public void testCapitalizeFirstChar() {
        String source = "some Dummy text";
        String expected = "Some Dummy text";

        assertEquals(expected, StringUtils.capitalizeFirstChar(source));
    }

    @Test
    public void testCapitalizeFirstCharOnEmptyString() {
        assertTrue(StringUtils.capitalizeFirstChar("").isEmpty());
    }

    @Test
    public void testCapitalizeFirstCharOnSingleCharString() {
        String source = "s";
        String expected = "S";

        assertEquals(expected, StringUtils.capitalizeFirstChar(source));
        assertEquals(expected, StringUtils.capitalizeFirstChar(source.toUpperCase()));
    }
    
    /**
     * Test of capitalizeFirstChar method, of class StringUtils.
     */
    @Test
    public void testUncapitalizeFirstChar() {
        String source = "Some Dummy text";
        String expected = "some Dummy text";

        assertEquals(expected, StringUtils.uncapitalizeFirstChar(source));
    }

    @Test
    public void testUncapitalizeFirstCharOnEmptyString() {
        assertTrue(StringUtils.uncapitalizeFirstChar("").isEmpty());
    }

    @Test
    public void testUncapitalizeFirstCharOnSingleCharString() {
        String source = "S";
        String expected = "s";

        assertEquals(expected, StringUtils.uncapitalizeFirstChar(source));
        assertEquals(expected, StringUtils.uncapitalizeFirstChar(source.toUpperCase()));
    }

    /**
     * Test of capitalizePattern method, of class StringUtils.
     */
    @Test
    public void testCapitalizePattern() {
        String source = "some Dummy text";
        String expected = "soMe DuMMy text";

        assertEquals(expected, StringUtils.capitalizePattern(source, "m"));
    }

    @Test
    public void testCapitalizePatternOnEmptyString() {
        assertTrue(StringUtils.capitalizePattern("", "m").isEmpty());
    }

    /**
     * Test of puncuateWithUnique method, of class StringUtils.
     */
    @Test
    public void testPuncuateWithUnique() {
        String dot = ".";
        String source = "some Dummy text";
        String expected = source + dot;

        assertEquals(expected, StringUtils.puncuateWithUnique(source, dot));
    }

    @Test
    public void testPoncuateWithUniqueOnEmptyString() {
        String dot = ".";

        assertEquals(dot, StringUtils.puncuateWithUnique("", dot));
    }

    @Test
    public void testPoncuateWithUniqueOnAlreadyPunctuatedString() {
        String etc = "...";
        String source = "some Dummy text" + etc;
        String expected = source;

        assertEquals(expected, StringUtils.puncuateWithUnique(source, etc));
    }

    /**
     * Test of replaceDuplicatesWithUnique method, of class StringUtils.
     */
    @Test
    public void testReplaceDuplicatesWithUnique() {
        String source = "Some  Dummy     text";
        String expected = "Some Dummy text";

        assertEquals(expected, StringUtils.replaceDuplicatesWithUnique(source, "\\s+", " "));
        assertEquals(expected, StringUtils.replaceDuplicatesWithUnique(source.replaceAll(" ", "-"), "-+", " "));
    }

    @Test
    public void testRemoveDuplicatesOnEmptyString() {
        assertTrue(StringUtils.replaceDuplicatesWithUnique("", "\\s+", " ").isEmpty());
    }

    /**
     * Test of stripPatternFrom method, of class StringUtils.
     */
    @Test
    public void testStripPatternFrom() {
        String pattern = "***";
        String expected = "Some Dummy text";
        String source = pattern + expected + pattern;

        assertEquals(expected, StringUtils.stripPatternFrom(source, pattern));
    }

    @Test
    public void testStripPatternFromOnEmptyString() {
        assertTrue(StringUtils.stripPatternFrom("", "***").isEmpty());
    }

    @Test
    public void testStripPatternFromStringWithPatternInside() {
        String pattern = "***";
        String expected = "Some Dummy " + pattern + " text";
        String source = expected + pattern;

        assertEquals(expected, StringUtils.stripPatternFrom(source, pattern));
    }

    /**
     * Test of stripLeadingPatternFrom method, of class StringUtils.
     */
    @Test
    public void testStripLeadingPatternFrom() {
        String pattern = "***";
        String expected = "Some Dummy " + pattern + " text" + pattern;
        String source = pattern + expected;

        assertEquals(expected, StringUtils.stripLeadingPatternFrom(source, pattern));
    }

    /**
     * Test of stripTrailingPatternFrom method, of class StringUtils.
     */
    @Test
    public void testStripTrailingPatternFrom() {
        String pattern = "***";
        String expected = pattern + "Some Dummy " + pattern + " text";
        String source = expected + pattern;

        assertEquals(expected, StringUtils.stripTrailingPatternFrom(source, pattern));
    }

    /**
     * Test of prefixPatternWith method, of class StringUtils.
     */
    @Test
    public void testPrefixPatternWith() {
        String prefix = "***";
        String source = "someDummyText";
        String expected = "some" + prefix + "Dummy" + prefix + "Text";

        assertEquals(expected, StringUtils.prefixPatternWith(source, "[A-Z]", prefix));
    }

    @Test
    public void testPrefixPatternWithOnEmptyString() {
        assertTrue(StringUtils.prefixPatternWith("", "[A-Z]", "***").isEmpty());
    }

    /**
     * Test of escapeMetaChars method, of class StringUtils.
     */
    @Test
    public void testEscapeMetaChars() {
        String source = "<>()[]{}\\^-=$! |?*+.";
        String expected = "\\<\\>\\(\\)\\[\\]\\{\\}\\\\\\^\\-\\=\\$\\!\\ \\|\\?\\*\\+\\.";

        assertEquals(expected, StringUtils.escapeMetaChars(source));
    }

}
