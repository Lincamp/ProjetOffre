/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Doro
 */
// Création de la classe Offre
public abstract class Offre {
    //Création des attributs
    String m_titre;
    Region m_region;
    //String m_region;
    // Création de HashMap (Compétence est la cléf et CompType représente la valeur)
    HashMap<Competence, CompType> m_tblComps;
    // Création des 2 types de compétences (obligatoire ou souhaitée)
    CompType ctoblig = new CompType("obligatoire");
    CompType ctsouh = new CompType("souhaitee");
    
    static final char m_itemDelim = ';';
    static final char m_compDelim = '|';
    static final char m_compTypeDelim = ':';
    static final String m_offreList = "data/offrelist.txt";    

    //Création du constructeur Offre
    public Offre(String titre, Region offReg, HashMap<Competence, CompType> tblComps) {
        // On définit un nouveau titre, une nouvelle région et les compétences demandées ainisi que le type de compétence
        this.m_titre = titre;
        this.m_region = offReg;
//        this.m_tblComps = new HashMap();
        this.m_tblComps = tblComps;
    }

    // Création des méthodes get (on récupère la région et le titre de l'offre)
    public Region getReg() {
        return m_region;
    }

    public String getTitre() {
        return m_titre;
    }

    public HashMap<Competence, CompType> getTblComps() {
        return m_tblComps;
    }

    public abstract double scoreTotal(OffreType offreType);

    public abstract void enregistrer();    
    
    public void ajouterComp(Competence comp, CompType compType) {
        m_tblComps.put(comp, compType);
    }

//    public Offre() {
//        this.m_tblComps = new HashMap();
//    }

    public double scoreCompetencesHash(ArrayList<Competence> lstCompsCherche) {
        double scoreCompetences = 0;
        double poidsMotClef;
        double sommePoids;
        Set setComps = this.m_tblComps.keySet();
        Competence setIterComps;
        sommePoids = 0;
//        System.out.println("HashMap size: " + this.m_tblComps.size());
//        System.out.println("Competence nombre cherche : " + lstCompsCherche.size());
        for (int p = 0; p < lstCompsCherche.size(); p++) {
            poidsMotClef = 0;
            System.out.println("Competence chercher nom : " + lstCompsCherche.get(p).getNomComp());
            Iterator itrComps = setComps.iterator();
            System.out.println("hasNext : " + itrComps.hasNext());
            while (itrComps.hasNext()) {

                setIterComps = (Competence) itrComps.next();
                System.out.println("Competence trouve nom : " + setIterComps.getNomComp());

                System.out.println("Competence egale : " + (setIterComps == lstCompsCherche.get(p)));
                if (setIterComps == lstCompsCherche.get(p)) {
                    if (this.m_tblComps.get(lstCompsCherche.get(p)).getLibType().equals(ctoblig.getLibType())) {
                        poidsMotClef = setIterComps.nbMotClef() * 1;
                        System.out.println(this.m_tblComps.get(lstCompsCherche.get(p)).getLibType());
                        System.out.println(setIterComps.nbMotClef());
                        System.out.println("v1_poidsMotClef : " + poidsMotClef);
                    } else {
                        poidsMotClef = setIterComps.nbMotClef() * 0.5;
                        System.out.println(this.m_tblComps.get(lstCompsCherche.get(p)).getLibType());
                        System.out.println(setIterComps.nbMotClef());
                        System.out.println("v0.5_poidsMotClef : " + poidsMotClef);
                    }
                }
            }
            System.out.println(" chaque v_poidsMotClef : " + poidsMotClef);
            sommePoids = sommePoids + poidsMotClef;
            System.out.println(" chaque v_sommePoids : " + sommePoids);
        }

        int nbMotClefTrouveTotal = nbMotClefTrouve(this);
        System.out.println("v_sommePoids : " + sommePoids);
        System.out.println("v_nbMotClefTrouveTotal : " + nbMotClefTrouveTotal);
        scoreCompetences = sommePoids / nbMotClefTrouveTotal;
        System.out.println("v_scoreCompetencesHash : " + scoreCompetences);

        return scoreCompetences;
    }

    public int nbMotClefTrouve(Offre o1) {
        int nbMotClefTrouve = 0;
        Competence setIterComps;
        Set setComps = this.m_tblComps.keySet();
        Iterator itrComps = setComps.iterator();
        for (int i = 0; i < o1.m_tblComps.size(); i++) {
            while (itrComps.hasNext()) {
                setIterComps = (Competence) itrComps.next();
                nbMotClefTrouve = nbMotClefTrouve + setIterComps.nbMotClef();
            }
        }
        return nbMotClefTrouve;
    }

    public int scoreGeographique(OffreType offreType) {
        int scoreGeographique;
        boolean r;
        scoreGeographique = 0;
        if (this.m_region == offreType.getReg()) {
            scoreGeographique = 10;
        } else {
            int j = 0;
            r = true;
            while (j < offreType.getReg().m_regassocie.size() && r == true) {
                if (this.m_region.getRegnom().equals(offreType.getReg().m_regassocie.toString())) {
                    scoreGeographique = 5;
                    r = false;
                } else {
                    scoreGeographique = 0;
                }
            }
        }
        return scoreGeographique;
    }

//    public double scoreCompetences(ArrayList<Offre> lstOffreTrouve, ArrayList<Competence> lstCompsCherche) {
//        double scoreCompetences = 0;
//        double poidsMotClef;
//        double sommePoids;
//        int nbMotClefChercher;
//        System.out.println("v1_lstOffreTrouve.size : " + lstOffreTrouve.size());
//        for (int i = 0; i < lstOffreTrouve.size(); i++) {
//
//            sommePoids = 0;
//            nbMotClefChercher = 0;
//            for (int j = 0; j < lstOffreTrouve.get(i).m_lstcomps.size(); j++) {
//                for (int p = 0; p < lstCompsCherche.size(); p++) {
//                    if (lstOffreTrouve.get(i).m_lstcomps.get(j).getNomComp().equals(lstCompsCherche.get(p).getNomComp())) {
//                        poidsMotClef = 0;
//                        if (lstOffreTrouve.get(i).m_lstcomps.get(j).isObligatoire()) {
//                            poidsMotClef = lstOffreTrouve.get(i).m_lstcomps.get(j).m_lstmots.size() * 1;
//                            System.out.println("v1_poidsMotClef : " + poidsMotClef);
//                        } else {
//                            poidsMotClef = lstOffreTrouve.get(i).m_lstcomps.get(j).m_lstmots.size() * 0.5;
//                            System.out.println("v0.5_poidsMotClef : " + poidsMotClef);
//                        }
//                        sommePoids = sommePoids + poidsMotClef;
//                    }
//                }
//                nbMotClefChercher = nbMotClefChercher + lstOffreTrouve.get(i).m_lstcomps.get(j).m_lstmots.size();
//                System.out.println("v_sommePoids : " + sommePoids);
//                System.out.println("v_nbMotClefChercher : " + nbMotClefChercher);
//            }
//            scoreCompetences = sommePoids / nbMotClefChercher;
//            System.out.println("v_scoreCompetences : " + scoreCompetences);
//        }
//        return scoreCompetences;
//    }
//   public abstract double score(); /!\   on doit regarder le cour avec l'exemple du loto pour le gagnant !!!! à finir !!!!
}
