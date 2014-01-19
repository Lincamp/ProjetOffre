/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import projetoffre.noyaufonctionnel.ComptNoyauFonctionnel;
import projetoffre.noyaufonctionnel.RegionNoyauFonctionnel;
//import static delete.FileOperation.m_compTypeDelim;

/**
 *
 * @author Doro
 */
//Création de la classe Emploi
public class Emploi extends Offre {

    //Création des attributs
    int m_experience;
    int m_salairemin;
    int m_salairemax;

    // Création du constructeur Emploi
    public Emploi(String titre, Region region, int experience, int salairemin, int salairemax, HashMap<Competence, CompType> tblComps) {
        //On définit une nouvelle expérience, un nouveau salaireMin, un nouveau salaireMax ainsi qu'un titre et une région
        super(titre, region, tblComps);
        this.m_experience = experience;
        this.m_salairemin = salairemin;
        this.m_salairemax = salairemax;
    }

    public Emploi(String fileStr) {
        super(fileStr);
        Competence comp;
        CompType compType;

        String[] results, resComps;
        int pos;

        results = fileStr.split(Constant.m_itemDelim, -1);

        if (results.length == 6) {
            this.m_titre = results[0];
            // m_region =          
            System.out.println(results[1] + " ## " + RegionNoyauFonctionnel.getTblRegions());
            System.out.println(results[1] + " ## " + RegionNoyauFonctionnel.getTblRegions().get(results[1]));
            this.m_region = RegionNoyauFonctionnel.getTblRegions().get(results[1]);
            this.m_experience = Integer.parseInt(results[2]);
            this.m_salairemin = Integer.parseInt(results[3]);
            this.m_salairemax = Integer.parseInt(results[4]);
            String compStr = new String();
            compStr = results[5];
            resComps = compStr.split(Constant.m_compDelim, -1);
            System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttt" + compStr + "rrr" + compStr.length() + "rrr" + resComps.length);

            for (String resComp : resComps) {
                System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" + resComp);
                pos = resComp.indexOf(Constant.m_compTypeDelim);
                String compNom = new String(resComp.substring(0, pos));
                System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp" + resComp.substring(0, pos));
                comp = ComptNoyauFonctionnel.getTblCompetences().get(resComp.substring(0, pos));
                compStr = resComp.substring(pos + 1);
                System.out.println("obliggggggggggggggggggggggggggggg" + compStr);
                if ("obligatoire".equals(compStr)) {
                    compType = ComptNoyauFonctionnel.getOblig();
                } else {
                    compType = ComptNoyauFonctionnel.getSouh();
                }
                System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp" + ComptNoyauFonctionnel.getTblCompetences().size() + comp + "@" + compType);

                this.ajouterComp(comp, compType);
            }

        } else {
            System.out.println("line in " + Constant.m_offreList + " does not have 6 fields (Emploi.java)");
        }
//        System.out.println("Separated values:" + results[6].indexOf("|") + "@" + results[6].substring(1 + results[6].indexOf("/")) + "(Emploi.java)");
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println("");
    }

    public void printOut() {
        System.out.println("===================================");
        System.out.println("Print of emploi:");
        System.out.println(m_titre);
        System.out.println(m_region);
        System.out.println(m_experience);
        System.out.println(m_salairemin);
        System.out.println(m_salairemax);
        Set setComps = this.m_tblComps.keySet();
        Competence setIterComps;
        Iterator itrComps = setComps.iterator();
        while (itrComps.hasNext()) {
            setIterComps = (Competence) itrComps.next();
            System.out.print(setIterComps.getNomComp() + ":");
            System.out.println(m_tblComps.get(setIterComps).getLibType());
        }
        //System.out.println(m_tblComps);
        System.out.println("===================================");
    }

    //Création des methodes get (pour récupérer l'expérience, le salaireMin et le salaireMax pour un emploi)
    public int getExperience() {
        return m_experience;
    }

    public int getSalairemin() {
        return m_salairemin;
    }

    public int getSalairemax() {
        return m_salairemax;
    }

//    public Emploi() {
//        super();
//    }
//        public void ajouterComp(Competence comp, CompType compType) {       
//        m_tblComps.put(comp, compType);      
//    }
//
    @Override
    public HashMap<Competence, CompType> getTblComps() {
        return super.getTblComps(); //To change body of generated methods, choose Tools | Templates.
    }

    //Création d'une méthode pour pouvoir calculer le score du Salaire
    public double scoreSalaire(OffreType offreType) {
        //On initialise le scoreSalaire à 0
        double scoreSalaire;
        if (offreType.getSalaireEspere() >= this.getSalairemax()) {
            scoreSalaire = 5 - ((offreType.getSalaireEspere() - this.getSalairemax()) / 1000);
            if (scoreSalaire < 0) {
                return 0;
            } else {
                return scoreSalaire;
            }
        } else {
            return 5;
        }
    }

    //Création d'une méthode pour pouvoir calculer le score total
//   public double scoreEmploi(double scoreCompetences, int scoreGeographique, double scoreSalaire ){
//       //On initialise le scoreEmploi à 0
//        double scoreEmploi = 0;
//        scoreEmploi = scoreCompetences + scoreGeographique + scoreSalaire;
//        return scoreEmploi;
//    }   
//
//        public double scoreTotal(OffreType offreType, Emploi emploiTrouve) {
//        //To change body of generated methods, choose Tools | Templates.
//        double scoreEmploi = 0;
//        double scoreCompetences = emploiTrouve.scoreCompetencesHash(emploiTrouve, offreType.getLstComps());
//        int scoreGeographique = emploiTrouve.scoreGeographique(offreType.getReg());
//        double scoreSalaire = emploiTrouve.scoreSalaire(offreType.getSalaireEspere());        
//        scoreEmploi = scoreCompetences + scoreGeographique + scoreSalaire;
//        return scoreEmploi;           
//    }
    @Override
    // Ici on a l'héritage de la classe parente (offre), qui nous permet de calculer le score total d'emploi selon les données sasies par lutilisateur
    //( en fonction de la région, du salaire espéré, et des compétences choisis)
    public double scoreTotal(OffreType offreType) {
        //To change body of generated methods, choose Tools | Templates.       
        // On initialise scoreEmploi à 0
        double scoreEmploi;
        scoreEmploi = this.scoreGeographique(offreType) + this.scoreSalaire(offreType) + this.scoreCompetencesHash(offreType.getLstComps());
        return scoreEmploi;
    }

    @Override
    public void enregistrer() {
        //String v_titre, String v_region, int v_exp, int v_salMin, int v_salMax, HashMap<Competence, CompType> tblComps
        int compsSize = m_tblComps.size();
        //System.out.println("size" + m_tblComps.size());
        //System.out.println(m_tblComps);
        String compstr = "";

        Iterator iter = m_tblComps.keySet().iterator();
        while (iter.hasNext()) {
            Competence key = (Competence) iter.next();
            compstr += key.getNomComp() + Constant.m_compTypeDelim;
            System.out.println("saved compstr :" + compstr);

            compstr += m_tblComps.get(key).getLibType() + Constant.m_compDelim;
        }

        int tmplen = compstr.length();
        if (tmplen > 0 && compstr.substring(tmplen - 1, tmplen) == Constant.m_compDelim) {
            compstr = compstr.substring(0, tmplen - 1);
        }

        String content = m_titre + Constant.m_itemDelim
                + m_region.getRegnom() + Constant.m_itemDelim
                + m_experience + Constant.m_itemDelim
                + m_salairemin + Constant.m_itemDelim
                + m_salairemax + Constant.m_itemDelim + compstr;
        try {
            File file = new File(Constant.m_offreList);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String scoreAdequation(OffreType offretype) {
        String score;
        //score parfait est 16=10+5+1
        //la pourcentage : c'est pour garder 2 chiffres apres vircule 
        score = String.format("%.2f", ((this.scoreTotal(offretype)) / 16) * 100) + "%";
        return score;
    }

}
