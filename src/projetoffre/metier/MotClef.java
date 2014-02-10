/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetOffre.metier;

/**
 *
 * @author Doro
 */

//Création de la classe MotClef
public class MotClef {
    //Création de l'attribut m_libelle (contient le mot clef)
    String m_libelle;
    
    //Création de la methode get (récupère les libellés des mots clefs)
    public String getLibelle() {
        return m_libelle;
    }

    //Création du  constructeur MotClef
    public MotClef(String libelle) {
        //On définit un nouveau libellé
        this.m_libelle = libelle;
    }
}
