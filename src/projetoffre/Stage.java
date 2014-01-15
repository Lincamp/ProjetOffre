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

//Création de la classe Stage
public class Stage extends Offre {
    //attributs

    //methodes
//    public Stage() {
//    }

    
    // Création 
    public Stage(String titre, String region) {
        super(titre, region);
    }
    
    

    //héritage
//    public double scoreStage(double scoreCompetences, int scoreGeographique) {
//        double scoreStage = 0;
//        scoreStage = scoreCompetences + scoreGeographique;
//        return scoreStage;
//    }

    @Override
    // Ici on a l'héritage de la classe parente (offre), qui nous permet de calculer le score total pour un stage selon les données sasies par lutilisateur
    //( en fonction de la région et des compétences choisis)
    public double scoreTotal(OffreType offreType) {
        //To change body of generated methods, choose Tools | Templates.
        double scoreStage = 0;      
        scoreStage = this.scoreCompetencesHash(offreType.getLstComps()) + this.scoreGeographique(offreType);
        return scoreStage;
    }
}
