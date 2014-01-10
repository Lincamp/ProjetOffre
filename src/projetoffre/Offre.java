/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Doro
 */
public abstract class Offre {
    //attribut

    String m_titre;
    String m_region;
    ArrayList<Competence> m_lstcomps;
    HashMap<Competence, CompType> m_tblComps;
    CompType ctoblig = new CompType("obligatoir");
    CompType ctsouh = new CompType("souhaitee");
//    Set setComp = m_tblComps.entrySet();
//    Iterator q = setComp.iterator();
//    

    //methodes ArrayList<Competence> c, HashMap<Competence, CompType> tblComps
    public Offre(String titre, String region) {
        this.m_titre = titre;
        this.m_region = region;
        this.m_lstcomps = new ArrayList();
        this.m_tblComps = new HashMap();

    }

    public String getM_region() {
        return m_region;
    }
    
    
    

    public double scoreCompetencesHash(Offre offreTrouve, ArrayList<Competence> lstCompsCherche) {
        double scoreCompetences = 0;
        double poidsMotClef;
        double sommePoids;
        Set setComps = offreTrouve.m_tblComps.keySet();     
        Competence setIterComps;
        sommePoids = 0;       
        System.out.println("HashMap size: " + offreTrouve.m_tblComps.size());
        System.out.println("Competence nombre cherche : " + lstCompsCherche.size());
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
                    if (offreTrouve.m_tblComps.get(lstCompsCherche.get(p)).getM_libType().equals(ctoblig.getM_libType())) {
                        poidsMotClef = setIterComps.nbMotClef() * 1;
                        System.out.println(offreTrouve.m_tblComps.get(lstCompsCherche.get(p)).getM_libType());
                        System.out.println(setIterComps.nbMotClef());
                        System.out.println("v1_poidsMotClef : " + poidsMotClef);
                    } else {
                        poidsMotClef = setIterComps.nbMotClef() * 0.5;
                        System.out.println(offreTrouve.m_tblComps.get(lstCompsCherche.get(p)).getM_libType());
                        System.out.println(setIterComps.nbMotClef());
                        System.out.println("v0.5_poidsMotClef : " + poidsMotClef);
                    }
                }
            }
            System.out.println(" chaque v_poidsMotClef : " + poidsMotClef);
            sommePoids = sommePoids + poidsMotClef;
            System.out.println(" chaque v_sommePoids : " + sommePoids);
        }

        int nbMotClefTrouveTotal = nbMotClefTrouve(offreTrouve);
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
      
    public int scoreGeographique(Region regChercher) {
        int scoreGeographique;
        boolean r;
            scoreGeographique = 0;
            if (this.getM_region().equals(regChercher.getRegnom())) {
                scoreGeographique = 10;
            } else {
                int j = 0;
                r=true;
                while(j < regChercher.m_regassocie.size() && r == true) {
                    if (this.getM_region().equals(regChercher.m_regassocie.toString())) {
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
