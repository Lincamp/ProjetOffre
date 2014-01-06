/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetoffre;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Doro
 */
public class EnregComp {
  //attributs
    private ArrayList<Competence> m_lstcomps;
    private int m_size;
//    Object[][] m_compContent;

    /**
     * Constructeur forçant une initialisation aux valeurs par défaut.
     */
    public EnregComp() {
        m_lstcomps = new ArrayList<>();
//        m_compContent = new Object[m_size][2];
        init();
    }

    /**
     * Méthode interne de remise à zéro.
     */
    private void init() {
        m_lstcomps.clear();
        m_size = 0;       
    } 

    public ArrayList<Competence> getComps() {
        return m_lstcomps;
    }
    
    public void ajouterComp(String nomC, boolean oblig) {        
        m_lstcomps.add(new Competence(nomC,oblig));
        m_size++;      
    }
    
    public void retirerComp(Competence comp) {       
        m_lstcomps.remove(comp);
        m_size--;
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
        return m_size;
    }    
}
