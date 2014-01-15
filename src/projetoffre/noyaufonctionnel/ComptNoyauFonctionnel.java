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
import projetoffre.Competence;
import projetoffre.MotClef;

/**
 *
 * @author Doro
 */
public class ComptNoyauFonctionnel {

    private static Vector m_comptVecNom;
    public static HashMap<String, Competence> m_tblCompts;
    public static ArrayList<MotClef> m_lstMotClefs;
    private static boolean m_comptInit;
    private static boolean m_motclefInit;
    static final char m_regionDelim = ':';
    static final String m_procheDelim = ";";

    public ComptNoyauFonctionnel() {
        // Needs correction, move to the declaration part.
        this.m_comptInit = false;
        this.m_motclefInit = false;
        this.m_comptVecNom = new Vector();
        this.m_tblCompts = new HashMap<>();
        this.m_lstMotClefs = new ArrayList();
        init();
    }

    public static ArrayList<MotClef> getLstMotClefs() {
        return m_lstMotClefs;
    }

    private void init() {
        creerTblCompetence();
    }

    public static Vector getComptVecNom() {
        return m_comptVecNom;
    }

    public static HashMap<String, Competence> getTblCompetences() {
        return m_tblCompts;
    }

    private void creerMotClef() {
        if (!m_motclefInit) {
            try (BufferedReader br = new BufferedReader(new FileReader("data/motcleflist.txt"))) {
                String sCurrentLine;
                m_lstMotClefs.clear();
//                m_tblCompts.clear();
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("#####" + sCurrentLine + "\t#####line from motcleflist.txt (Nayau)");
                    MotClef mot = new MotClef(sCurrentLine);
                    m_lstMotClefs.add(mot);
                }
                m_motclefInit = true; //on doit le vérifier ou non?             
            } catch (IOException ee) {
                ee.printStackTrace();
            }
            System.out.println("motclef list:" + m_lstMotClefs + " (Noyau)");
        }
    }

    private void creerTblCompetence() {
        if (!m_comptInit) {
            try (BufferedReader br = new BufferedReader(new FileReader("data/complist.txt"))) {
                String sCurrentLine;
                m_comptVecNom.clear();
                m_tblCompts.clear();
                while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println("#####" + sCurrentLine + "\t#####line from complist.txt (Nayau)");
                    Competence comp = new Competence(sCurrentLine);
                    String compnom = comp.getNomComp();
                    System.out.println("##### comp.getNomcomp" + compnom + "\t#####line from complist.txt (Nayau)");

                    // avoid duplicates
                    if (!m_tblCompts.containsKey(compnom)) {
                        m_comptVecNom.add(compnom);
                    }
                    m_tblCompts.put(compnom, comp);

                    System.out.println("compTbl size:" + m_tblCompts.size() + " (Noyau)");
                    System.out.println("compVec size:" + m_comptVecNom.size() + " (Noyau)");
                }
                m_comptInit = true;
                //DefaultComboBoxModel model = new DefaultComboBoxModel(m_comptVecNom);
                //cmbReg.setModel(model);
            } catch (IOException ee) {
                ee.printStackTrace();
            }

            System.out.println("competence map:" + m_tblCompts + " (Noyau)");
        }
    }
}
