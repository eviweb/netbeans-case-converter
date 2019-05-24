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
public class ToCamelCaseConverterTest extends ConverterTestBase {

    @Override
    protected void registerScenarii() {
        String expected = "someDummyText";
        addScenarii(
                new ConversionScenario() {
            @Override
            public String getSourceText() {
                return "Some dummy   Text";
            }

            @Override
            public String getExpectedResult() {
                return expected;
            }

            @Override
            public String getDescription() {
                return "Convert simple text to camelCase.";
            }
        },
                new ConversionScenario() {
            @Override
            public String getSourceText() {
                return "some_dummy___text";
            }

            @Override
            public String getExpectedResult() {
                return expected;
            }

            @Override
            public String getDescription() {
                return "Convert snake case like text to camelCase.";
            }
        },
                new ConversionScenario() {
            @Override
            public String getSourceText() {
                return "Some-dummy---Text";
            }

            @Override
            public String getExpectedResult() {
                return expected;
            }

            @Override
            public String getDescription() {
                return "Convert hyphen case like text to camelCase.";
            }
        });
    }
}
