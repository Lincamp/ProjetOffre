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
import ProjetOffre.metier.Constant;
import ProjetOffre.metier.Emploi;
import ProjetOffre.metier.Stage;

/**
 *
 * @author Doro
 */
public class OffreNoyauFonctionnel {

    private static HashMap<String, ArrayList<Emploi>> m_tblEmplois;
    private static HashMap<String, ArrayList<Stage>> m_tblStages;
    private static boolean m_offInit;
    static final String m_stageDelim = "-1";

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
//        System.out.println(m_tblStages + "|" + m_tblStages + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ONF.java");
        return m_tblStages;
    }

    public static void ajouterEmploi(Emploi emploi) {

        String tmpRegStr = emploi.getReg().getRegnom();

        ArrayList<Emploi> lstEmploi = m_tblEmplois.get(tmpRegStr);
        if (lstEmploi == null) {
            m_tblEmplois.put(tmpRegStr, lstEmploi = new ArrayList<Emploi>());
        }

        lstEmploi.add(emploi);
        emploi.printOut();
        System.out.println("tblEmplois size after ajouter+++++:" + m_tblEmplois.size() + " (NoyauOffre)");
        System.out.println("lstEmploi size after ajouter+++++:" + lstEmploi.size() + " (NoyauOffre)");
    }

    public static void ajouterStage(Stage stage) {
        String tmpRegStr = stage.getReg().getRegnom();

        ArrayList<Stage> lstStage = m_tblStages.get(tmpRegStr);
        if (lstStage == null) {
            m_tblStages.put(tmpRegStr, lstStage = new ArrayList<Stage>());
        }

        lstStage.add(stage);
        stage.printOut();
        System.out.println("tblStages size after ajouter+++++:" + m_tblStages.size() + " (NoyauOffre)");
        System.out.println("lstStage size after ajouter+++++:" + lstStage.size() + " (NoyauOffre)");
    }

    private void creerTblOffre() {
        if (!m_offInit) {
            try (BufferedReader br = new BufferedReader(new FileReader(Constant.m_offreList))) {
                String sCurrentLine;
                m_tblEmplois.clear();
                String[] results;
//                int i = 0;
                while ((sCurrentLine = br.readLine()) != null) {
//                    System.out.println("22222#####" + sCurrentLine + "\t#####line from offrelist.txt (NoyauOffre)");
//                    results = sCurrentLine.split(m_itemDelim, -1);

                    results = sCurrentLine.split(Constant.m_itemDelim, -1);

                    // Stage has experience -1
                    if ("-1".equals(results[2])) {
//System.out.println(i + "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
                        Stage tmpStage = new Stage(sCurrentLine);
                        String tmpRegStr = tmpStage.getReg().getRegnom();

                        ArrayList<Stage> lstStage = m_tblStages.get(tmpRegStr);
                        if (lstStage == null) {
                            m_tblStages.put(tmpRegStr, lstStage = new ArrayList<Stage>());
                        }
//                        System.out.println(tmpStage.toString() + "!!!!!!!!!before add emploi (NoyauOffre)");
                        lstStage.add(tmpStage);
                        tmpStage.printOut();
//                        System.out.println("lstStage size+++++:" + lstStage.size() + " (NoyauOffre)");
//                        System.out.println("tblStages size+++++:" + m_tblStages.size() + " (NoyauOffre)");
                    } else {
//System.out.println(i + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + results[2]);
                        Emploi tmpEmploi = new Emploi(sCurrentLine);
                        String tmpRegStr = tmpEmploi.getReg().getRegnom();

                        ArrayList<Emploi> lstEmploi = m_tblEmplois.get(tmpRegStr);
                        if (lstEmploi == null) {
                            m_tblEmplois.put(tmpRegStr, lstEmploi = new ArrayList<Emploi>());
                        }
//                        System.out.println(tmpEmploi.toString() + "!!!!!!!!!before add emploi (NoyauOffre)");
                        lstEmploi.add(tmpEmploi);
                        tmpEmploi.printOut();
//                        System.out.println("lstEmploi size+++++:" + lstEmploi.size() + " (NoyauOffre)");
//                        System.out.println("tblEmplois size+++++:" + m_tblEmplois.size() + " (NoyauOffre)");
                    }
//                    i++;
                }

//                System.out.println("tblEmplois size:" + m_tblEmplois.size() + " (NoyauOffre)");
//                System.out.println("tblStages size:" + m_tblStages.size() + " (NoyauOffre)");
                //System.out.println("regVec size:" + m_regVecNom.size() + " (NoyauOffre)");
                m_offInit = true;
            } catch (IOException ee) {
                ee.printStackTrace();
            }

//            System.out.println("region map emplois:" + m_tblEmplois + " (NoyauOffre)");
//            System.out.println("region map stages:" + m_tblStages + m_tblStages.get("Corse") + " (NoyauOffre)");
        }
    }

    public static void printOutOffres() {

        System.out.println("================================ONF.java");
        
        for (String region : m_tblEmplois.keySet()) {
            System.out.println("Key : " + region +
                               " Size : " + m_tblEmplois.get(region).size());
            for(Emploi emploi:m_tblEmplois.get(region))
            {
                System.out.print("[" + emploi.getTitre() + "] ");
                System.out.println();
            }
        }
        
        System.out.println("================================");

        for (String region : m_tblStages.keySet()) {
            System.out.println("Key : " + region +
                               " Size : " + m_tblStages.get(region).size());
            for(Stage stage:m_tblStages.get(region))
            {
                System.out.print("[" + stage.getTitre() + "] ");
                System.out.println();
            }
        }
        
        System.out.println("================================");
    }
}
