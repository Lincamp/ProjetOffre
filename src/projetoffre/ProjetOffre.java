/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetoffre;

import java.util.ArrayList;
import offrecomponents.OffreFrame;

/**
 *
 * @author Doro
 */
public class ProjetOffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OffreFrame().setVisible(true);
            }
        });      
        
    int s1,s2;          
    s1 = 30000;
    s2 = 25000;
//  
////  Emploi e1= new Emploi("blabla", "blablaLand",5, 20000,25000);
////  Emploi e2= new Emploi("blablas", "blablaLands",5, 21110,27000);
////  ArrayList lstEmp;
////  lstEmp = new ArrayList();
////  lstEmp.add(e1);
////  lstEmp.add(e2);
////      System.out.println("score Salaire : " + e1.scoreSalaire(s1, lstEmp));
//    
//    
MotClef m1 = new MotClef ("Java");
MotClef m2 = new MotClef ("VB");
MotClef m3 = new MotClef ("C++");
MotClef m4 = new MotClef ("PHP");
MotClef m5 = new MotClef ("ORACLE");
MotClef m6 = new MotClef ("BD");
MotClef m7 = new MotClef ("html");


Competence c1 = new Competence("Programmation", true);
Competence c2 = new Competence("SI", false);
Competence c3 = new Competence("web", true);
ArrayList <Competence> lstComp;
lstComp = new ArrayList();
lstComp.add(c3);
lstComp.add(c2);
lstComp.add(c1);
c1.lstmots.add(m2);
c1.lstmots.add(m1);
c1.lstmots.add(m3);
c2.lstmots.add(m5);
c2.lstmots.add(m6);
c3.lstmots.add(m4);
c3.lstmots.add(m7);


Emploi e1= new Emploi("blabla", "blablaLand",5, 20000,25000,lstComp);
Emploi e2= new Emploi("blablas", "blablaLands",5, 21110,27000,lstComp);
ArrayList lstEmp, lstCherche;
  lstEmp = new ArrayList();
  lstCherche = new ArrayList();
  lstEmp.add(e1);
  //lstEmp.add(e2);
  lstCherche.add(c1);
  lstCherche.add(c2);

System.out.println("score Competence : " + e1.scoreCompetences(lstEmp, lstCherche));

    }       
}
