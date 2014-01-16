/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.HashMap;

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

    public Emploi() {
        super();
    }
    
    
    
//        public void ajouterComp(Competence comp, CompType compType) {       
//        m_tblComps.put(comp, compType);      
//    }
//
    @Override
    public HashMap<Competence, CompType> getTblComps() {
        return super.getTblComps(); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    // Création du constructeur Emploi
    public Emploi(int m_experience, int m_salairemin, int m_salairemax, String titre, Region region) {
        //On définit une nouvelle expérience, un nouveau salaireMin, un nouveau salaireMax ainsi qu'un titre et une région
        super(titre, region);
        this.m_experience = m_experience;
        this.m_salairemin = m_salairemin;
        this.m_salairemax = m_salairemax;
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
   
   
   
}
