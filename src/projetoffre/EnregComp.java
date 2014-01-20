/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoffre;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Doro
 */
public class EnregComp {
    //attributs
    //private ArrayList<Competence> m_lstcomps;
    private HashMap<Competence, CompType> m_tblComps;
    private int m_size;
    
//    Object[][] m_compContent;
    /**
     * Constructeur forçant une initialisation aux valeurs par défaut.
     */
    public EnregComp() {
        //m_lstcomps = new ArrayList<>();
        m_tblComps = new HashMap();
//        m_compContent = new Object[m_size][2];
        init();
    }

    /**
     * Méthode interne de remise à zéro.
     */
    private void init() {
        //m_lstcomps.clear();
        m_tblComps.clear();
        m_size = 0;
    }

    //public ArrayList<Competence> getComps() {
    public HashMap<Competence, CompType> getComps() {
        //return m_lstcomps;
        return m_tblComps;
    }

    public void ajouterComp(Competence comp, CompType compType) {
        // m_lstcomps.add(new Competence(nomC,oblig));
        m_tblComps.put(comp, compType);
        //m_size++;
    }

    public void retirerComp(Competence comp) {
        m_tblComps.remove(comp);
        //m_size--;
    }

//    public void setTableData(){
////        String[] columnNames = {"column 1", "column 2"}; 
//        m_compContent = new Object[m_size][2];
//        for(int i = 0; i < m_size; i++)
//        {
//            m_compContent[i][0] = lstcomps.get(0).getNomComp();
//            m_compContent[i][1] = lstcomps.get(0).isObligatoire();
//        }
//    }
//    public Object[][] getCompContent() {
//      //  setTableData();
//        return m_compContent;
//    }
    public int getSize() {
//        System.out.println("Size of Competence Map: " + m_tblComps.size());
        return m_tblComps.size();
        //return m_size;
    }
}
