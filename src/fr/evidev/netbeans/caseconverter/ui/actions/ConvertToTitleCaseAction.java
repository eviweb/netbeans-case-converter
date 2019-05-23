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
package fr.evidev.netbeans.caseconverter.ui.actions;

import fr.evidev.netbeans.caseconverter.converters.ConverterFactory;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "ConvertTo/SubActions",
        id = "fr.evidev.netbeans.caseconverter.ui.actions.ConvertToTitleCaseAction"
)
@ActionRegistration(
        displayName = "#CTL_ConvertToTitleCaseAction"
)
@Messages("CTL_ConvertToTitleCaseAction=Title Case")
public final class ConvertToTitleCaseAction extends ConvertToAction {

    @Override
    protected ConverterFactory.CONVERTER getConverterType() {
        return ConverterFactory.CONVERTER.TITLECASE;
    }
}
