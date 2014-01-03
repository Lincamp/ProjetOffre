/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offrecomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import projetoffre.Competence;
import projetoffre.Emploi;
import projetoffre.EnregComp;
import projetoffre.FileOperation;
import projetoffre.Region;

/**
 *
 * @author Doro
 */
// TODO do not allow delimiter in input text 
// avoid duplicate when ajouter nouveau offre
// comptence qu'une fois
//exp, salaire int only
public class PanelSaisie extends javax.swing.JPanel {

    private EnregComp enregComp;
    boolean m_offreType;
    String m_titre;
    String m_region;
    int m_exp;
    String m_comp;
    boolean m_compType;
    int m_salMin;
    int m_salMax;
    ArrayList<Competence> m_lstcomps;
    Set<String> m_setComp;

    /**
     * Creates new form PanelSaisie
     */
    public PanelSaisie() {
        initComponents();
        enregComp = new EnregComp();
        m_lstcomps = new ArrayList();
        m_setComp = new HashSet<String>();
        initRegionList();
        initCompList();
    }

    private void initRegionList() {
        Vector comboBoxItems = new Vector();

        try (BufferedReader br = new BufferedReader(new FileReader("data/regionlist.txt"))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                comboBoxItems.add(sCurrentLine);

            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
            cmbReg.setModel(model);
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }

    private void initCompList() {
        Vector comboBoxItems = new Vector();

        try (BufferedReader br = new BufferedReader(new FileReader("data/complist.txt"))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                comboBoxItems.add(sCurrentLine);
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
            cmbComp.setModel(model);
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpOffreType = new javax.swing.ButtonGroup();
        grpCompType = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        optEmploi1 = new javax.swing.JRadioButton();
        optStage1 = new javax.swing.JRadioButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTitre1 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbReg1 = new javax.swing.JComboBox();
        jPanel29 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtExp1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSalmin1 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtSalmax1 = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cmbComp1 = new javax.swing.JComboBox();
        jPanel36 = new javax.swing.JPanel();
        optOblig1 = new javax.swing.JRadioButton();
        optSouh1 = new javax.swing.JRadioButton();
        jPanel37 = new javax.swing.JPanel();
        btnAjouter1 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblComp1 = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        btnSup1 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        btnEnreg1 = new javax.swing.JButton();
        btnRAZ1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        optEmploi = new javax.swing.JRadioButton();
        optStage = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitre = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbReg = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtExp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSalmin = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSalmax = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbComp = new javax.swing.JComboBox();
        jPanel20 = new javax.swing.JPanel();
        optOblig = new javax.swing.JRadioButton();
        optSouh = new javax.swing.JRadioButton();
        jPanel21 = new javax.swing.JPanel();
        btnAjouter = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblComp = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnSup = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnEnreg = new javax.swing.JButton();
        btnRAZ = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel24.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        grpOffreType.add(optEmploi1);
        optEmploi1.setText("Emploi");
        optEmploi1.setToolTipText("");
        optEmploi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEmploi1ActionPerformed(evt);
            }
        });
        jPanel24.add(optEmploi1);

        grpOffreType.add(optStage1);
        optStage1.setText("Stage");
        jPanel24.add(optStage1);

        jPanel23.add(jPanel24);

        jPanel26.setLayout(new java.awt.GridLayout(5, 0));

        jPanel27.setLayout(new java.awt.GridLayout(1, 0));

        jLabel9.setText("Titre :");
        jPanel27.add(jLabel9);

        txtTitre1.setText("jTextField1");
        txtTitre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitre1ActionPerformed(evt);
            }
        });
        jPanel27.add(txtTitre1);

        jPanel26.add(jPanel27);

        jPanel28.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setText("Region :");
        jPanel28.add(jLabel10);

        cmbReg1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbReg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReg1ActionPerformed(evt);
            }
        });
        jPanel28.add(cmbReg1);

        jPanel26.add(jPanel28);

        jPanel29.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        jLabel11.setText("Expérience :");
        jPanel29.add(jLabel11);

        txtExp1.setText("jTextField3");
        jPanel29.add(txtExp1);

        jLabel12.setText("   ans");
        jPanel29.add(jLabel12);

        jPanel26.add(jPanel29);

        jPanel30.setLayout(new java.awt.GridLayout(1, 0));

        jLabel13.setText("Salaire Min :");
        jPanel30.add(jLabel13);

        txtSalmin1.setText("jTextField4");
        txtSalmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalmin1ActionPerformed(evt);
            }
        });
        jPanel30.add(txtSalmin1);

        jPanel26.add(jPanel30);

        jPanel31.setLayout(new java.awt.GridLayout(1, 0));

        jLabel14.setText("Salaire Max :");
        jPanel31.add(jLabel14);

        txtSalmax1.setText("jTextField5");
        jPanel31.add(txtSalmax1);

        jPanel26.add(jPanel31);

        jPanel25.add(jPanel26);

        jPanel33.setLayout(new java.awt.GridLayout(1, 1));

        jPanel34.setLayout(new java.awt.GridLayout(3, 0));

        jPanel35.setLayout(new java.awt.GridLayout(1, 0));

        jLabel15.setText("Compétence :");
        jPanel35.add(jLabel15);

        cmbComp1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel35.add(cmbComp1);

        jPanel34.add(jPanel35);

        jPanel36.setLayout(new java.awt.GridLayout(2, 0));

        grpCompType.add(optOblig1);
        optOblig1.setText("obligatoire");
        optOblig1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optOblig1ActionPerformed(evt);
            }
        });
        jPanel36.add(optOblig1);

        grpCompType.add(optSouh1);
        optSouh1.setText("souhaitée");
        optSouh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSouh1ActionPerformed(evt);
            }
        });
        jPanel36.add(optSouh1);

        jPanel34.add(jPanel36);

        btnAjouter1.setText("Ajouter");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnAjouter1)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(btnAjouter1)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jPanel34.add(jPanel37);

        jPanel33.add(jPanel34);

        jPanel32.add(jPanel33);

        jPanel39.setLayout(new java.awt.GridLayout(2, 0));

        jLabel16.setText("Compétence choisis :");

        tblComp1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblComp1);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.add(jPanel40);

        btnSup1.setText("Supprimer");
        jPanel41.add(btnSup1);

        jPanel39.add(jPanel41);

        jPanel38.add(jPanel39);

        jPanel43.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btnEnreg1.setText("Enregistrer");
        btnEnreg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnreg1ActionPerformed(evt);
            }
        });
        jPanel43.add(btnEnreg1);

        btnRAZ1.setText("RAZ");
        jPanel43.add(btnRAZ1);

        jPanel42.add(jPanel43);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        grpOffreType.add(optEmploi);
        optEmploi.setText("Emploi");
        optEmploi.setToolTipText("");
        optEmploi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEmploiActionPerformed(evt);
            }
        });
        jPanel2.add(optEmploi);

        grpOffreType.add(optStage);
        optStage.setText("Stage");
        jPanel2.add(optStage);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new java.awt.GridLayout(5, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("Titre :");
        jPanel5.add(jLabel1);

        txtTitre.setText("jTextField1");
        txtTitre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitreActionPerformed(evt);
            }
        });
        jPanel5.add(txtTitre);

        jPanel4.add(jPanel5);

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

        jLabel3.setText("Expérience :");
        jPanel7.add(jLabel3);

        txtExp.setText("jTextField3");
        jPanel7.add(txtExp);

        jLabel4.setText("   ans");
        jPanel7.add(jLabel4);

        jPanel4.add(jPanel7);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("Salaire Min :");
        jPanel9.add(jLabel5);

        txtSalmin.setText("jTextField4");
        txtSalmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalminActionPerformed(evt);
            }
        });
        jPanel9.add(txtSalmin);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setText("Salaire Max :");
        jPanel10.add(jLabel6);

        txtSalmax.setText("jTextField5");
        jPanel10.add(txtSalmax);

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

        jPanel20.setLayout(new java.awt.GridLayout(2, 0));

        grpCompType.add(optOblig);
        optOblig.setText("obligatoire");
        optOblig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optObligActionPerformed(evt);
            }
        });
        jPanel20.add(optOblig);

        grpCompType.add(optSouh);
        optSouh.setText("souhaitée");
        optSouh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSouhActionPerformed(evt);
            }
        });
        jPanel20.add(optSouh);

        jPanel18.add(jPanel20);

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
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel21);

        jPanel16.add(jPanel18);

        jPanel15.add(jPanel16);

        jPanel14.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setText("Compétence choisis :");

        tblComp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Competence", "Type"
            }
        ));
        tblComp.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(tblComp);
        tblComp.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel17);

        btnSup.setText("Supprimer");
        jPanel8.add(btnSup);

        jPanel14.add(jPanel8);

        jPanel13.add(jPanel14);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btnEnreg.setText("Enregistrer");
        btnEnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregActionPerformed(evt);
            }
        });
        jPanel12.add(btnEnreg);

        btnRAZ.setText("RAZ");
        jPanel12.add(btnRAZ);

        jPanel11.add(jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optEmploiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEmploiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optEmploiActionPerformed

    private void optSouhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSouhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optSouhActionPerformed

    private void optObligActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optObligActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optObligActionPerformed

    private void btnEnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregActionPerformed
        // TODO add your handling code here:
        if (optEmploi.isSelected() || optStage.isSelected()) {
            m_offreType = optEmploi.isSelected();
            m_titre = txtTitre.getText();
            if (m_offreType) {
                m_region = cmbReg.getSelectedItem().toString();
                m_exp = Integer.parseInt(txtExp.getText());
                m_salMin = Integer.parseInt(txtSalmin.getText());
                m_salMax = Integer.parseInt(txtSalmax.getText());

               // Emploi emp = new Emploi(m_titre, m_region, m_exp, m_salMin, m_salMax, m_lstcomps);
                FileOperation fileout = new FileOperation();
                fileout.enrgFile(m_titre, m_region, m_exp, m_salMin, m_salMax, m_lstcomps);
            } else {

            }
        } else {
            //TODO
        }

//            FileOperation fileout = new FileOperation();
//            fileout.readFile();      
//            fileout.separateFields();
//        if(optOblig.isSelected()){
//            fileout.writeFile();	
//        }

    }//GEN-LAST:event_btnEnregActionPerformed

    private void cmbRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRegActionPerformed

    private void txtSalminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalminActionPerformed

    private void txtTitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitreActionPerformed
        // TODO add your handling code here:       
    }//GEN-LAST:event_txtTitreActionPerformed

    private void optEmploi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEmploi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optEmploi1ActionPerformed

    private void txtTitre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitre1ActionPerformed

    private void cmbReg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbReg1ActionPerformed

    private void txtSalmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalmin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalmin1ActionPerformed

    private void optOblig1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optOblig1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optOblig1ActionPerformed

    private void optSouh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSouh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optSouh1ActionPerformed

    private void btnEnreg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnreg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnreg1ActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
        afficherNoyauFonctionnel();
    }//GEN-LAST:event_btnAjouterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAjouter1;
    private javax.swing.JButton btnEnreg;
    private javax.swing.JButton btnEnreg1;
    private javax.swing.JButton btnRAZ;
    private javax.swing.JButton btnRAZ1;
    private javax.swing.JButton btnSup;
    private javax.swing.JButton btnSup1;
    private javax.swing.JComboBox cmbComp;
    private javax.swing.JComboBox cmbComp1;
    private javax.swing.JComboBox cmbReg;
    private javax.swing.JComboBox cmbReg1;
    private javax.swing.ButtonGroup grpCompType;
    private javax.swing.ButtonGroup grpOffreType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton optEmploi;
    private javax.swing.JRadioButton optEmploi1;
    private javax.swing.JRadioButton optOblig;
    private javax.swing.JRadioButton optOblig1;
    private javax.swing.JRadioButton optSouh;
    private javax.swing.JRadioButton optSouh1;
    private javax.swing.JRadioButton optStage;
    private javax.swing.JRadioButton optStage1;
    private javax.swing.JTable tblComp;
    private javax.swing.JTable tblComp1;
    private javax.swing.JTextField txtExp;
    private javax.swing.JTextField txtExp1;
    private javax.swing.JTextField txtSalmax;
    private javax.swing.JTextField txtSalmax1;
    private javax.swing.JTextField txtSalmin;
    private javax.swing.JTextField txtSalmin1;
    private javax.swing.JTextField txtTitre;
    private javax.swing.JTextField txtTitre1;
    // End of variables declaration//GEN-END:variables

    private void afficherNoyauFonctionnel() {
        String nomC;
        nomC = cmbComp.getSelectedItem().toString();
   
        if (!m_setComp.contains(nomC)) {
            m_setComp.add(nomC); 
            System.out.println("m_setComp ;" + m_setComp);
               System.out.println("m_setComp size ;" + m_setComp.size());
            enregComp.ajouterComp(nomC, optOblig.isSelected());
        }
        System.out.println(enregComp.getSize());
        int compsSize = enregComp.getSize();
        m_lstcomps = enregComp.getComps();

        Object[][] m_compContent = new Object[compsSize][2];
        for (int i = 0; i < compsSize; i++) {
            m_compContent[i][0] = m_lstcomps.get(i).getNomComp();
            m_compContent[i][1] = m_lstcomps.get(i).isObligatoire();
        }

        //m_lstcomps = enregComp.getComps();      
        String[] columnNames = {"Competence", "Type"};
//        Object[][] data = enregComp.getCompContent();
        DefaultTableModel model = new DefaultTableModel(m_compContent, columnNames);
        tblComp.setModel(model);
    }
}
