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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.netbeans.api.editor.EditorRegistry;
import org.openide.text.NbDocument;
import org.openide.util.Exceptions;

/**
 * Base class for ConvertToAction implementations
 *
 * @author Eric VILLARD <dev@eviweb.fr>
 */
abstract class ConvertToAction implements ActionListener {

    abstract protected ConverterFactory.CONVERTER getConverterType();

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextComponent editor = EditorRegistry.lastFocusedComponent();
        final String selectedText = editor.getSelectedText();
        final StyledDocument document = (StyledDocument) editor.getDocument();
        final String convertedString = ConverterFactory.newConverter(getConverterType()).convert(selectedText);
        final int selectionStartPosition = editor.getSelectionStart();

        NbDocument.runAtomic(document, () -> {
            try {
                document.remove(selectionStartPosition, selectedText.length());
                document.insertString(selectionStartPosition, convertedString, null);
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
    }
}
