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
import static projetoffre.Offre.m_compTypeDelim;
import projetoffre.noyaufonctionnel.RegionNoyauFonctionnel;

/**
 *
 * @author Doro
 */
//Création de la classe Stage
public class Stage extends Offre {
    //attributs

    //methodes
//    public Stage() {
//    }
    // Création 
    public Stage(String titre, Region region, HashMap<Competence, CompType> tblComps) {
        super(titre, region, tblComps);
    }

//    public Stage() {
//    }
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
            compstr += key.getNomComp() + m_compTypeDelim;
            System.out.println("saved compstr :" + compstr);

            compstr += m_tblComps.get(key).getLibType() + m_compDelim;
        }

       
           int tmplen = compstr.length();
        if (tmplen > 0 && compstr.substring(tmplen - 1, tmplen) == m_compDelim) {
            compstr = compstr.substring(0, tmplen - 1);
        }

        String content = m_titre + m_itemDelim
                + m_region.getRegnom() + m_itemDelim
                + "-1" + m_itemDelim
                + "-1" + m_itemDelim
                + "-1" + m_itemDelim + compstr;
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
    
    
    public Stage(String fileStr) {
        super(fileStr);

        String[] results, rescomps;

        results = fileStr.split(Constant.m_itemDelim, -1);

        if (results.length == 6) {
            this.m_titre = results[0];
            // m_region =          
            System.out.println(results[1] + " ## " + RegionNoyauFonctionnel.getTblRegions());
            System.out.println(results[1] + " ## " + RegionNoyauFonctionnel.getTblRegions().get(results[1]));
            this.m_region = RegionNoyauFonctionnel.getTblRegions().get(results[1]);        
            String compStr = results[5];
            rescomps = fileStr.split(Constant.m_compDelim,-1);
          //  for(String[] rescomp ; rescomps){
                
          //  }
            
//            this.m_tblComps = new 
        }
        else
        {
            System.out.println("line in " + Constant.m_offreList + " does not have 6 fields (Emploi.java)");
        }
//        System.out.println("Separated values:" + results[6].indexOf("|") + "@" + results[6].substring(1 + results[6].indexOf("/")) + "(Emploi.java)");
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println("");
    }
    
        public String scoreAdequation(OffreType offretype) {
        String score;
        //score parfait est 11=10+1
        //la pourcentage : c'est pour garder 2 chiffres apres vircule 
        score = String.format("%.2f", ((this.scoreTotal(offretype))/11)*100) + "%";
        return score;
    }
    
}
