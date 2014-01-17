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
import projetoffre.Constant;
import projetoffre.Emploi;
import projetoffre.Region;
import projetoffre.Stage;

/**
 *
 * @author Doro
 */
public class OffreNoyauFonctionnel {

    private static HashMap<String, ArrayList<Emploi>> m_tblEmplois;
    private static HashMap<String, ArrayList<Stage>> m_tblStages;
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
        creerTblOffre();
    }

    public static HashMap<String, ArrayList<Emploi>> getTblEmplois() {
        return m_tblEmplois;
    }

    public static HashMap<String, ArrayList<Stage>> getTblStages() {
        return m_tblStages;
    }

    private void creerTblOffre() {
        if (!m_offInit) {
            try (BufferedReader br = new BufferedReader(new FileReader(Constant.m_offreList))) {
                String sCurrentLine;
                m_tblEmplois.clear();
                String[] results;

                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("#####" + sCurrentLine + "\t#####line from offrelist.txt (Nayau)");
//                    results = sCurrentLine.split(m_itemDelim, -1);

                    results = sCurrentLine.split(Constant.m_itemDelim, -1);

                    // Stage has experience -1
                    if (results[2] == "-1") {

                    } else {
                        Emploi tmpEmploi = new Emploi(sCurrentLine);
                        String tmpRegStr = tmpEmploi.getReg().getRegnom();

                        ArrayList<Emploi> lstEmploi = m_tblEmplois.get(tmpRegStr);
                        if (lstEmploi == null) {
                            m_tblEmplois.put(tmpRegStr, lstEmploi = new ArrayList<Emploi>());
                        }
                        lstEmploi.add(tmpEmploi);
                    }
                }

                System.out.println("regTbl size:" + m_tblEmplois.size() + " (NoyauOffre)");
                System.out.println("regTbl size:" + m_tblStages.size() + " (NoyauOffre)");
                //System.out.println("regVec size:" + m_regVecNom.size() + " (NoyauOffre)");

                m_offInit = true;
            } catch (IOException ee) {
                ee.printStackTrace();
            }

            System.out.println("region map:" + m_tblEmplois + " (NoyauOffre)");
        }
    }
}
