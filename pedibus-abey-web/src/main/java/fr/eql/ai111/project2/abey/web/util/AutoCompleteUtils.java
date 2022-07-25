/*package fr.eql.ai111.project2.abey.web.util;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class AutoCompleteUtils {
    public static class testAutocomplete extends PlainDocument {



        private static final long serialVersionUID = 1L;

        private final List<String> dictionary = new ArrayList<String>();

        private final JTextComponent _textField;


        public testAutocomplete(JTextComponent field, String[] aDictionary) {
            _textField = field;
            dictionary.addAll(Arrays.asList(aDictionary));
        }


        public void addDictionaryEntry(String item) {
            dictionary.add(item);
        }


        @Override
        public void insertString(int offs, String str, AttributeSet a)throws BadLocationException {
            super.insertString(offs, str, a);
            String word = autoComplete(getText(0, getLength()));
            if (word != null) {
                super.insertString(offs + str.length(), word, a);
                _textField.setCaretPosition(offs + str.length());
                _textField.moveCaretPosition(getLength());
                // _textField.setCaretPosition(getLength());
                // _textField.moveCaretPosition(offs + str.length());
            }
        }



        public String autoComplete(String text) {
            for (Iterator<String> i = dictionary.iterator(); i.hasNext();) {
                String word = i.next();
                if (word.startsWith(text)) {
                    return word.substring(text.length());
                }
            }
            return null;
        }






         @param dictionary

         @return




         public static JTextField createAutoCompleteTextField(String[] dictionary) {
         JTextField field = new JTextField(20);

         testAutocomplete doc = new testAutocomplete(field, dictionary);
         field.setDocument(doc);
         return field;
         }

         public static void main(String args[]) {

         //Liste des String qui seront autocompleté

       //  /*********************************************************************/
       /* String[] dict = { "java", "javase", "javaee", "javame", "j2se",
                "j2ee", "j2me" };
        /********************************************************************/

/*
        //Le jtextField qui sera autocompeté
        final JTextField field = testAutocomplete.createAutoCompleteText(dict);



        //Action clavier touche entrer
		field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println(field.getText());
                }
            }
        });


        //creation de fenetre principale
        JFrame frame = new JFrame("Autocomplete");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JLabel("Text Field: "));
		frame.add(field);
		frame.pack();
		frame.setVisible(true);
    }
}
}

 */
