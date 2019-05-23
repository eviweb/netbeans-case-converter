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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To title case converter
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
final class ToTitleCaseConverter implements Converter {

    public ToTitleCaseConverter() {
    }

    @Override
    public String convert(String text) {
        String result = StringUtils.capitalizePattern(text, "[\\s_-]+[a-zA-Z]");
        result = StringUtils.capitalizeFirstChar(result);
        result = StringUtils.prefixPatternWith(result, "[A-Z]", " ");
        result = StringUtils.replaceDuplicatesWithUnique(result, "[\\s_-]+", " ").stripLeading();

        return result;
    }
}
