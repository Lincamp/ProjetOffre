/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Doro
 */
public class NoyauFonctionnel {

//    private ArrayList<Action> lstActions;
//    private ArrayList<Jour> lstJours;
//    private HashMap<String, Portefeuille> lstPortefeuilles;
    private static Vector m_regVecNom;
    private static HashMap<String, Region> m_tblRegions;
    private static boolean m_regInit;
    static final char m_regionDelim = ':';
    static final String m_procheDelim = ";";

    public NoyauFonctionnel() {
        this.m_regInit = false;
        this.m_regVecNom = new Vector();
        this.m_tblRegions = new HashMap<>();
//        this.lstActions = new ArrayList<>();
//        this.lstJours = new ArrayList<>();
//        this.lstPortefeuilles = new HashMap<>();
        init();
    }

    private void init() {
        creerTblRegion();
    }

    public static Vector getRegVecNom() {
        return m_regVecNom;
    }

    public static HashMap<String, Region> getTblRegions() {
        return m_tblRegions;
    }

    private void creerTblRegion() {
        if (!m_regInit) {
            try (BufferedReader br = new BufferedReader(new FileReader("data/regionlist.txt"))) {
                String sCurrentLine;
                m_regVecNom.clear();
                m_tblRegions.clear();
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("#####" + sCurrentLine + "\t#####line from regionlist.txt (Nayau)");
                    Region reg = new Region(sCurrentLine);

                    // avoid duplicates
                    if (!m_tblRegions.containsKey(sCurrentLine)) {
                        m_regVecNom.add(reg.getRegnom());
                    }
                    m_tblRegions.put(sCurrentLine, reg);

                    System.out.println("regTbl size:" + m_tblRegions.size() + " (Noyau)");
                    System.out.println("regVec size:" + m_regVecNom.size() + " (Noyau)");
                }
                m_regInit = true;
                //DefaultComboBoxModel model = new DefaultComboBoxModel(m_regVecNom);
                //cmbReg.setModel(model);
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }
//    public Jour creerJour(int annee, int noJour) {
//        Jour jourACreer;
//
//        jourACreer = new Jour(annee, noJour);
//        if (this.lstJours.contains(jourACreer) == false) {
//            this.lstJours.add(jourACreer);
//        }
//
//        return jourACreer;
//    }

//    public Action creerAction(String nom) {
//        Action actACreer;
//
//        actACreer = new Action(nom);
//        if (this.lstActions.contains(actACreer) == false) {
//            this.lstActions.add(actACreer);
//        }
//        return actACreer;
//    }
//    public Portefeuille creerPortefeuille(String nom) {
//        Portefeuille porACreer;
//
//        porACreer = new Portefeuille(nom);
//        if (this.lstPortefeuilles.containsKey(nom) == false) {
//            this.lstPortefeuilles.put(nom, porACreer);
//        }
//        return porACreer;
//    }
}
