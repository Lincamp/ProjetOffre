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
public abstract class Offre {
    //attribut

    String titre;
    String region;
    ArrayList<Competence> lstcomps;

    //methodes
    public int scoreGeographique(Region regChercher, ArrayList<Region> lstregTrouve) {
        int scoreGeographique = 0;
        for (int i = 0; i < lstregTrouve.size(); i++) {
            scoreGeographique = 0;
            if (regChercher.getRegnom().equals(lstregTrouve.get(i).getRegnom())) {
                scoreGeographique = 10;
            } else {
                for (int j = 0; j < regChercher.regassocie.size(); j++) {
                    if (regChercher.regassocie.toString().equals(lstregTrouve.get(j).getRegnom())) {
                        scoreGeographique = 5;
                    } else {
                        scoreGeographique = 0;
                    }
                }
            }
        }
        return scoreGeographique;
    }

    public double scoreCompetences(ArrayList<Offre> lstOffreTrouve, ArrayList<Competence> lstCompsCherche) {
        double scoreCompetences = 0;
        double poidsMotClef;
        double sommePoids;
        int nbMotClefChercher;
        System.out.println("v1_lstOffreTrouve.size : " + lstOffreTrouve.size());
        for (int i = 0; i < lstOffreTrouve.size(); i++) {

            sommePoids = 0;
            nbMotClefChercher = 0;
            for (int j = 0; j < lstOffreTrouve.get(i).lstcomps.size(); j++) {
                for (int p = 0; p < lstCompsCherche.size(); p++) {
                    if (lstOffreTrouve.get(i).lstcomps.get(j).getNomComp().equals(lstCompsCherche.get(p).getNomComp())) {
                        poidsMotClef = 0;
                        if (lstOffreTrouve.get(i).lstcomps.get(j).isObligatoire()) {
                            poidsMotClef = lstOffreTrouve.get(i).lstcomps.get(j).lstmots.size() * 1;
                            System.out.println("v1_poidsMotClef : " + poidsMotClef);
                        } else {
                            poidsMotClef = lstOffreTrouve.get(i).lstcomps.get(j).lstmots.size() * 0.5;
                            System.out.println("v0.5_poidsMotClef : " + poidsMotClef);
                        }
                        sommePoids = sommePoids + poidsMotClef;
                    }
                }
                nbMotClefChercher = nbMotClefChercher + lstOffreTrouve.get(i).lstcomps.get(j).lstmots.size();
                System.out.println("v_sommePoids : " + sommePoids);
                System.out.println("v_nbMotClefChercher : " + nbMotClefChercher);
            }
            scoreCompetences = sommePoids / nbMotClefChercher;
            System.out.println("v_scoreCompetences : " + scoreCompetences);
        }
        return scoreCompetences;
    }
    
//   public abstract double score(); /!\   on doit regarder le cour avec l'exemple du loto pour le gagnant !!!! à finir !!!!
}
