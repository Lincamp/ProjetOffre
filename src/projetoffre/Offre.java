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
import projetoffre.noyaufonctionnel.ComptNoyauFonctionnel;

/**
 *
 * @author Doro
 */
// Création de la classe Offre
public abstract class Offre {

    //Création des attributs
    protected String m_titre;
    protected Region m_region;
    //String m_region;
    // Création de HashMap (Compétence est la cléf et CompType représente la valeur)
    protected HashMap<Competence, CompType> m_tblComps;
    // Création des 2 types de compétences (obligatoire ou souhaitée)
//    CompType ctoblig = new CompType("obligatoire");
//    CompType ctsouh = new CompType("souhaitee");
//
//    static final String m_itemDelim = ";";
//    static final String m_compDelim = "|";
//    static final String m_compTypeDelim = ":";
//    static final String m_offreList = "data/offrelist.txt";

    //Création du constructeur Offre
    public Offre(String fileStr) {
        this.m_tblComps = new HashMap();
    }

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

    // Création de la HashMap contenant toutes les compétences et leurs types associées     
    public HashMap<Competence, CompType> getTblComps() {
        return m_tblComps;
    }

    // Création des méthodes abstraites scoreTotal et enregistrer qui seront utiliser pour calculer le score total et enregistrer une offre
    public abstract double scoreTotal(OffreType offreType);

    public abstract String scoreAdequation(OffreType offretype);

    public abstract void enregistrer();

    // Création de la méthode ajouterComp, qui permet d'ajouter une compétence à une offre
    public void ajouterComp(Competence comp, CompType compType) {
        m_tblComps.put(comp, compType);
    }

//    public Offre() {
//        this.m_tblComps = new HashMap();
//    }
    // Création de la méthodde scroreCompetence
    public double scoreCompetencesHash(ArrayList<Competence> lstCompsCherche) {
        // On initialise scoreCompetences à 0
        double scoreCompetences = 0;
        double poidsMotClef;
        double sommePoids;
        // On récupère toutes les compétences se situant dans la HashMap
        Set setComps = this.m_tblComps.keySet();
        Competence setIterComps;
        // On initialise sommePoids à 0
        sommePoids = 0;
        System.out.println(scoreCompetences + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOffre.java");
        System.out.println("HashMap size: " + this.m_tblComps.size());
        System.out.println("Competence nombre cherche : " + lstCompsCherche.size());
        // Pour toutes les compétences cherhcés on réalise les vérifications suivantes 
        for (int p = 0; p < lstCompsCherche.size(); p++) {
            // On initialise le poidsMotClef à 0
            poidsMotClef = 0;
            System.out.println("Competence chercher nom : " + lstCompsCherche.get(p).getNomComp());
            // On crée un iterator pour pouvoir parcourir la liste des compétences 
            Iterator itrComps = setComps.iterator();
            System.out.println("hasNext : " + itrComps.hasNext());
            // tant que l'on trouve des compétences associées à cette offre on réalise les étapes suivantes
            while (itrComps.hasNext()) {
                //On récupère chaques compétences 
                setIterComps = (Competence) itrComps.next();

                System.out.println("Competence trouve nom : " + setIterComps.getNomComp());
                System.out.println("Competence egale : " + (setIterComps == lstCompsCherche.get(p)));
                // On vérifie que la compétence saisie soit la même que la compétence cherchée
                if (setIterComps.getNomComp() == lstCompsCherche.get(p).getNomComp()) {
                    System.out.println("fffffffffffffffffffffffffffffffffffffffffffff" + this.m_tblComps.get(lstCompsCherche.get(p)).getLibType());
                    // Si la compétence cherchée est une compétence obligatoire alors on multiplie par 1 tous les mots cléfs associés à cette compétence
                    if (this.m_tblComps.get(lstCompsCherche.get(p)).getLibType().equals(ComptNoyauFonctionnel.getOblig().getLibType())) {
                        poidsMotClef = setIterComps.nbMotClef() * 1;
                        System.out.println("fffffffffffffffffffffff" + this.m_tblComps.get(lstCompsCherche.get(p)).getLibType());
                        System.out.println("fffffffffffffffffffffff" + this.m_tblComps.get(lstCompsCherche.get(p)).getLibType());
                        System.out.println("fffffffffffffffff" + setIterComps.nbMotClef());
                        System.out.println("v1_poidsMotClef : " + poidsMotClef);
                    } else {
                        // Sinon on multiplie par 0.5 tous les mots cléfs associés à cette compétence
                        poidsMotClef = setIterComps.nbMotClef() * 0.5;
                        System.out.println("else" + this.m_tblComps.get(lstCompsCherche.get(p)).getLibType());
                        System.out.println(setIterComps.nbMotClef());
                        System.out.println("v0.5_poidsMotClef : " + poidsMotClef);
                    }
                }
            }
          //  System.out.println(" chaque v_poidsMotClef : " + poidsMotClef);

            // la somme des poids des mots clef est égale à sommePoids + le poid des mots cléfs calculés précédement
            sommePoids = sommePoids + poidsMotClef;
            System.out.println(" chaque v_sommePoids : " + sommePoids);
        }

        // le nombre de mot clef total trouvé est égale au nombre de mot clef trouvé
        int nbMotClefTrouveTotal = nbMotClefTrouve(this);
       // System.out.println("v_sommePoids : " + sommePoids);
        // System.out.println("v_nbMotClefTrouveTotal : " + nbMotClefTrouveTotal);

        // le score de Competence est égale à la somme des poids calculé précédement / par le nombre de mot clef total
        scoreCompetences = sommePoids / nbMotClefTrouveTotal;
        // System.out.println("v_scoreCompetencesHash : " + scoreCompetences);
        System.out.println(nbMotClefTrouveTotal + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOffre.java");
        return scoreCompetences;
    }

    // Création de la méthode nbMotClefTrouve
    public int nbMotClefTrouve(Offre o1) {
        // On initialise le nbMotClefTrouve à 0
        int nbMotClefTrouve = 0;
        Competence setIterComps;
        // On récupère toutes les compétences se situant dans la HashMap
        Set setComps = this.m_tblComps.keySet();
        Iterator itrComps = setComps.iterator();
        // pour toutes les compétences trouvées on réalise les étapes suivantes 
        for (int i = 0; i < o1.m_tblComps.size(); i++) {
            // Tant que l'on trouve des compétences associées à cette offre on réalise les étapes suivantes
            while (itrComps.hasNext()) {
                // On récupère toutes les compétences 
                setIterComps = (Competence) itrComps.next();
                // le nombre de mot clef trouvé est égale au nbMotClefTrouve + tous les mots clefs trouvés associés à la compétence
                nbMotClefTrouve = nbMotClefTrouve + setIterComps.nbMotClef();
            }
        }
        return nbMotClefTrouve;
    }

    //Création de la méthode scoreGeographique
    public int scoreGeographique(OffreType offreType) {
        int scoreGeographique;
        boolean r;
        // On initialise scoreGeographique à 0
        scoreGeographique = 0;
        // Si la région cherchée est égale à la région de l'offre trouvé alors le score géographique est égale à 10
        if (this.m_region == offreType.getReg()) {
            scoreGeographique = 10;
        } else if(offreType.getReg().getRegassocie().contains(this.m_region.getRegnom())) 
        {
            scoreGeographique = 5;
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
