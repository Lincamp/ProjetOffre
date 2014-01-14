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

    private String m_nomComp;
   // boolean m_obligatoire;
    ArrayList<MotClef> m_lstmots;

    public String getNomComp() {
        return m_nomComp;
    }

//    public boolean isObligatoire() {
//        return m_obligatoire;
//    }
    
    public Competence(String nomComp) {
        this.m_nomComp = nomComp;
       // this.m_obligatoire = oblig;, boolean oblig
        this.m_lstmots = new ArrayList();
    }
    
    int nbMotClef (){
        return this.m_lstmots.size();
    }

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
