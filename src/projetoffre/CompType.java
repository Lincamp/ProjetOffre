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
//On crée la classe CompType
public class CompType {
    private String m_libType;

    
    //On récupère le m_libType
    public String getLibType() {
        return m_libType;
    }

    
    public void setLibType(String m_libType) {
        this.m_libType = m_libType;
    }
  
// On crée le constructeur CompType
    public CompType(String libType) {
        this.m_libType = libType;
    }
    
    
    
}
