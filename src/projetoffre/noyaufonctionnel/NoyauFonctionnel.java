/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre.noyaufonctionnel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import projetoffre.Competence;
import projetoffre.Emploi;
import projetoffre.Offre;
import projetoffre.OffreType;
import projetoffre.Region;
import projetoffre.Stage;

/**
 *
 * @author 20900686
 */
//Création de la classe NoyauFonctionnel
public class NoyauFonctionnel {

    ArrayList<Offre> m_lstOffre;
    ArrayList<Emploi> m_lstEmplois;
//    ArrayList<Stage> m_lstStages;
    ArrayList<Region> m_lstRegions;
    ArrayList<Competence> m_lstCompts;

    public void enregistrerOffre(Offre offre) {
//    Emploi emploiCree = new Emploi(exp, salaireMin, salaireMax, titre, region); 
        this.m_lstOffre.add(offre);
//    return  emploiCree;
    }

//public Emploi enregistrerEmploi (int exp, int salaireMin, int salaireMax, String titre, Region region){
//    Emploi emploiCree = new Emploi(exp, salaireMin, salaireMax, titre, region); 
//    this.m_lstEmplois.add(emploiCree);
//    return  emploiCree;
//}
//
//public Stage enregistrerStage (String titre, Region region){
//    Stage stageCree = new Stage(titre, region);
//    this.m_lstStages.add(stageCree);
//    return stageCree;
//}
    public Object[][] rechercherStages(Region reg, ArrayList<Competence> lesComps) {
//        ArrayList<Stage> lesStages = new ArrayList();
        ArrayList<OffreAffiche> lesOfrAffiche = new ArrayList();
        Object[][] resultat;
        Stage max;

        ArrayList<Stage> lstStages = OffreNoyauFonctionnel.getTblStages().get(reg.getRegnom());
System.out.println(lstStages + "|" + lstStages + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");

        for (Stage stage : lstStages) {
            boolean hasComp = false;
            for (Competence comp : lesComps) {
                // seulement ajouter une fois
                if (!hasComp) {
                    if (stage.getTblComps().containsKey(comp)) {
                        OffreAffiche ofrAffiche = new OffreAffiche();
                        ofrAffiche.setTitre(stage.getTitre());
                        System.out.println(stage.scoreCompetencesHash(lesComps));
                        ofrAffiche.setScoreTotal(stage.scoreCompetencesHash(lesComps));
                        // TODO
                        ofrAffiche.setAdquation(0);
                        ofrAffiche.setRegion(stage.getReg().getRegnom());
                        lesOfrAffiche.add(ofrAffiche);
                        hasComp = true;
                    }
                }
            }
        }

        Collections.sort(lesOfrAffiche);

        int afficheSize = lesOfrAffiche.size();
        resultat = new Object[afficheSize][4];
        for (int i = 0; i < afficheSize; i++) {
//            for (int j = 0; j < lesStages.size(); j++) {
//                max = lesStages.get(0);
//                if ((lesStages.get(j).scoreCompetencesHash(lesComps)) < (lesStages.get(j + 1).scoreCompetencesHash(lesComps))) {
//                    max = lesStages.get(j + 1);
//                }
//            }
            resultat[i][0] = lesOfrAffiche.get(i).getTitre();
            resultat[i][1] = lesOfrAffiche.get(i).getScoreTotal();
            resultat[i][2] = lesOfrAffiche.get(i).getAdquation();
            resultat[i][3] = lesOfrAffiche.get(i).getRegion();
//            lesStages.remove(i);
        }
        return resultat;
    }

    public Object[][] rechercherEmplois(Region reg, ArrayList<Competence> lesComps) {
        ArrayList<Emploi> lesEmplois = new ArrayList();
        Object[][] resultat;
        Emploi max;

        for (Emploi emploi : m_lstEmplois) {
            for (Competence competence : lesComps) {
                if ((emploi.getReg() == reg) && (emploi.getTblComps().containsKey(competence))) {
                    lesEmplois.add(emploi);
                }
            }
        }
        resultat = new Object[lesEmplois.size()][5];

        for (int i = 0; i < lesEmplois.size(); i++) {
            for (int j = 0; j < lesEmplois.size(); j++) {
                max = lesEmplois.get(0);
                if ((lesEmplois.get(j).scoreCompetencesHash(lesComps)) < (lesEmplois.get(j + 1).scoreCompetencesHash(lesComps))) {
                    max = lesEmplois.get(j + 1);
                }
            }

            resultat[i][0] = lesEmplois.get(i).getTitre();
            resultat[i][1] = lesEmplois.get(i).getReg().getRegnom();
            resultat[i][2] = lesEmplois.get(i).getExperience();
            resultat[i][3] = lesEmplois.get(i).getSalairemin();
            resultat[i][4] = lesEmplois.get(i).scoreCompetencesHash(lesComps);
            lesEmplois.remove(i);
        }

        return resultat;
    }
}

// class created for sorting and displaying
class OffreAffiche implements Comparable<OffreAffiche> {

    private String m_titre;
    private double m_scoreTotal;
    private double m_adquation;
    private String m_region;

    public void setTitre(String titre) {
        this.m_titre = titre;
    }

    public void setScoreTotal(double scoreTotal) {
        this.m_scoreTotal = scoreTotal;
    }

    public void setAdquation(double adquation) {
        this.m_adquation = adquation;
    }

    public void setRegion(String region) {
        this.m_region = region;
    }

    public String getTitre() {
        return m_titre;
    }

    public double getScoreTotal() {
        return m_scoreTotal;
    }

    public double getAdquation() {
        return m_adquation;
    }

    public String getRegion() {
        return m_region;
    }

    @Override
    public int compareTo(OffreAffiche other) {
        int compare = (int) Math.ceil(other.m_scoreTotal - this.m_scoreTotal);
//    if(compare == 0) {
//        compare = other.flower - this.flower;
//    }

        return compare;
    }
}
