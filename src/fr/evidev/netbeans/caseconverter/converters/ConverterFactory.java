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
import org.openide.util.Exceptions;

/**
 * Converter factory
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
public abstract class ConverterFactory {

    public enum CONVERTER {
        CAMELCASE,
        HYPHENCASE,
        LOWERCASE,
        SENTENCECASE,
        SNAKECASE,
        TITLECASE,
        UPPERCASE        
    }

    final public static Converter newConverter(CONVERTER type) {
        Converter converter;
        try {
            converter = (Converter) ConverterFactory.class.getDeclaredMethod(getFactoryMethodName(type)).invoke(ConverterFactory.class);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Exceptions.printStackTrace(ex);
            converter = (String text) -> text;
        }

        return converter;
    }
    
    final public static Converter newCamelCaseConverter() {
        return new ToCamelCaseConverter();
    }

    final public static Converter newHyphenCaseConverter() {
        return new ToHyphenCaseConverter();
    }

    final public static Converter newLowerCaseConverter() {
        return new ToLowerCaseConverter();
    }
    
    final public static Converter newSentenceCaseConverter() {
        return new ToSentenceCaseConverter();
    }
    
    final public static Converter newSnakeCaseConverter() {
        return new ToSnakeCaseConverter();
    }

    final public static Converter newTitleCaseConverter() {
        return new ToTitleCaseConverter();
    }

    final public static Converter newUpperCaseConverter() {
        return new ToUpperCaseConverter();
    }    

    private static String getFactoryMethodName(CONVERTER type) {
        return "new"
                + type.toString().substring(0, 1).toUpperCase()
                + type.toString().substring(1).toLowerCase().replace("case", "Case")
                + "Converter";
    }
}
