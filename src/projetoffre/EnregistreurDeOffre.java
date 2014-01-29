/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import view.View;

/**
 *
 * @author Doro
 */
public class EnregistreurDeOffre {

    private ArrayList<Offre> m_offres;
    private Offre m_offre;
    private ArrayList<View> m_views;

    /**
     * Constructeur forçant une initialisation aux valeurs par défaut.
     */
    public EnregistreurDeOffre(boolean isEmploi) {
        m_offre = new Emploi("");    
        m_offres = new ArrayList<>();
        m_views = new ArrayList<>();
        init();
    }

    /**
     * Méthode interne de remise à zéro.
     */
    private void init() {

        m_offres.clear();
        notifierView();
    }

    /**
     * Service de Remise à Zéro des données fonctionnelles.
     */
    public void remiseAZero() {
        init();
    }

    public ArrayList<Offre> getOffres() {
        return m_offres;
    }

    public void ajouterComp(Offre offre) {
//        if(offre.getClass() == projetoffre.Emploi){
//        System.out.println("offreGetClass" + offre.getClass());
        // TODO
//        m_offres.add(new Emploi());
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

    //il n'y pas le supprimer Offre sur interface
    public void retirerOffre(Offre offre) {

        m_offres.remove(offre);

        notifierView();
    }

}
