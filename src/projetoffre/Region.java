/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Doro
 */
public class Region {

    //attributs
    String m_regnom;
    Set<String> m_regassocie;
    ArrayList<Offre> m_lstoffs;
    private static boolean m_inited;
    private static Vector m_comboBoxItems = new Vector();
    static final char m_regionDelim = ':';
    static final char m_procheDelim = ';';
    
    // ArrayList<regassocie> lstregs;

    public Region() {
        m_inited = false;
        m_comboBoxItems = new Vector();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Region(String fileStr) {
        

    }
    
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

    public DefaultComboBoxModel getRegionListModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(m_comboBoxItems);
        return model;
    }

    private void initRegionList() {
        if (!m_inited) {
            try (BufferedReader br = new BufferedReader(new FileReader("data/regionlist.txt"))) {
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("##### " + sCurrentLine + "\t#####");
                    m_comboBoxItems.add(sCurrentLine);
                }
                m_inited = true;
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }

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
