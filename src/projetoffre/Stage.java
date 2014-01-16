/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.HashMap;

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
    public Stage(String titre, Region region) {
        super(titre, region);
    }

    public Stage() {
    }
    
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
          boolean egale=false;
        if(this.getTitre().equals(((Stage)obj).getTitre())){
            if(this.getReg().equals(((Stage)obj).getReg())){
                egale=true;
            }
        }
        return egale; 
    }
    
    
    
}
