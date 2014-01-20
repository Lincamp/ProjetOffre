/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre.noyaufonctionnel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
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
        ArrayList<OffreAffiche> lesOfrAffiche = new ArrayList();
        Object[][] resultat;

        ArrayList<Stage> lstStages = OffreNoyauFonctionnel.getTblStages().get(reg.getRegnom());
//        System.out.println(lstStages + "|" + lstStages + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");

        if (lstStages != null) {
            for (Stage stage : lstStages) {
                boolean hasComp = false;
                for (Competence comp : lesComps) {
                    // seulement ajouter une fois
                    if (!hasComp) {
                        if (stage.getTblComps().containsKey(comp)) {
                            OffreAffiche ofrAffiche = new OffreAffiche();
                            ofrAffiche.setTitre(stage.getTitre());
//                        System.out.println(stage.scoreCompetencesHash(lesComps));
                            ofrAffiche.setScoreTotal(stage.scoreCompetencesHash(lesComps));
                            // TODO
                            ofrAffiche.setAdquation("0");
                            ofrAffiche.setRegion(stage.getReg().getRegnom());
                            lesOfrAffiche.add(ofrAffiche);
                            hasComp = true;
                        }
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

    public Object[][] recheStagesOffreType(OffreType ot) {
//        ArrayList<Stage> lesStages = new ArrayList();
        ArrayList<OffreAffiche> lesOfrAffiche = new ArrayList();
        ArrayList<Competence> lesComps = ot.getLstComps();
        Object[][] resultat;

        ArrayList<Stage> lstStages = OffreNoyauFonctionnel.getTblStages().get(ot.getReg().getRegnom());
//        System.out.println(lstStages + "|" + lstStages + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");

        if (lstStages != null) {
            for (Stage stage : lstStages) {
                boolean hasComp = false;
                for (Competence comp : lesComps) {
                    // seulement ajouter une fois
                    if (!hasComp) {
                        if (stage.getTblComps().containsKey(comp)) {
                            OffreAffiche ofrAffiche = new OffreAffiche();
                            ofrAffiche.setTitre(stage.getTitre());
//                            System.out.println(stage.scoreTotal(ot));
                            ofrAffiche.setScoreTotal(stage.scoreTotal(ot));
                            // TODO
                            ofrAffiche.setAdquation(stage.scoreAdequation(ot));
                            ofrAffiche.setRegion(stage.getReg().getRegnom());
                            lesOfrAffiche.add(ofrAffiche);
                            hasComp = true;
                        }
                    }
                }
            }
        }

        Set<String> regsProche = ot.getReg().getRegassocie();

//        ArrayList<Stage> tmpStages = new ArrayList();
        for (String regProche : regsProche) {
//            System.out.println(regProche + "|" + "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjNF.java");

            lstStages = OffreNoyauFonctionnel.getTblStages().get(regProche);
            if (lstStages != null) {
//                System.out.println(lstStages.size() + "|" + lstStages + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");
            } else {
//                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");
            }
            if (lstStages != null) {
                for (Stage stage : lstStages) {
                    boolean hasComp = false;
                    for (Competence comp : lesComps) {
                        // seulement ajouter une fois
                        if (!hasComp) {
                            if (stage.getTblComps().containsKey(comp)) {
                                OffreAffiche ofrAffiche = new OffreAffiche();
                                ofrAffiche.setTitre(stage.getTitre());
//                                System.out.println(stage.scoreTotal(ot) + "scoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeNF.java");
                                ofrAffiche.setScoreTotal(stage.scoreTotal(ot));
                                // TODO

                                ofrAffiche.setAdquation(stage.scoreAdequation(ot));
                                ofrAffiche.setRegion(regProche);
                                lesOfrAffiche.add(ofrAffiche);
                                hasComp = true;
                            }
                        }
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
        ArrayList<OffreAffiche> lesOfrAffiche = new ArrayList();
        Object[][] resultat;

        ArrayList<Emploi> lstEmplois = OffreNoyauFonctionnel.getTblEmplois().get(reg.getRegnom());
//        System.out.println(OffreNoyauFonctionnel.getTblEmplois().size() + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");
//        System.out.println(lstEmplois + "|" + lstEmplois + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");

        if (lstEmplois != null) {
            for (Emploi emploi : lstEmplois) {
                boolean hasComp = false;
                for (Competence comp : lesComps) {
                    // seulement ajouter une fois
                    if (!hasComp) {
                        if (emploi.getTblComps().containsKey(comp)) {
                            OffreAffiche ofrAffiche = new OffreAffiche();
                            ofrAffiche.setTitre(emploi.getTitre());
//                        System.out.println(emploi.scoreCompetencesHash(lesComps));
                            ofrAffiche.setScoreTotal(emploi.scoreCompetencesHash(lesComps));
                            // TODO
                            double score = emploi.scoreCompetencesHash(lesComps);
                            String scoreAd = String.format("%.2f", (score / 1) * 100) + "%";
                            ofrAffiche.setAdquation(scoreAd);
                            ofrAffiche.setRegion(emploi.getReg().getRegnom());
                            lesOfrAffiche.add(ofrAffiche);
                            hasComp = true;
                        }
                    }
                }
            }
        }

        Collections.sort(lesOfrAffiche);

        int afficheSize = lesOfrAffiche.size();
        resultat = new Object[afficheSize][4];
        for (int i = 0; i < afficheSize; i++) {
//            for (int j = 0; j < lesEmplois.size(); j++) {
//                max = lesEmplois.get(0);
//                if ((lesEmplois.get(j).scoreCompetencesHash(lesComps)) < (lesEmplois.get(j + 1).scoreCompetencesHash(lesComps))) {
//                    max = lesEmplois.get(j + 1);
//                }
//            }
            resultat[i][0] = lesOfrAffiche.get(i).getTitre();
            resultat[i][1] = lesOfrAffiche.get(i).getScoreTotal();
            resultat[i][2] = lesOfrAffiche.get(i).getAdquation();
            resultat[i][3] = lesOfrAffiche.get(i).getRegion();
//            lesEmplois.remove(i);
        }
        return resultat;
    }

    public Object[][] recheEmploisOffreType(OffreType ot) {
//        ArrayList<Emploi> lesEmplois = new ArrayList();
        ArrayList<OffreAffiche> lesOfrAffiche = new ArrayList();
        ArrayList<Competence> lesComps = ot.getLstComps();
        Object[][] resultat;

        ArrayList<Emploi> lstEmplois = OffreNoyauFonctionnel.getTblEmplois().get(ot.getReg().getRegnom());
//        System.out.println(lstEmplois + "|" + lstEmplois + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");

        if (lstEmplois != null) {
            for (Emploi emploi : lstEmplois) {
                boolean hasComp = false;
                for (Competence comp : lesComps) {
                    // seulement ajouter une fois
                    if (!hasComp) {
                        if (emploi.getTblComps().containsKey(comp)) {
                            OffreAffiche ofrAffiche = new OffreAffiche();
                            ofrAffiche.setTitre(emploi.getTitre());
//                            System.out.println(emploi.scoreTotal(ot));
                            ofrAffiche.setScoreTotal(emploi.scoreTotal(ot));
                            // TODO
                            ofrAffiche.setAdquation(emploi.scoreAdequation(ot));
                            ofrAffiche.setRegion(emploi.getReg().getRegnom());
                            lesOfrAffiche.add(ofrAffiche);
                            hasComp = true;
                        }
                    }
                }
            }
        }

        Set<String> regsProche = ot.getReg().getRegassocie();

//        ArrayList<Emploi> tmpEmplois = new ArrayList();
        for (String regProche : regsProche) {
//            System.out.println(regProche + "|" + "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjNF.java");

            lstEmplois = OffreNoyauFonctionnel.getTblEmplois().get(regProche);
            if (lstEmplois != null) {
//                System.out.println(lstEmplois.size() + "|" + lstEmplois + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");
            } else {
//                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++NF.java");
            }
            if (lstEmplois != null) {
                for (Emploi emploi : lstEmplois) {
                    boolean hasComp = false;
                    for (Competence comp : lesComps) {
                        // seulement ajouter une fois
                        if (!hasComp) {
                            if (emploi.getTblComps().containsKey(comp)) {
                                OffreAffiche ofrAffiche = new OffreAffiche();
                                ofrAffiche.setTitre(emploi.getTitre());
//                                System.out.println(emploi.scoreTotal(ot) + "scoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeNF.java");
                                ofrAffiche.setScoreTotal(emploi.scoreTotal(ot));
                                // TODO
                                ofrAffiche.setAdquation(emploi.scoreAdequation(ot));
                                ofrAffiche.setRegion(regProche);
                                lesOfrAffiche.add(ofrAffiche);
                                hasComp = true;
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(lesOfrAffiche);

        int afficheSize = lesOfrAffiche.size();
        resultat = new Object[afficheSize][4];
        for (int i = 0; i < afficheSize; i++) {
//            for (int j = 0; j < lesEmplois.size(); j++) {
//                max = lesEmplois.get(0);
//                if ((lesEmplois.get(j).scoreCompetencesHash(lesComps)) < (lesEmplois.get(j + 1).scoreCompetencesHash(lesComps))) {
//                    max = lesEmplois.get(j + 1);
//                }
//            }

            resultat[i][0] = lesOfrAffiche.get(i).getTitre();
            resultat[i][1] = lesOfrAffiche.get(i).getScoreTotal();
            resultat[i][2] = lesOfrAffiche.get(i).getAdquation();
            resultat[i][3] = lesOfrAffiche.get(i).getRegion();
        }
        return resultat;
    }

}

// class created for sorting and displaying
class OffreAffiche implements Comparable<OffreAffiche> {

    private String m_titre;
    private double m_scoreTotal;
    private String m_adquation;
    private String m_region;

    public void setTitre(String titre) {
        this.m_titre = titre;
    }

    public void setScoreTotal(double scoreTotal) {
        this.m_scoreTotal = scoreTotal;
    }

    public void setAdquation(String adquation) {
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

    public String getAdquation() {
        return m_adquation;
    }

    public String getRegion() {
        return m_region;
    }

    @Override
    public int compareTo(OffreAffiche other) {
        int compare = (int) (1000 * (other.m_scoreTotal - this.m_scoreTotal));
//    if(compare == 0) {
//        compare = other.flower - this.flower;
//    }

        return compare;
    }
}
