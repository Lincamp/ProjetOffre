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
public class Competence {
    //attributs
    String nomComp;
    boolean obligatoire;
//    ArrayList<MotClef> lstmots;

    public String getNomComp() {
        return nomComp;
    }

    public boolean isObligatoire() {
        return obligatoire;
    }

    
    public Competence(String nomComp, boolean oblig) {
        this.nomComp = nomComp;
        this.obligatoire = oblig;
//        this.lstmots = new ArrayList();
    }
}
