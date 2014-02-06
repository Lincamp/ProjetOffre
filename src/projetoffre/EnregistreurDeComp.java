/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import view.View;

/**
 * Cette classe fournit des objets permettant le calcul et le stockage du prix
 * d'un ensemble de comps de photocopies en fonction du nombre, du format et de
 * la qualité.
 *
 * @author navarre
 */
public class EnregistreurDeComp {

    /**
     * Ensemble des attributs internes nécessaires au cumul.
     */
    private ArrayList<String> m_lstCompNoms;
    private Set<Competence> m_comptences;
    private ArrayList<View> views;

    /**
     * Constructeur forçant une initialisation aux valeurs par défaut.
     */
    public EnregistreurDeComp() {
        m_lstCompNoms = new ArrayList<>();
        m_comptences = new HashSet<>();
        views = new ArrayList<>();
        init();
    }

    /**
     * Méthode interne de remise à zéro.
     */
    private void init() {
        m_comptences.clear();
        notifierView();
    }

    /**
     * Service de Remise à Zéro des données fonctionnelles.
     */
    public void remiseAZero() {
        init();
    }

//    public ArrayList<Competence> getCompetences() {
    public Set<Competence> getCompetences() {
        return m_comptences;
    }

//    public ArrayList<Competence> getCompetences() {
    public ArrayList<String> getCompNoms() {
        m_lstCompNoms.clear();
        for (Competence comp : m_comptences) {
            m_lstCompNoms.add(comp.getNomComp());
        }
        return m_lstCompNoms;
    }

    /**
     * Service permettant de : - Calculer le prix d'un comp. - Cumuler le prix.
     * - Cumuler le nombre de copies.
     */
    public void ajouterCompetence(Competence comp) {
        m_comptences.add(comp);
//        System.out.println(m_comptences.size() + "|" + m_comptences + "EnregistreurDeComp.java");
//         recalculer(); 
        notifierView();
    }

    public void addView(View view) {
        views.add(view);
    }

    public void removeView(View view) {
        views.remove(view);
    }

    private void notifierView() {
        for (View view : views) {
            view.modelChanged();
        }
    }

    public void retirerCompetence(Competence comp) {
        m_comptences.remove(comp);
//        recalculer();
        notifierView();
    }

//    private void recalculer() {
////        nbCopiesTotal = DEFAULT_NB_COPIES;
////        prixTotal = DEFAULT_PRIX;
//
//        for (Competence comp : m_comptences) {
//            float prix = comp.getNbCopies() * PRIX_DE_BASE;
//
//            if (comp.getFormat().equals(Format.A3)) {
//                prix *= MAJORATION_A3;
//            }
//
//            if (comp.getQuality().equals(Quality.SUPERIEURE)) {
//                prix *= MAJORATION_SUPERIEURE;
//            }
//
//            prixTotal += prix;
//            nbCopiesTotal += comp.getNbCopies();
//
//        }
//    }
}
