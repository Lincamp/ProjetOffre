/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetOffre.components;

import java.awt.CardLayout;

/**
 *
 * @author Doro
 */
public class OffreFrame extends javax.swing.JFrame {
    
    private CardLayout cardLayout;
   // private EnregistreurDeTirage enregistreur;
    /**
     * Creates new form PhotocopiesFrameStrucure
     */
    public OffreFrame() {
        initComponents();
      //  enregistreur = new EnregistreurDeTirage();
       // panelEnregistrer1.setEnregistreur(enregistreur);
       // panelRecapitulatif1.setEnregistreur(enregistreur);
        
        cardLayout = (CardLayout) jPanel1.getLayout();
        
        mnuoptSaisie.setSelected(true);
        montrerSaisie();
    }

    private void montrerSaisie() {
        cardLayout.show(jPanel1, "saisie");
    }

    private void montrerRechercher() {
        cardLayout.show(jPanel1, "rechercher");
    }
    
    

    /**
     * Creates new form OffreFrame
     */
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btngrpmenu = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelSaisie1 = new ProjetOffre.components.PanelSaisie();
        panelRechercher1 = new ProjetOffre.components.PanelRechercher();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuoptSaisie = new javax.swing.JRadioButtonMenuItem();
        mnuoptRechercher = new javax.swing.JRadioButtonMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());
        jPanel1.add(panelSaisie1, "saisie");
        jPanel1.add(panelRechercher1, "rechercher");

        jMenu1.setText("Menu");

        btngrpmenu.add(mnuoptSaisie);
        mnuoptSaisie.setSelected(true);
        mnuoptSaisie.setText("Saisie offre");
        mnuoptSaisie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuoptSaisieActionPerformed(evt);
            }
        });
        jMenu1.add(mnuoptSaisie);

        btngrpmenu.add(mnuoptRechercher);
        mnuoptRechercher.setText("Rechercher");
        mnuoptRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuoptRechercherActionPerformed(evt);
            }
        });
        jMenu1.add(mnuoptRechercher);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuoptSaisieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuoptSaisieActionPerformed
        // TODO add your handling code here:
        montrerSaisie() ;
    }//GEN-LAST:event_mnuoptSaisieActionPerformed

    private void mnuoptRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuoptRechercherActionPerformed
        // TODO add your handling code here:
        montrerRechercher();
    }//GEN-LAST:event_mnuoptRechercherActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(OffreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(OffreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(OffreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(OffreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new OffreFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngrpmenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem mnuoptRechercher;
    private javax.swing.JRadioButtonMenuItem mnuoptSaisie;
    private ProjetOffre.components.PanelRechercher panelRechercher1;
    private ProjetOffre.components.PanelSaisie panelSaisie1;
    // End of variables declaration//GEN-END:variables
}