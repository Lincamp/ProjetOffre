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
public class Region {
    //attributs
    String regnom;
    ArrayList<Offre> lstoffs;
    ArrayList<Region> lstregs;

    public String getRegnom() {
        return regnom;
    }

    public Region(String regnom) {
        this.regnom = regnom;
        this.lstoffs = new ArrayList(); 
        this.lstregs = new ArrayList();
    }
    
    
}
