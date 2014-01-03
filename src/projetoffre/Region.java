/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetoffre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Doro
 */
public class Region {
    //attributs
    String regnom;
    Set<String> regassocie;
    ArrayList<Offre> lstoffs;
    // ArrayList<regassocie> lstregs;
    

    public String getRegnom() {
        return regnom;
    }

    public Region(String regnom,Set<String> regassocie) {
        this.regnom = regnom;
        this.lstoffs = new ArrayList(); 
          regassocie= new HashSet<String>();
        this.regassocie = regassocie;
//        this.lstregs = new ArrayList();
    }
    
   
     
    
}
