/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package offrecomponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import projetoffre.Competence;
import projetoffre.EnregCompRech;
import projetoffre.noyaufonctionnel.ComptNoyauFonctionnel;
import projetoffre.noyaufonctionnel.RegionNoyauFonctionnel;
import view.View;

/**
 *
 * @author Doro
 */
public class PanelRechercher extends javax.swing.JPanel implements View {
//    private RegionNoyauFonctionnel m_regFonc;
    private ComptNoyauFonctionnel m_compFonc;
    Set<String> m_setComp;
    ArrayList<Competence> m_lstCompRechs;
    EnregCompRech m_enregCompRech;
       DefaultListModel listModel;
    
    /**
     * Creates new form PanelRechercher
     */
    public PanelRechercher() {
        initComponents();
//        m_regFonc = new RegionNoyauFonctionnel();
        m_compFonc = new ComptNoyauFonctionnel();
        m_lstCompRechs = new ArrayList();
         m_setComp = new HashSet<String>();
         m_enregCompRech = new EnregCompRech();
         listModel = new DefaultListModel();
          initRegionList();
        initCompList();
    }
    
       private void initRegionList() {
//        Vector comboBoxItems = new Vector();
//        Vector comboBoxItems = m_regFonc.getRegVecNom();   
        
        ArrayList regionNomList = RegionNoyauFonctionnel.getRegVecNom();
        Vector comboBoxItems = new Vector();
        comboBoxItems.setSize(regionNomList.size());
        Collections.copy(comboBoxItems, regionNomList);        
        DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
        cmbReg.setModel(model);
       
    }
    

    private void initCompList() {
        Vector cmbCompItems = m_compFonc.getComptVecNom();       
        DefaultComboBoxModel compModel = new DefaultComboBoxModel(cmbCompItems);
        cmbComp.setModel(compModel);     
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        optEmploi = new javax.swing.JRadioButton();
        optStage = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbReg = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSalmin = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbComp = new javax.swing.JComboBox();
        jPanel21 = new javax.swing.JPanel();
        btnAjouter = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstCompRech = new javax.swing.JList();
        btnSup = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblComp = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnRech = new javax.swing.JButton();
        btnRAZ = new javax.swing.JButton();

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        optEmploi.setSelected(true);
        optEmploi.setText("Emploi");
        optEmploi.setToolTipText("");
        optEmploi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEmploiActionPerformed(evt);
            }
        });
        jPanel2.add(optEmploi);

        optStage.setText("Stage");
        jPanel2.add(optStage);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new java.awt.GridLayout(5, 0));

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("Region :");
        jPanel6.add(jLabel2);

        cmbReg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegActionPerformed(evt);
            }
        });
        jPanel6.add(cmbReg);

        jPanel4.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        jLabel3.setText("    ");
        jPanel7.add(jLabel3);

        jCheckBox1.setText("région proximité inclus");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel7.add(jCheckBox1);

        jPanel4.add(jPanel7);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("Salaire espéré :");
        jPanel9.add(jLabel5);

        txtSalmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalminActionPerformed(evt);
            }
        });
        jPanel9.add(txtSalmin);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));
        jPanel4.add(jPanel10);

        jPanel3.add(jPanel4);

        jPanel16.setLayout(new java.awt.GridLayout(1, 1));

        jPanel18.setLayout(new java.awt.GridLayout(3, 0));

        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setText("Compétence :");
        jPanel19.add(jLabel8);

        cmbComp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Program", "Item 2", "Item 3", "Item 4" }));
        jPanel19.add(cmbComp);

        jPanel18.add(jPanel19);

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnAjouter)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(btnAjouter)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel21);

        jPanel16.add(jPanel18);

        jPanel15.add(jPanel16);

        jLabel1.setText("Erreur");
        jPanel5.add(jLabel1);

        jPanel14.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setText("Compétence choisis :");

        jlstCompRech.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlstCompRech);

        btnSup.setText("Supprimer");
        btnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSup)))
                .addGap(130, 130, 130))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSup)))
        );

        jPanel14.add(jPanel17);

        jPanel13.add(jPanel14);

        jPanel22.setLayout(new java.awt.GridLayout(2, 0));

        jLabel9.setText("Résultats :");

        tblComp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Titre", "Score Total", "Adequation", "Region"
            }
        ));
        tblComp.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(tblComp);
        tblComp.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.add(jPanel23);

        jPanel20.add(jPanel22);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btnRech.setText("Rechercher");
        btnRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechActionPerformed(evt);
            }
        });
        jPanel12.add(btnRech);

        btnRAZ.setText("RAZ");
        jPanel12.add(btnRAZ);

        jPanel11.add(jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optEmploiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEmploiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optEmploiActionPerformed

    private void cmbRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRegActionPerformed

    private void txtSalminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalminActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
       afficherCompChercher();
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnRechActionPerformed

    private void btnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActionPerformed
        // TODO add your handling code here:
//       List<Competence> lstComps = jlstCompRech.getSelectedValuesList();
//       for(Competence comp:lstComps){
//          m_enregCompRech.retirerComp(comp);        
//       }
        
    }//GEN-LAST:event_btnSupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnRAZ;
    private javax.swing.JButton btnRech;
    private javax.swing.JButton btnSup;
    private javax.swing.JComboBox cmbComp;
    private javax.swing.JComboBox cmbReg;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jlstCompRech;
    private javax.swing.JRadioButton optEmploi;
    private javax.swing.JRadioButton optStage;
    private javax.swing.JTable tblComp;
    private javax.swing.JTextField txtSalmin;
    // End of variables declaration//GEN-END:variables

    private void afficherCompChercher() {
        String nomC;        
        nomC = cmbComp.getSelectedItem().toString();    
        
        if (!m_setComp.contains(nomC)) {
            m_setComp.add(nomC);
            System.out.println("m_setComp chercher :" + m_setComp + "(PanelRechercher)");
            System.out.println("m_setComp size :" + m_setComp.size() + "(PanelRechercher)");
           // m_lstCompRechs.add(m_compFonc.m_tblCompts.get(nomC));
            m_enregCompRech.ajouterComp(m_compFonc.m_tblCompts.get(nomC));        
            listModel.addElement(nomC);
            jlstCompRech.setModel(listModel);           
                
        }

    }

    @Override
    public void modelChanged() {
        //To change body of generated methods, choose Tools | Templates.
    }



}
