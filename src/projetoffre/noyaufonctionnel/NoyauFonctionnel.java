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



public Emploi enregistrerEmploi (int exp, int salaireMin, int salaireMax, String titre, Region region){
    Emploi emploiCree = new Emploi(exp, salaireMin, salaireMax, titre, region); 
    this.m_lstEmplois.add(emploiCree);
    return  emploiCree;
}

public Stage enregistrerStage (String titre, Region region){
    Stage stageCree = new Stage(titre, region);
    this.m_lstStages.add(stageCree);
    return stageCree;
}

 public Object[][] rechercherStages(Region reg,ArrayList<Competence> lesComps){
        ArrayList<Stage> lesStages=new ArrayList();
        Object[][] resultat ;
        Stage max;
        
        for (Stage stage : m_lstStages) { 
           for (Competence com : lesComps) {
                if((stage.getReg()==reg)&&(stage.getTblComps().containsKey(com)) ){
                    lesStages.add(stage);
                }
            }            
        }
        
        resultat = new Object[lesStages.size()][3];
        for (int i = 0; i <lesStages.size(); i++) {
            for (int j = 0; j <lesStages.size(); j++) {
                max=lesStages.get(0);
                if((lesStages.get(j).scoreCompetencesHash(lesComps))<(lesStages.get(j+1).scoreCompetencesHash(lesComps))){
                    max=lesStages.get(j+1);
                }
            }
        
            resultat[i][0] = lesStages.get(i).getTitre();
            resultat[i][1] = lesStages.get(i).getReg().getRegnom();
            resultat[i][2] = lesStages.get(i).scoreCompetencesHash(lesComps);
            lesStages.remove(i);
        }
        return resultat;
    }
    
    public Object[][] rechercherEmplois(Region reg,ArrayList<Competence> lesComps){
        ArrayList<Emploi> lesEmplois=new ArrayList();
        Object[][] resultat;
        Emploi max;
        
        
        for (Emploi emploi : m_lstEmplois) {
           for (Competence competence : lesComps) {
                if((emploi.getReg()==reg)&&(emploi.getTblComps().containsKey(competence))){
                    lesEmplois.add(emploi);
                }
            }            
        }
        resultat = new Object[lesEmplois.size()][5];
        
        for (int i = 0; i <lesEmplois.size(); i++) {
            for (int j = 0; j <lesEmplois.size(); j++) {
                max=lesEmplois.get(0);
                if((lesEmplois.get(j).scoreCompetencesHash(lesComps))<(lesEmplois.get(j+1).scoreCompetencesHash(lesComps))){
                    max=lesEmplois.get(j+1);
                }
            }
               
            resultat[i][0] = lesEmplois.get(i).getTitre();
            resultat[i][1] = lesEmplois.get(i).getReg().getRegnom();
            resultat[i][2] = lesEmplois.get(i).getExperience();
            resultat[i][3] = lesEmplois.get(i).getSalairemin();
            resultat[i][4] = lesEmplois.get(i).scoreCompetencesHash(lesComps);
            lesEmplois.remove(i);
        }
    
        return resultat;
    }






    
}
