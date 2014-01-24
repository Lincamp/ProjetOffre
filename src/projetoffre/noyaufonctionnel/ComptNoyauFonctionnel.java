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
import projetoffre.CompType;
import projetoffre.Competence;
import projetoffre.Constant;
import projetoffre.MotClef;

/**
 *
 * @author Doro
 */
public class ComptNoyauFonctionnel {

    private static Vector m_comptVecNom;
    private static HashMap<String, Competence> m_tblCompts;
    private static ArrayList<MotClef> m_lstMotClefs;
    private static boolean m_comptInit;
    private static boolean m_motclefInit;
    private static CompType m_oblig;
    private static CompType m_souh;

    static {
        m_comptVecNom = new Vector();
        m_tblCompts = new HashMap<>();
        m_oblig = new CompType("obligatoire");
        m_souh = new CompType("souhaitee");
        m_lstMotClefs = new ArrayList();
        m_comptInit = false;
        m_motclefInit = false;
    }

    public static CompType getOblig() {
        return m_oblig;
    }

    public static CompType getSouh() {
        return m_souh;
    }

    public ComptNoyauFonctionnel() {
        // Needs correction, move to the declaration part.
        init();
    }

    public static ArrayList<MotClef> getLstMotClefs() {
        return m_lstMotClefs;
    }

    private void init() {
        creerMotClef();        
        creerTblCompetence();
    }

    public static Vector getComptVecNom() {
        return m_comptVecNom;
    }

    public static HashMap<String, Competence> getTblCompetences() {
        return m_tblCompts;
    }

    private void creerMotClef() {
//System.out.println(m_motclefInit + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmotcleflist.txt (NoyauComp)");        
        if (!m_motclefInit) {
            try (BufferedReader br = new BufferedReader(new FileReader(Constant.m_motClefList))) {
                String sCurrentLine;
                m_lstMotClefs.clear();
//                m_tblCompts.clear();
                while ((sCurrentLine = br.readLine()) != null) {
//                    System.out.println(sCurrentLine + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmotcleflist.txt (NoyauComp)");
                    MotClef mot = new MotClef(sCurrentLine);
                    m_lstMotClefs.add(mot);
                }
                m_motclefInit = true; //on doit le vérifier ou non?             
            } catch (IOException ee) {
                ee.printStackTrace();
            }
//            System.out.println("motclef list:" + m_lstMotClefs + "size:" + m_lstMotClefs.size() + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm (NoyauComp)");
        }
    }

    private void creerTblCompetence() {
        if (!m_comptInit) {
            try (BufferedReader br = new BufferedReader(new FileReader(Constant.m_compList))) {
                String sCurrentLine;
                m_comptVecNom.clear();
                m_tblCompts.clear();
                while ((sCurrentLine = br.readLine()) != null) {
//                    System.out.println("#####" + sCurrentLine + "\t#####line from complist.txt (NoyauComp)");
                    Competence comp = new Competence(sCurrentLine);
                    String compnom = comp.getNomComp();
//                    System.out.println("##### comp.getNomcomp" + compnom + "\t#####line from complist.txt (NoyauComp)");

                    // avoid duplicates
                    if (!m_tblCompts.containsKey(compnom)) {
                        m_comptVecNom.add(compnom);
                    }
                    m_tblCompts.put(compnom, comp);

//                    System.out.println("compTbl size:" + m_tblCompts.size() + " (NoyauComp)");
//                    System.out.println("compVec size:" + m_comptVecNom.size() + " (NoyauComp)");
                }
                m_comptInit = true;
                //DefaultComboBoxModel model = new DefaultComboBoxModel(m_comptVecNom);
                //cmbReg.setModel(model);
            } catch (IOException ee) {
                ee.printStackTrace();
            }

//            System.out.println("competence map:" + m_tblCompts + " (NoyauComp)");
        }
    }
}
