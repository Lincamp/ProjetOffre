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
            File file = new File(m_offreList);
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
}
