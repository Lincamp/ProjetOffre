/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.HashMap;
import view.View;

/**
 *
 * @author Doro
 */
public class EnregistreurDeOffre {

//    private ArrayList<Offre> m_offres;
    private Offre m_offre;
    private ArrayList<View> m_views;

    /**
     * Constructeur forçant une initialisation aux valeurs par défaut.
     */
    public EnregistreurDeOffre(boolean isEmploi) {
        if (isEmploi) {
            // TODO new Emploi();
            m_offre = new Emploi("");
        } else {
            m_offre = new Stage("");
        }
//        m_offres = new ArrayList<>();
        m_views = new ArrayList<>();
        this.init();
    }

    /**
     * Méthode interne de remise à zéro.
     */
    private void init() {
        m_offre.clear();
        notifierView();
    }

    /**
     * Service de Remise à Zéro des données fonctionnelles.
     */
    public void remiseAZero() {
        init();
    }

    public Offre getOffre() {
        return m_offre;
    }

    public void setTitre(String titre)
    {
        m_offre.setTitre(titre);
        notifierView();
    }
    
    public void setRegion(Region reg)
    {
        m_offre.setRegion(reg);
        notifierView();
    }
  
    public HashMap<Competence, CompType> getComps() {
        //return m_lstcomps;
        return m_offre.getTblComps();
    }
    
    public void ajouterComp(Competence comp, CompType compType) {
        m_offre.ajouterComp(comp, compType);
        notifierView();
    }
//, CompType compType
    public void retirerComp(Competence comp) {
        m_offre.retirerComp(comp);
//, compType
        notifierView();
    }
//        m_offres.add(new Stage());
    public void addView(View view) {
        m_views.add(view);
    }

    public void removeView(View view) {
        m_views.remove(view);
    }

    private void notifierView() {
        for (View view : m_views) {
            view.modelChanged();
        }
    }

//    //il n'y pas le supprimer Offre sur interface
//    public void retirerOffre(Offre offre) {
//
//        m_offres.remove(offre);
//
//        notifierView();
//    }
}
