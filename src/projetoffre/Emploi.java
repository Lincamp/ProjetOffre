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

    public Emploi(String titreemp,String regemp,int experience, int salairemin, int salairemax, ArrayList<Competence> c) {
        this.titre = titreemp;
        this.region = regemp;
        this.experience = experience;
        this.salairemin = salairemin;
        this.salairemax = salairemax;       
        this.lstcomps = c;
    }
    
    
}
