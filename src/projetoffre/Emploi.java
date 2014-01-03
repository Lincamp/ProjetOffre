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
public class Emploi extends Offre {
    //attributs
    int experience;
    int salairemin;
    int salairemax;
    
    //methodes
    public int getExperience() {
        return experience;
    }

    public int getSalairemin() {
        return salairemin;
    }

    public int getSalairemax() {
        return salairemax;
    }

    public Emploi(String titreemp,String regemp,int experience, int salairemin, int salairemax,ArrayList<Competence> c ){
        this.titre = titreemp;
        this.region = regemp;
        this.experience = experience;
        this.salairemin = salairemin;
        this.salairemax = salairemax;       
        this.lstcomps = c;
    }
    
  
    public double scoreSalaire (int salaireChercher, ArrayList<Emploi> lstEmploiTrouve){
       double scoreSalaire=0;
       
       for(int i= 0; i< lstEmploiTrouve.size(); i ++){
       scoreSalaire =0;
       scoreSalaire= 5 -((salaireChercher - lstEmploiTrouve.get(i).getSalairemax())/1000);
        System.out.println("score Salaire1 : " +  scoreSalaire); return scoreSalaire; 
       }
          return scoreSalaire; // ici on affiche que le dernier résultat, on doit faire en sorte qu'il affiche tous les résultats dans l'interface !!!! 
   }
    public double scoreEmploi (double scoreCompetences, int scoreGeographique, double scoreSalaire){
        double scoreEmploi =0;
        scoreEmploi = scoreCompetences + scoreGeographique + scoreSalaire;
        return scoreEmploi;
    }

    
}    

