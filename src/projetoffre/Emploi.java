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


    // Création du constructeur Emploi
    public Emploi(int m_experience, int m_salairemin, int m_salairemax, String titre, String region) {
        //On définit une nouvelle expérience, un nouveau salaireMin, un nouveau salaireMax ainsi qu'un titre et une région
        super(titre, region);
        this.m_experience = m_experience;
        this.m_salairemin = m_salairemin;
        this.m_salairemax = m_salairemax;
    }
        
        
    //Création d'une méthode pour pouvoir calculer le score du Salaire
    public double scoreSalaire(int salaireChercher) {
       //On initialise le scoreSalaire à 0
        double scoreSalaire = 0;        
            scoreSalaire = 5 - ((salaireChercher - this.getSalairemax()) / 1000);
            System.out.println("score Salaire1 : " + scoreSalaire);
            return scoreSalaire;       
        
    }
    
   //Création d'une méthode pour pouvoir calculer le score total
   public double scoreTotal(double scoreCompetences, int scoreGeographique, double scoreSalaire ){
       //On initialise le scoreEmploi à 0
        double scoreEmploi = 0;
        scoreEmploi = scoreCompetences + scoreGeographique + scoreSalaire;
        return scoreEmploi;
    }   
}
