/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.Objects;
import projetoffre.noyaufonctionnel.ComptNoyauFonctionnel;

/**
 *
 * @author Doro
 */
public class Competence {

    //attributs
    private ComptNoyauFonctionnel m_comptFonc;
    String m_nomComp;
    // l'arrayList contient tous les mots clefs pour une compétence
    ArrayList<MotClef> m_lstmots;
    static final char m_compDelim = ':';
    // les ";" permettent de séparer les régions associées entre elles
    static final String m_motclefDelim = ";";

    //On récupère le m_nomComp (qui contient le nom de la compétence)
    public String getNomComp() {
        return m_nomComp;
    }

    public Competence() {
        m_comptFonc = new ComptNoyauFonctionnel();
    }

    //Création du constructeur Competence
    //On recupère le nombre de mot clef associé à cette compétence
    int nbMotClef() {
        return this.m_lstmots.size();
    }

    //Création du hashCode (de facon automatique)
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.m_nomComp);
        hash = 97 * hash + Objects.hashCode(this.m_lstmots);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Competence other = (Competence) obj;
        if (!Objects.equals(this.m_nomComp, other.m_nomComp)) {
            return false;
        }
        if (!Objects.equals(this.m_lstmots, other.m_lstmots)) {
            return false;
        }
        return true;
    }

    public Competence(String fileStr) {
        this.m_lstmots = new ArrayList();
        int pos;
        String motClefsStr;
        // On vérifie si le nombre de carractère de cette ligne est suppérireur à 0
        if (fileStr.length() > 0) {
            // On trouve ou se situe les ":" 
            pos = fileStr.indexOf(m_compDelim);

            // Si on ne trouve pas les ":" on récupère tous les carractères se situant avant les ":" et on les met dans la variable "m_regnom"
            if (pos == -1) {
                this.m_nomComp = fileStr;
            } else {
                // Si on trouve les ":" alors on récupère tous les carractères se situant avant les ":" et on les met dans la variable "m_regnom"
                this.m_nomComp = fileStr.substring(0, pos);
                // Tous les carractères se situant apres les ":" représentent les régions proches, ils sont mit dans la variable "compStr"
                motClefsStr = fileStr.substring(pos + 1);

                System.out.println("=====================================" + ComptNoyauFonctionnel.getLstMotClefs().size());
                // On récupère tous les carractères séparés par les ";", puis on les place dans la variable "regProche". On réitère l'opération jusqu'a la fin de la ligne
                for (String motClef : motClefsStr.split(m_motclefDelim)) {
                   
                    for (int i = 0; i < ComptNoyauFonctionnel.getLstMotClefs().size(); i++) {
System.out.println(motClef + "|" + ComptNoyauFonctionnel.getLstMotClefs().get(i).getLibelle() + "|" + motClef.equals(ComptNoyauFonctionnel.getLstMotClefs().get(i).getLibelle()) + " (ppppppppppppppppppcompetence.java)");                          
                        if (motClef.equals(ComptNoyauFonctionnel.getLstMotClefs().get(i).getLibelle())) {
                            this.m_lstmots.add(ComptNoyauFonctionnel.getLstMotClefs().get(i));  
System.out.println(m_lstmots.size() + " (ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccompetence.java)");                            
                        }
                    }
                    System.out.println("motclef " + m_nomComp + ":" + motClef + " (ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccompetence.java)");
                }
                System.out.println("=====================================");
            }
        } else {
        }
    }
}
