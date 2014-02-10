/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package offrecomponents;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author navarre
 */
public class DocumentListenerRech implements DocumentListener {

    private PanelRechercher fenetre;
//    private static int m_minSal = 0;
//    private static int m_maxSal = 0;

    public DocumentListenerRech(PanelRechercher fenetre) {
        this.fenetre = fenetre;
    }

    //Les 3 méthodes suivantes sont les méthodes appelées lorsque le texte est modifié.
    @Override
    public void insertUpdate(DocumentEvent e) {
        checkText(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkText(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkText(e);
    }

    private void checkText(DocumentEvent e) {
        try {
//            final JTextField source = (JTextField) (e.getDocument().getProperty("source"));
//            final String sourceId = (String) source.getClientProperty("id");

//            System.out.println("sourceeeeeeeeeeeeeee  " + sourceId);
            final Document document = e.getDocument();
            final int length = document.getLength();
//            final String textExperience = document.getText(0, length);
            final String text = document.getText(0, length);

//            System.out.println("textTitre:" + text + "|length" + length);
//            if (text.isEmpty()) {
//                //Texte vide => Désactiver le bouton
//                fenetre.activerRechercher(false);
//            } else {
//                try {
//                    int value = Integer.parseInt(text);
//
//                    if (value > 0) {
//                        fenetre.activerRechercher(true);
//                    } else {
//                        //Texte nombre <=0    => Désactiver le bouton
//                        fenetre.activerRechercher(false);
//                    }
//                } catch (NumberFormatException numberFormatException) {
//                    //Texte pas un nombre => Désactiver le bouton
//                    fenetre.activerRechercher(false);
//                }
//            }
            fenetre.procBtnRech();

        } catch (BadLocationException ex) {
            Logger.getLogger(DocumentListenerRech.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
