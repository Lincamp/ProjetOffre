/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;

/**
 *
 * @author Doro
 */
public class Competence {
    //attributs

    String m_nomComp;
    boolean m_obligatoire;
    ArrayList<MotClef> m_lstmots;

    public String getNomComp() {
        return m_nomComp;
    }

    public boolean isObligatoire() {
        return m_obligatoire;
    }

    public Competence(String nomComp, boolean oblig) {
        this.m_nomComp = nomComp;
        this.m_obligatoire = oblig;
        this.m_lstmots = new ArrayList();
    }
}
