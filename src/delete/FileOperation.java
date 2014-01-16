/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import projetoffre.CompType;
import projetoffre.Competence;

/**
 *
 * @author Doro
 */
public class FileOperation {
    static final char m_itemDelim = ';';
    static final char m_compDelim = '|';
    static final char m_compTypeDelim = ':';
    static final String m_offreList = "data/offrelist.txt";
    //attributs
    String v_titre;
    String v_region;
    int v_exp;
    int v_salMin;
    int v_salMax;

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/test.txt"))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }

    public void writeFile() {
        try {

            String content = "This is the content to write into file\n";

            File file = new File("output.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();

//                        bw.write(txtTitre.getText()+"\n");
            bw.close();

            //System.out.println(txtTitre.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enrgOffre(String v_titre, String v_region, int v_exp, int v_salMin, int v_salMax, HashMap<Competence, CompType> tblComps) {
        try {
            int compsSize = tblComps.size();
            System.out.println("size" + tblComps.size());
            System.out.println(tblComps);
            String compstr = "";

            //for(Competence comp:c)
//            for(int i = 0; i < compsSize; i++){                
//                compstr += c.get(i).getNomComp() + m_compTypeDelim;
//                  System.out.println("compstr :" + compstr);
//                if(c.get(i).isObligatoire()) {
//                    compstr += "1";
//                }
//                else {
//                    compstr += "0";
//                }
//                if(i < compsSize - 1){
//                    compstr += m_compDelim;
//                }
//            }
            Iterator iter = tblComps.keySet().iterator();
            while (iter.hasNext()) {
                Competence key = (Competence) iter.next();
                compstr += key.getNomComp() + m_compTypeDelim;
                System.out.println("saved compstr :" + compstr);

                compstr += tblComps.get(key).getLibType() + m_compDelim;
            }
            
            if (compstr.length() > 0 && compstr.charAt(compstr.length() - 1)==m_compDelim) {
              compstr = compstr.substring(0, compstr.length()-1);
            } 

            String content = v_titre + m_itemDelim
                    + v_region + m_itemDelim
                    + v_exp + m_itemDelim
                    + v_salMin + m_itemDelim
                    + v_salMax + m_itemDelim + compstr;
            
            File file = new File(m_offreList);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void separateFields() {
        String str = "emploi;engineer;paris;2;2000;3000;Program/obligatoire|BD/souhaitee";
        String delimiter = ";";
        String[] results;

        results = str.split(delimiter, -1);

        System.out.println("Separated values:" + results[6].indexOf("|") + "@" + results[6].substring(1 + results[6].indexOf("/")));
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println("");
    }
}
