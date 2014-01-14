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

// Création de la classe Region
public class Region {

    //Création des attributs
    String m_regnom;
    
    // Set contient le nom de toutes les régions associées a cette région, ce qui permet d'éviter la redondance d'information
    Set<String> m_regassocie;
    ArrayList<Offre> m_lstoffs;
//    private static boolean m_inited;
//    private static Vector m_comboBoxItems = new Vector();
    static final char m_regionDelim = ':';
    // les ";" permettent de séparer les régions associées entre elles
    static final String m_procheDelim = ";";

   
    // Création d
    public Region() {
        m_regassocie = new HashSet<String>();
    }
    // Création du constructeur Region 
    // Le "String fileStr" permet de récupérer toutes les lignes contenus dans un dossier texte (regionlist.txt)
    public Region(String fileStr) {
        m_regassocie = new HashSet<String>();
        int pos;
        String procheStr;
        // On vérifie si le nombre de carractère de cette ligne est suppérireur à 0
        if (fileStr.length() > 0) {
            // On trouve ou se situe les ":" 
            pos = fileStr.indexOf(m_regionDelim);
            
            // Si on ne trouve pas les ":" on récupère tous les carractères se situant avant les ":" et on les met dans la variable "m_regnom"
            if (pos == -1) {
                this.m_regnom = fileStr;                        
                        } 
            else
            {
                // Si on trouve les ":" alors on récupère tous les carractères se situant avant les ":" et on les met dans la variable "m_regnom"
                this.m_regnom = fileStr.substring(0, pos);
                // Tous les carractères se situant apres les ":" représentent les régions proches, ils sont mit dans la variable "procheStr"
                procheStr = fileStr.substring(pos + 1);
 
                System.out.println("=====================================");
                // On récupère tous les carractères séparés par les ";", puis on les place dans la variable "regProche". On réitère l'opération jusqu'a la fin de la ligne
                for (String regProche: procheStr.split(m_procheDelim)){
                    System.out.println("proche of " + m_regnom + ":" + regProche + " (region.java)");
                    this.m_regassocie.add(regProche);
                } 
                System.out.println("=====================================");
            }
        } 
        else {
            
        }
    }
    // Création de la méthode get (récupère le nom de la région)
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

//    public DefaultComboBoxModel getRegionListModel() {
//        DefaultComboBoxModel model = new DefaultComboBoxModel(m_comboBoxItems);
//        return model;
//    }

//    private void initRegionList() {
//        if (!m_inited) {
//            try (BufferedReader br = new BufferedReader(new FileReader("data/regionlist.txt"))) {
//                String sCurrentLine;
//                while ((sCurrentLine = br.readLine()) != null) {
//                    System.out.println("##### " + sCurrentLine + "\t#####");
//                    m_comboBoxItems.add(sCurrentLine);
//                }
//                m_inited = true;
//            } catch (IOException ee) {
//                ee.printStackTrace();
//            }
//        }
//    }

//    private void initRegionList() {
//        Vector comboBoxItems = new Vector();
//
//        try (BufferedReader br = new BufferedReader(new FileReader("data/regionlist.txt"))) {
//            String sCurrentLine;
//            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println("##### " + sCurrentLine + "\t#####");
//                comboBoxItems.add(sCurrentLine);
//            }
//            DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
//            cmbReg.setModel(model);
//        } catch (IOException ee) {
//            ee.printStackTrace();
//        }
//    }
}
