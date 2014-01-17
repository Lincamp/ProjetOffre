/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre.noyaufonctionnel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import projetoffre.Constant;
import projetoffre.Region;

/**
 *
 * @author Doro
 */
public class RegionNoyauFonctionnel {
//    private ArrayList<Action> lstActions;
//    private ArrayList<Jour> lstJours;
//    private HashMap<String, Portefeuille> lstPortefeuilles;

    private static final Vector m_regVecNom;
    private static final HashMap<String, Region> m_tblRegions;
    private static boolean m_regInit;


    static {
        m_regInit = false;
        m_regVecNom = new Vector();
        m_tblRegions = new HashMap<>();        
    }
    
    public RegionNoyauFonctionnel() {
        //this.m_regInit = false;
        //this.m_regVecNom = new Vector();
        //this.m_tblRegions = new HashMap<>();
        init();
    }

    private void init() {
        creerTblRegion();
    }

    public static Vector getRegVecNom() {
        return m_regVecNom;
    }

    public static HashMap<String, Region> getTblRegions() {
        if(m_tblRegions != null) {
            return m_tblRegions;
        }
        else
        {
            creerTblRegion();
            return m_tblRegions;
        }
    }

    private static void creerTblRegion() {
        if (!m_regInit) {
            try (BufferedReader br = new BufferedReader(new FileReader(Constant.m_regionList))) {
                String sCurrentLine;
                m_regVecNom.clear();
                m_tblRegions.clear();
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("#####" + sCurrentLine + "\t#####line from regionlist.txt (NoyauReg)");
                    Region reg = new Region(sCurrentLine);
                    String regnom = reg.getRegnom();

                    // avoid duplicates
                    if (!m_tblRegions.containsKey(regnom)) {
                        m_regVecNom.add(regnom);
                    }
                    m_tblRegions.put(regnom, reg);

                    System.out.println("regTbl size:" + m_tblRegions.size() + " (NoyauReg)");
                    System.out.println("regVec size:" + m_regVecNom.size() + " (NoyauReg)");
                }
                m_regInit = true;
                //DefaultComboBoxModel model = new DefaultComboBoxModel(m_regVecNom);
                //cmbReg.setModel(model);
            } catch (IOException ee) {
                ee.printStackTrace();
            }

//            System.out.println("region map:" + m_tblRegions + " (NoyauReg)");
        }
    }
}
