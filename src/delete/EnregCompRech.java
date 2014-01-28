package delete;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import projetoffre.Competence;

/**
 *
 * @author Doro
 */
public class EnregCompRech {

    private ArrayList<Competence> m_lstCompRech;

    public EnregCompRech() {
        this.m_lstCompRech = new ArrayList();
        init();
    }

    private void init() {
        m_lstCompRech.clear();
    }

    public ArrayList<Competence> getLstCompRech() {
        return m_lstCompRech;

    }

    public void ajouterComp(Competence comp) {
        m_lstCompRech.add(comp);

    }

    public void retirerComp(Competence comp) {
        m_lstCompRech.remove(comp);
    }

}
