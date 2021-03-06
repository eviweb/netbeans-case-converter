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

/**
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
public class ToUpperCaseConverterTest extends ConverterTestBase {

    @Override
    protected void registerScenarii() {
        addScenarii(new ConversionScenario() {
            @Override
            public String getSourceText() {
                return "some Dummy text";
            }

            @Override
            public String getExpectedResult() {
                return "SOME DUMMY TEXT";
            }

            @Override
            public String getDescription() {
                return "Set text to upper case.";
            }
        });
    }
}
