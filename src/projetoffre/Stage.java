/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetoffre;

/**
 *
 * @author Doro
 */
public class Stage extends Offre {
    //attributs
    
    //methodes
       public Stage() {
    }

//héritage
public double scoreStage (double scoreCompetences, int scoreGeographique){
    double scoreStage =0;
        scoreStage = scoreCompetences + scoreGeographique;
        return scoreStage;
}
}
