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
package fr.evidev.netbeans.caseconverter.converters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import junit.framework.TestCase;
import static junit.framework.TestCase.fail;
import org.junit.Test;
import org.openide.util.Exceptions;

/**
 * Base class for converter unit tests
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
abstract class ConverterTestBase extends TestCase {

    private ArrayList<ConversionScenario> scenarii;

    protected interface ConversionScenario {

        public String getSourceText();

        public String getExpectedResult();

        public String getDescription();
    }

    public ConverterTestBase() {
        scenarii = new ArrayList<>();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        registerScenarii();
    }

    /**
     * Test of convert method, of class ToUpperCaseConverter.
     */
    @Test
    public void testConvert() {
        if (getConversionScenarii().isEmpty()) {
            fail("No conversion scenario is currently defined.");
        }

        getConversionScenarii().forEach(scenario -> {
            System.out.println(this.getClass().getSimpleName() + ".convert: " + scenario.getDescription());
            String actual;
            String expected = scenario.getExpectedResult();

            actual = getConvertResultForText(scenario.getSourceText());
            assertEquals("Expect " + actual + " to equals " + expected, expected, actual);

            actual = getConvertResultForText(expected);
            assertEquals("Expect " + actual + " to equals " + expected, expected, actual);

            assertEquals("Expect empty string", "", getConvertResultForText(""));
        });
    }

    abstract protected void registerScenarii();

    protected Class< ?> getClassUnderTest() throws ClassNotFoundException {
        return Class.forName(this.getClass().getName().replaceFirst("Test$", ""));
    }

    final protected ArrayList<ConversionScenario> getConversionScenarii() {
        return scenarii;
    }

    final protected void addScenarii(ConversionScenario... scenarii) {
        for (ConversionScenario scenario : scenarii) {
            getConversionScenarii().add(scenario);
        }
    }

    final protected String getConvertResultForText(String text) {
        String result = "";

        try {
            Converter instance = (Converter) getClassUnderTest().getConstructor().newInstance();
            result = instance.convert(text);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }

        return result;
    }
}
