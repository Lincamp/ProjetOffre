/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetOffre.metier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import projetoffre.noyaufonctionnel.ComptNoyauFonctionnel;
import projetoffre.noyaufonctionnel.OffreNoyauFonctionnel;
import projetoffre.noyaufonctionnel.RegionNoyauFonctionnel;

/**
 *
 * @author Doro
 */
//Création de la classe Stage
public class Stage extends Offre {
    //attributs

//    public Stage() {
//        super();
//    }

    //methodes
//    public Stage() {
//    }
    // Création 
    public Stage(String titre, Region region, HashMap<Competence, CompType> tblComps) {
        super(titre, region, tblComps);
    }

    public void clear()
    {
        // TODO
//        super.clear();
        this.m_titre = "";
        this.m_region = null;
        this.m_tblComps.clear();
    }
//    public Stage() {
//    }
    @Override
    public void ajouterComp(Competence comp, CompType compType) {
        m_tblComps.put(comp, compType);
    }

    @Override
    public HashMap<Competence, CompType> getTblComps() {
        return super.getTblComps(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    // Ici on a l'héritage de la classe parente (offre), qui nous permet de calculer le score total pour un stage selon les données sasies par lutilisateur
    //( en fonction de la région et des compétences choisis)
    public double scoreTotal(OffreType offreType) {
        //To change body of generated methods, choose Tools | Templates.
        double scoreStage;
        scoreStage = this.scoreCompetencesHash(offreType.getLstComps()) + this.scoreGeographique(offreType);
        return scoreStage;
    }

    @Override
    public boolean equals(Object obj) {
        //To change body of generated methods, choose Tools | Templates.
        boolean egale = false;
        if (this.getTitre().equals(((Stage) obj).getTitre())) {
            if (this.getReg().equals(((Stage) obj).getReg())) {
                egale = true;
            }
        }
        return egale;
    }

    @Override
    public void enregistrer() {
//            int compsSize = m_tblComps.size();

        String compstr = "";

        Iterator iter = m_tblComps.keySet().iterator();
        while (iter.hasNext()) {
            Competence key = (Competence) iter.next();
            compstr += key.getNomComp() + Constant.m_compTypeDelim;
            System.out.println("saved compstr :" + compstr);

            compstr += m_tblComps.get(key).getLibType() + Constant.m_compDelim;
        }

        int tmplen = compstr.length();
        if (tmplen > 0 && (compstr.substring(tmplen - 1, tmplen) == null ? Constant.m_compDelim == null : compstr.substring(tmplen - 1, tmplen).equals(Constant.m_compDelim))) {
            compstr = compstr.substring(0, tmplen - 1);
        }

        String content = m_titre + Constant.m_itemDelim
                + m_region.getRegnom() + Constant.m_itemDelim
                + "-1" + Constant.m_itemDelim
                + "-1" + Constant.m_itemDelim
                + "-1" + Constant.m_itemDelim + compstr;
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
            OffreNoyauFonctionnel.ajouterStage(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage(String fileStr) {
        super(fileStr);
        Competence comp;
        CompType compType;

        String[] results, resComps;
        int pos;

        results = fileStr.split(Constant.m_itemDelim, -1);

        if (results.length == 6) {
            this.m_titre = results[0].trim();
            // m_region =          
//            System.out.println(results[1] + " ## " + RegionNoyauFonctionnel.getTblRegions());
//            System.out.println(results[1] + " ## " + RegionNoyauFonctionnel.getTblRegions().get(results[1]));
            this.m_region = RegionNoyauFonctionnel.getTblRegions().get(results[1].trim());
            String compStr = new String();
            // TODO pourquoi
            compStr = results[5].trim();
            resComps = compStr.split("\\" + Constant.m_compDelim, -1);
//            System.out.println(compStr);
//            System.out.println("Size of splited Competences: " + resComps.length);

            for (String resComp : resComps) {
//                System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" + resComp);
                pos = resComp.indexOf(Constant.m_compTypeDelim);
                String compNom = new String(resComp.substring(0, pos));
//                System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp" + resComp.substring(0, pos));
                comp = ComptNoyauFonctionnel.getTblCompetences().get(resComp.substring(0, pos));
                compStr = resComp.substring(pos + 1);
//                System.out.println("obliggggggggggggggggggggggggggggg" + compStr);
                if ("obligatoire".equals(compStr)) {
                    compType = ComptNoyauFonctionnel.getOblig();
                } else {
                    compType = ComptNoyauFonctionnel.getSouh();
                }
//                System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp" + ComptNoyauFonctionnel.getTblCompetences().size() + comp + "@" + compType);

                this.ajouterComp(comp, compType);
            }

//            this.m_tblComps = new 
        } else {
            this.clear();
//            System.out.println("line in " + Constant.m_offreList + " does not have 6 fields (Stage.java)");
        }
//        System.out.println("Separated values:" + results[6].indexOf("|") + "@" + results[6].substring(1 + results[6].indexOf("/")) + "(Emploi.java)");
        for (String result : results) {
//            System.out.println(result);
        }
//        System.out.println("");
    }

    public String scoreAdequation(OffreType offretype) {
        String score;
        //score parfait est 11=10+1
        //la pourcentage : c'est pour garder 2 chiffres apres vircule 
        score = String.format("%.2f", ((this.scoreTotal(offretype)) / 11) * 100) + "%";
        return score;
    }

    public void printOut() {
        System.out.println("===================================");
        System.out.println("Stage: stage.java");
        System.out.println(m_titre);
        System.out.println(m_region.getRegnom());
        Set setComps = this.m_tblComps.keySet();
        Competence setIterComps;
        Iterator itrComps = setComps.iterator();
        System.out.println("Size of competences:" + this.m_tblComps.size());
        while (itrComps.hasNext()) {
            setIterComps = (Competence) itrComps.next();
            System.out.print(setIterComps.getNomComp() + ":");
            System.out.println(m_tblComps.get(setIterComps).getLibType());
        }

        System.out.println("===================================");
    }
}
