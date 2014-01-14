/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Doro
 */
public class Competence {
    //attributs
    String m_nomComp;
    // l'arrayList contient tous les mots clefs pour une compétence
    ArrayList<MotClef> m_lstmots; 

    
    //On récupère le m_nomComp (qui contient le nom de la compétence)
    public String getNomComp() {
        return m_nomComp;
    }

    //Création du constructeur Competence
    public Competence(String nomComp) {
        //On définit une nouvelle conpétence ainsi qu'une liste contenant tous les mots clefs pour cette compétence
        this.m_nomComp = nomComp;
        this.m_lstmots = new ArrayList();
    }
    
    //On recupère le nombre de mot clef associé à cette compétence
    int nbMotClef (){
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
    
    
    
}
