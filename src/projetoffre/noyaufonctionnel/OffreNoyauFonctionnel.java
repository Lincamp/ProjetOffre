/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre.noyaufonctionnel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import projetoffre.Emploi;
import projetoffre.Region;
import projetoffre.Stage;

/**
 *
 * @author Doro
 */
public class OffreNoyauFonctionnel {

    private static final HashMap<String, ArrayList<Emploi>> m_tblEmplois;
    private static final HashMap<String, ArrayList<Stage>> m_tblStages;
    private static boolean m_offInit;
    static final String m_stageDelim = "-1";

    static final String m_itemDelim = ";";
    static final String m_compDelim = "|";
    static final String m_compTypeDelim = ":";
    static final String m_offreList = "data/offrelist.txt";

//     static final String m_itemDelim = ";";
//    static final String m_compDelim = "|";
//    static final String m_compTypeDelim = ":";
//    static final String m_offreList = "data/offrelist.txt"; 
   
    static {
        m_offInit = false;
        m_tblEmplois = new HashMap<>();
        m_tblStages = new HashMap<>();
    }

    public OffreNoyauFonctionnel() {
        init();
    }

    private void init() {
        creerTblEmploi();

    }

    public static HashMap<String, ArrayList<Emploi>> getTblEmplois() {
        return m_tblEmplois;
    }

    public static HashMap<String, ArrayList<Stage>> getTblStages() {
        return m_tblStages;
    }

    private void creerTblEmploi() {
        if (!m_offInit) {
            try (BufferedReader br = new BufferedReader(new FileReader("data/offrelist.txt"))) {
                String sCurrentLine;
                m_tblEmplois.clear();              
                String[] results;
                
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("#####" + sCurrentLine + "\t#####line from offrelist.txt (Nayau)");
                    results = sCurrentLine.split(m_itemDelim, -1);
                    if(results[2] == "-1"){
                    //    m_regnom = results[1];
                   //     this.getTblEmplois().
                    }
                   // titre = results[0];
                  //  compstr = 
//                    this.m_tblEmplois.add(Emploi(sCurrentLine));
                }
                Region reg = new Region(sCurrentLine);
                String regnom = reg.getRegnom();

                // avoid duplicates
                if (!m_tblEmplois.containsKey(regnom)) {
                    // m_regVecNom.add(regnom);
                }
//                m_tblEmplois.put(regnom, reg);

                System.out.println("regTbl size:" + m_tblEmplois.size() + " (Noyau)");
                //System.out.println("regVec size:" + m_regVecNom.size() + " (Noyau)");

                m_offInit = true;
                //DefaultComboBoxModel model = new DefaultComboBoxModel(m_regVecNom);
                //cmbReg.setModel(model);
            } catch (IOException ee) {
                ee.printStackTrace();
            }

            System.out.println("region map:" + m_tblEmplois + " (Noyau)");
        }
    }
}
