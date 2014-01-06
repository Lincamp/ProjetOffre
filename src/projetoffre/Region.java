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
    String m_regnom;
    Set<String> m_regassocie;
    ArrayList<Offre> m_lstoffs;
    // ArrayList<regassocie> lstregs;
    
    public String getRegnom() {
        return m_regnom;
    }

    public Region(String regnom, Set<String> regassocie) {
        this.m_regnom = regnom;
        this.m_lstoffs = new ArrayList(); 
        regassocie = new HashSet<String>();
        this.m_regassocie = regassocie;
//        this.lstregs = new ArrayList();
    }
}
