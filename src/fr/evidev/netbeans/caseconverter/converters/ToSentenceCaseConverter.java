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

import fr.evidev.netbeans.caseconverter.utils.StringUtils;

/**
 * To sentence case converter
 *
 * A sentence begins with a capital letter and ends with a dot. This converter
 * does not alter capital letters within the sentence.
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
final class ToSentenceCaseConverter implements Converter {

    public ToSentenceCaseConverter() {
    }

    @Override
    public String convert(String text) {
        return text.isEmpty() ? text : StringUtils.puncuateWithUnique(StringUtils.capitalizeFirstChar(text), ".");
    }
}
