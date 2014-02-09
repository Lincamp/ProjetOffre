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
public class DocumentListenerSaisie implements DocumentListener {

    private PanelSaisie fenetre;
    private static int m_minSal = 0;
    private static int m_maxSal = 0;
    private static boolean m_expValid = false;
    private static boolean m_titreValid = false;

    public DocumentListenerSaisie(PanelSaisie fenetre) {
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
            final JTextField source = (JTextField) (e.getDocument().getProperty("source"));
            final String sourceId = (String) source.getClientProperty("id");

//            System.out.println("sourceeeeeeeeeeeeeee  " + sourceId);
            final Document document = e.getDocument();
            final int length = document.getLength();
//            final String textExperience = document.getText(0, length);
//            final String text = document.getText(0, length);
            final String text = document.getText(0, length);

//            System.out.println("textTitre:" + text + "|length" + length);
            if (text.isEmpty()) {
//                System.out.println("1+++++++++++++++++++++++++++++++++++++++++++++" + length);
                //Texte vide => Désactiver le bouton
                fenetre.activerEnregistrer(false);
                if ("txtTitre".equals(sourceId)) {
                    m_titreValid = false;
                    fenetre.setErrorMsg("Vous n'avez pas saisi de titre");
                    fenetre.activerRAZ(false);
                } else if ("txtExp".equals(sourceId)) {
                    m_expValid = false;
                    fenetre.setErrorMsg("Vous n'avez pas saisi d'experience");
                } else if ("txtSalmin".equals(sourceId)) {
                    fenetre.setErrorMsg("Vous n'avez pas saisi de Salaire minimal");
                } else if ("txtSalmax".equals(sourceId)) {
                    fenetre.setErrorMsg("Vous n'avez pas saisi de Salaire maximal");
                }
            } else {
                fenetre.setErrorMsg("  ");
//                System.out.println("2+++++++++++++++++++++++++++++++++++++++++++++" + length);
                if ("txtTitre".equals(sourceId)) {
//                    if(fenetre.getSelectedRegIndex() != 0)
                    m_titreValid = true;
                    fenetre.activerRAZ(true);
                    if (m_titreValid && m_expValid && m_minSal >= 0 && m_minSal <= m_maxSal) {
//                                if(fenetre.getSelectedRegIndex() != 0)
                        fenetre.activerEnregistrer(true);
                        fenetre.setErrorMsg("  ");
                    }
//                    fenetre.activerEnregistrer(true);
                } else {
                    try {
                        int value = Integer.parseInt(text);

                        if (value >= 0) {
                            if ("txtSalmin".equals(sourceId)) {
                                m_minSal = value;
                            } else if ("txtSalmax".equals(sourceId)) {
                                m_maxSal = value;
                            } else if ("txtExp".equals(sourceId)) {
                                m_expValid = true;
                            }
//                            System.out.println("min:" + m_minSal + "|max" + m_maxSal);
                            //Texte nombre >0 et min salaire <= max salaire  => Activer le bouton
                            if (m_titreValid && m_expValid && m_minSal >= 0 && m_minSal <= m_maxSal) {
//                                if(fenetre.getSelectedRegIndex() != 0)
                                fenetre.activerEnregistrer(true);
                                fenetre.setErrorMsg("  ");
                            } else {
//                                if(fenetre.getSelectedRegIndex() != 0)
                                fenetre.activerEnregistrer(false);
                                if (!m_titreValid) {
                                    fenetre.setErrorMsg("Vous n'avez pas saisi de titre");
                                } else if (!m_expValid) {
                                    fenetre.setErrorMsg("L'expérience n'est pas un nombre");
                                } else if (m_minSal > m_maxSal) {
                                    fenetre.setErrorMsg("Le Salaire Man doit être supérieur à le Salaire Min");
                                }
                            }
                        } else {
                            if ("txtExp".equals(sourceId)) {
                                m_expValid = false;
                                fenetre.setErrorMsg("L'expérience doit être un chiffre supérieur à 0");
                            } else if ("txtSalmax".equals(sourceId)) {
                                m_expValid = false;
                                fenetre.setErrorMsg("Le Salaire maxmal doit être un chiffre supérieur à 0");
                            } else if ("txtSalmin".equals(sourceId)) {
                                fenetre.setErrorMsg("Le Salaire Minimal doit être un chiffre supérieur à 0");
                            }

//                            fenetre.setErrorMsg("Le Salaire Min ou le Salaire Max est un chiffre inférieur à 0");
                            //Texte nombre <=0    => Désactiver le bouton
                            fenetre.activerEnregistrer(false);

                        }
                    } catch (NumberFormatException numberFormatException) {
                        //Texte pas un nombre => Désactiver le bouton
                        fenetre.activerEnregistrer(false);
                        if ("txtExp".equals(sourceId)) {
                            fenetre.setErrorMsg("L'expérience n'est pas un nombre");
                        } else if ("txtSalmax".equals(sourceId)) {
                            fenetre.setErrorMsg("Le Salaire Max n'est pas un nombre");
                        } else if ("txtSalmin".equals(sourceId)) {
                            fenetre.setErrorMsg("Le Salaire Min n'est pas un nombre");
                        }
//                        fenetre.setErrorMsg("Salmin or Salmax is not a valid number");
                    }
                }
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(DocumentListenerSaisie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
