/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre.noyaufonctionnel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import projetoffre.Competence;
import projetoffre.Emploi;
import projetoffre.OffreType;
import projetoffre.Region;
import projetoffre.Stage;

/**
 *
 * @author 20900686
 */

//Création de la classe NoyauFonctionnel
public class NoyauFonctionnel {

ArrayList<Emploi> m_lstEmplois;
ArrayList<Stage> m_lstStages;
ArrayList<Region> m_lstRegions;
ArrayList<Competence> m_lstCompts;



public Emploi enregistrerEmploi (int exp, int salaireMin, int salaireMax, String titre, String region){
    Emploi emploiCree = new Emploi(exp, salaireMin, salaireMax, titre, region);    
    return  emploiCree;
}

public Stage enregistrerStage (String titre, String region){
    Stage stageCree = new Stage(titre, region);
    return stageCree;
}

public void rechercherEmploi (Region regChercher, int salaire, ArrayList<Competence> lstCompsCherche){
    for(int i = 0; i< this.m_lstEmplois.size();i++){
//       double scoreSalaire = this.m_lstEmplois.get(i).scoreSalaire(salaire);
   //    double scoreCompt = this.m_lstEmplois.get(i).scoreCompetencesHash(this.m_lstEmplois.get(i), lstCompsCherche);
//       int scoreRegion = this.m_lstEmplois.get(i).scoreGeographique(regChercher);
     //  double scoreTotal = this.m_lstEmplois.get(i).scoreTotal(scoreCompt, scoreRegion, scoreSalaire );   
      // System.out.println(this.m_lstEmplois.get(i).getM_titre() + scoreSalaire + scoreCompt + scoreRegion + scoreTotal);
    }    
}

public void rechercherOffre (OffreType offreType){
    for(int i = 0; i< this.m_lstEmplois.size();i++){
//       double scoreSalaire = this.m_lstEmplois.get(i).scoreSalaire(offreType.getSalaireEspere());
     //  double scoreCompt = this.m_lstEmplois.get(i).scoreCompetencesHash(this.m_lstEmplois.get(i), offreType.getLstComps());
//       int scoreRegion = this.m_lstEmplois.get(i).scoreGeographique(offreType.getReg());
       //double scoreTotal = this.m_lstEmplois.get(i).scoreTotal(scoreCompt, scoreRegion, scoreSalaire ); //à modifier  
      // System.out.println(this.m_lstEmplois.get(i).getM_titre() + scoreSalaire + scoreCompt + scoreRegion + scoreTotal);
    }    
}




    
}
