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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        if(offreType.getSalaireEspere()>= this.getSalairemax()){
             scoreSalaire = 5 - ((offreType.getSalaireEspere() - this.getSalairemax()) / 1000);
             if(scoreSalaire<0){
                 return 0;
             }
             else{
                 return scoreSalaire;
             }
        }
        else{
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
                compstr += key.getNomComp() + m_compTypeDelim;
                System.out.println("saved compstr :" + compstr);

                compstr += m_tblComps.get(key).getLibType() + m_compDelim;
            }
            
            if (compstr.length() > 0 && compstr.charAt(compstr.length() - 1)==m_compDelim) {
              compstr = compstr.substring(0, compstr.length()-1);
            } 

            String content = m_titre + m_itemDelim
                    + m_region.getRegnom() + m_itemDelim
                    + m_experience + m_itemDelim
                    + m_salairemin + m_itemDelim
                    + m_salairemax + m_itemDelim + compstr;        
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
