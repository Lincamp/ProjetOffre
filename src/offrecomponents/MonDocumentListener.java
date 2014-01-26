/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package offrecomponents;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author navarre
 */
public class MonDocumentListener implements DocumentListener {

    private PanelSaisie fenetre;

    public MonDocumentListener(PanelSaisie fenetre) {
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
            final Document document = e.getDocument();
            final int length = document.getLength();
//            final String textExperience = document.getText(0, length);
            final String textTitre = document.getText(0, length);

            System.out.println("textTitre:" + textTitre + "|length" + length);
            if (textTitre.isEmpty()) {
                //Texte vide => Désactiver le bouton
                fenetre.activerEnregistrer(false);
            } 
            else {
                try {
//                    int value = Integer.parseInt(textExperience);
//                    if
//                            (value > 0) {
//                        //Texte nombre >0   => Activer le bouton
                        fenetre.activerEnregistrer(true);
//                    } 
//                    else 
//                    {
                        //Texte nombre <=0    => Désactiver le bouton
//                        fenetre.activerEnregistrer(false);
//                    }
                } 
                catch (NumberFormatException numberFormatException) {
                    //Texte pas un nombre => Désactiver le bouton
                    fenetre.activerEnregistrer(false);
                }
            }

        } catch (BadLocationException ex) {
            Logger.getLogger(MonDocumentListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
