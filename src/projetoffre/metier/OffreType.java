/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetOffre.metier;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author 21103231
 */

// Création de la classe OffreType
public class OffreType {
    Region m_reg;
    Set<Competence> m_lstComps;
    int salaireEspere;

    // Création des méthodes get (pour récupérer la région saisie, le salaire espéré saisie ainsi que les compétences saisies)
    public Region getReg() {
        return m_reg;
    }
    
    public int getSalaireEspere() {
        return salaireEspere;
    }

    public Set<Competence> getLstComps() {
        return m_lstComps;
    }

    // Création du constructeur OffreType
    public OffreType(Region m_reg,  int salaireEspere, Set<Competence> lstComps) {
        //On définit une nouvelle région, une nouvelle liste de compétence et un nouveau salaire espéré 
        this.m_reg = m_reg;
        this.m_lstComps = lstComps;
        this.salaireEspere = salaireEspere;
    }
}
