/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetOffre.components;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import ProjetOffre.metier.CompType;
import ProjetOffre.metier.Competence;
import ProjetOffre.metier.Emploi;
import ProjetOffre.metier.EnregComp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ProjetOffre.metier.EnregistreurDeOffre;
import ProjetOffre.metier.Offre;
import ProjetOffre.metier.Region;
import ProjetOffre.metier.Stage;
import projetoffre.noyaufonctionnel.RegionNoyauFonctionnel;
import projetoffre.noyaufonctionnel.ComptNoyauFonctionnel;
import projetoffre.noyaufonctionnel.OffreNoyauFonctionnel;
import ProjetOffre.mvc.View;

/**
 *
 * @author Doro
 */
// TODO do not allow delimiter in input text 
// avoid duplicate when ajouter nouveau offre
// comptence qu'une fois
//exp, salaire int only
// TODO disable supprimer
public class PanelSaisie extends javax.swing.JPanel implements View {

    private RegionNoyauFonctionnel m_regFonc;
    private OffreNoyauFonctionnel m_offreFonc;
    private ComptNoyauFonctionnel m_compFonc;
    private EnregComp m_enregComp;
    private Offre m_offre;
    boolean m_offreType;
    String m_titre;
    String m_regionStr;
    Region m_region;
    int m_exp;
    String m_comp;
    boolean m_compType;
    int m_salMin;
    int m_salMax;
    //ArrayList<Competence> m_lstcomps;
    HashMap<Competence, CompType> m_tblComps;
    Set<String> m_setComp;

    private EnregistreurDeOffre m_offreEnreg;
    private boolean m_enregistrerPossible;

    /**
     * Creates new form PanelSaisie
     */
    public PanelSaisie() {
        m_regFonc = new RegionNoyauFonctionnel();
        m_compFonc = new ComptNoyauFonctionnel();
        m_offreFonc = new OffreNoyauFonctionnel();

        m_enregComp = new EnregComp();
        //m_lstcomps = new ArrayList();
//        this.m_tblComps = new HashMap();
        m_setComp = new HashSet<>();
        // TODO put all init in initUneFois
        initComponents();

        initDocumentProperties();

//        Offre offre = new Emploi();
//      System.out.println("offreGetClass" + offre.getClass());
//        Region reg = new Region();
//        DefaultComboBoxModel model = reg.getRegionListModel();
//        cmbReg.setModel(model);
        initRegionList();

        initCompList();
        init();

        setOffreEnregistreur(new EnregistreurDeOffre(optEmploi.isSelected()));
    }

    public void setOffreEnregistreur(EnregistreurDeOffre enregistreur) {
        this.m_offreEnreg = enregistreur;
        enregistreur.addView(this);
        init();
        afficherNoyauFonctionnel();
    }

    private void init() {
        optEmploi.setSelected(true);
        optStage.setSelected(false);
        this.txtTitre.setText("");
        txtExp.setEnabled(true);
        txtSalmax.setEnabled(true);
        txtSalmin.setEnabled(true);
        txtExp.setText("0");
        txtSalmin.setText("0");
        txtSalmax.setText("0");
        optOblig.setSelected(false);
        optSouh.setSelected(true);
        cmbReg.setSelectedIndex(0);
//        btnSup.setEnabled(false);

        activerRAZ(false);
        activerSupprimer(false);

//        //            m_regionStr = cmbReg.getSelectedItem().toString();
//        //            m_region = m_regFonc.getTblRegions().get(m_regionStr);
//
        activerEnregistrer(false);
        setErrorMsg("Vous n'avez pas saisi de titre");
    }

    private void initDocumentProperties() {
        txtTitre.getDocument().addDocumentListener(new DocumentListenerSaisie(this));
        txtTitre.getDocument().putProperty("source", txtTitre);
        txtTitre.putClientProperty("id", "txtTitre");

        txtExp.getDocument().addDocumentListener(new DocumentListenerSaisie(this));
        txtExp.getDocument().putProperty("source", txtExp);
        txtExp.putClientProperty("id", "txtExp");

        txtSalmin.getDocument().addDocumentListener(new DocumentListenerSaisie(this));
        txtSalmin.getDocument().putProperty("source", txtSalmin);
        txtSalmin.putClientProperty("id", "txtSalmin");

        txtSalmax.getDocument().addDocumentListener(new DocumentListenerSaisie(this));
        txtSalmax.getDocument().putProperty("source", txtSalmax);
        txtSalmax.putClientProperty("id", "txtSalmax");
    }

    private void initRegionList() {
//        Vector comboBoxItems = new Vector();
//        Vector comboBoxItems = m_regFonc.getRegVecNom();
        ArrayList<String> regionNomList = RegionNoyauFonctionnel.getRegVecNom();
        //Vector comboBoxItems = new Vector();
        //comboBoxItems.setSize(regionNomList.size());
        // System.out.println(regionNomList.size() + "|" + comboBoxItems.size() + " 1111111111111");
        // Collections.copy(comboBoxItems, regionNomList);
        //DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);       
        // cmbReg.setModel(model);
//        cmbReg.addItem("--select Region--");  //if selected, set to null
        for (String lst : regionNomList) {
            cmbReg.addItem(lst);
        }
        cmbReg.setSelectedIndex(0);
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
        lblExp = new javax.swing.JLabel();
        txtExp = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        lblSalmin = new javax.swing.JLabel();
        txtSalmin = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        lblSalmax = new javax.swing.JLabel();
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
        jPanel44 = new javax.swing.JPanel();
        jLabelMsg = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabelMsg1 = new javax.swing.JLabel();

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
        optEmploi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        optEmploi.setSelected(true);
        optEmploi.setText("Emploi");
        optEmploi.setToolTipText("");
        optEmploi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEmploiActionPerformed(evt);
            }
        });
        jPanel2.add(optEmploi);

        grpOffreType.add(optStage);
        optStage.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        optStage.setText("Stage");
        optStage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optStageActionPerformed(evt);
            }
        });
        jPanel2.add(optStage);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new java.awt.GridLayout(5, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Titre :");
        jPanel5.add(jLabel1);

        txtTitre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitreActionPerformed(evt);
            }
        });
        jPanel5.add(txtTitre);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Region :");
        jPanel6.add(jLabel2);

        cmbReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegActionPerformed(evt);
            }
        });
        jPanel6.add(cmbReg);

        jPanel4.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        lblExp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblExp.setText("Année Expérience :");
        lblExp.setToolTipText("");
        jPanel7.add(lblExp);

        txtExp.setText("0");
        txtExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpActionPerformed(evt);
            }
        });
        jPanel7.add(txtExp);

        jPanel4.add(jPanel7);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        lblSalmin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSalmin.setText("Salaire Min :");
        jPanel9.add(lblSalmin);

        txtSalmin.setText("0");
        txtSalmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalminActionPerformed(evt);
            }
        });
        jPanel9.add(txtSalmin);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        lblSalmax.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSalmax.setText("Salaire Max :");
        jPanel10.add(lblSalmax);

        txtSalmax.setText("0");
        jPanel10.add(txtSalmax);

        jPanel4.add(jPanel10);

        jPanel3.add(jPanel4);

        jPanel16.setLayout(new java.awt.GridLayout(1, 1));

        jPanel18.setLayout(new java.awt.GridLayout(3, 0));

        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Compétence :");
        jPanel19.add(jLabel8);

        cmbComp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cmbComp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Program", "Item 2", "Item 3", "Item 4" }));
        jPanel19.add(cmbComp);

        jPanel18.add(jPanel19);

        jPanel20.setLayout(new java.awt.GridLayout(2, 0));

        grpCompType.add(optOblig);
        optOblig.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        optOblig.setText("obligatoire");
        optOblig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optObligActionPerformed(evt);
            }
        });
        jPanel20.add(optOblig);

        grpCompType.add(optSouh);
        optSouh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        optSouh.setSelected(true);
        optSouh.setText("souhaitée");
        optSouh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSouhActionPerformed(evt);
            }
        });
        jPanel20.add(optSouh);

        jPanel18.add(jPanel20);

        btnAjouter.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        jPanel14.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Compétence choisies :");

        tblComp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
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

        btnSup.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSup.setText("Supprimer");
        btnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActionPerformed(evt);
            }
        });
        jPanel8.add(btnSup);

        jPanel14.add(jPanel8);

        jPanel13.add(jPanel14);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btnEnreg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEnreg.setText("Enregistrer");
        btnEnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregActionPerformed(evt);
            }
        });
        jPanel12.add(btnEnreg);

        btnRAZ.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRAZ.setText("RAZ");
        btnRAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAZActionPerformed(evt);
            }
        });
        jPanel12.add(btnRAZ);

        jPanel11.add(jPanel12);

        jLabelMsg.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabelMsg.setForeground(new java.awt.Color(204, 102, 0));
        jLabelMsg.setText("Message Erreur");
        jPanel44.add(jLabelMsg);

        jLabelMsg1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabelMsg1.setText("Publication des Offres");
        jPanel45.add(jLabelMsg1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optEmploiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEmploiActionPerformed
        // TODO add your handling code here:    
        txtExp.setEnabled(true);
        txtSalmax.setEnabled(true);
        txtSalmin.setEnabled(true);
    }//GEN-LAST:event_optEmploiActionPerformed

    private void optSouhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSouhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optSouhActionPerformed

    private void optObligActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optObligActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optObligActionPerformed

    private void btnEnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregActionPerformed
        // TODO add your handling code here:

        // myTODO check region list seleted
        if (optEmploi.isSelected() || optStage.isSelected()) {
            m_offreType = optEmploi.isSelected();
            m_titre = txtTitre.getText();
            m_regionStr = cmbReg.getSelectedItem().toString();
//            m_region = m_regFonc.getTblRegions().get(m_regionStr);
            m_region = RegionNoyauFonctionnel.getTblRegions().get(m_regionStr);

            m_exp = Integer.parseInt(txtExp.getText());
            m_salMin = Integer.parseInt(txtSalmin.getText());
            m_salMax = Integer.parseInt(txtSalmax.getText());

            if (m_offreType) {
                // Emploi emp = new Emploi(m_titre, m_region, m_exp, m_salMin, m_salMax, m_lstcomps);
//                FileOperation fileout = new FileOperation();
//                fileout.enrgOffre(m_titre, m_region, m_exp, m_salMin, m_salMax, m_tblComps);
                JOptionPane.showMessageDialog(null, "Votre offre a été bien enregistrée! ", "ACCUSE", JOptionPane.INFORMATION_MESSAGE);
                m_offre = new Emploi(m_titre, m_region, m_exp, m_salMin, m_salMax, m_tblComps);
            } else {
                JOptionPane.showMessageDialog(null, "Votre offre a été bien enregistrée! ", "ACCUSE", JOptionPane.INFORMATION_MESSAGE);
                m_offre = new Stage(m_titre, m_region, m_tblComps);
            }

            m_offre.enregistrer();
            m_offreEnreg.remiseAZero();
            init();
            afficherNoyauFonctionnel();
        } else {
            //TODO
//            if (optEmploi.isSelected() || optStage.isSelected()) {
//            btnAjouter.setEnabled(false);
//            btnEnreg.setEnabled(false);
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
//        if (cmbReg.getSelectedIndex() == 0) {
//            activerEnregistrer(false);
//        }
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
        this.ajouterComp();
        afficherNoyauFonctionnel();
//        m_offreEnreg.ajouterComp(null, null);
//        Offre offre = new Emploi();
//        System.out.println("offreGetClass" + offre.getClass());
//        System.out.println(offre instanceof Emploi);
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActionPerformed
        // TODO add your handling code here:
        retirerComp();
        afficherNoyauFonctionnel();
    }//GEN-LAST:event_btnSupActionPerformed

    private void txtExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpActionPerformed

    private void btnRAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAZActionPerformed
        // TODO add your handling code here:
        m_offreEnreg.remiseAZero();
        init();
        afficherNoyauFonctionnel();
    }//GEN-LAST:event_btnRAZActionPerformed

    private void optStageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optStageActionPerformed
        // TODO add your handling code here:
        txtExp.setEnabled(false);
        txtSalmax.setEnabled(false);
        txtSalmin.setEnabled(false);
        txtTitre.setText(txtTitre.getText());
//        txtExp.setText("0");
//        txtSalmax.setText("0");
//        txtSalmin.setText("0");               

    }//GEN-LAST:event_optStageActionPerformed


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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JLabel jLabelMsg1;
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
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblExp;
    private javax.swing.JLabel lblSalmax;
    private javax.swing.JLabel lblSalmin;
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

    public int getSelectedRegIndex() {
        return cmbReg.getSelectedIndex();
    }

    private void ajouterComp() {
        String nomC;
        nomC = cmbComp.getSelectedItem().toString();

        if (!m_setComp.contains(nomC)) {
            m_setComp.add(nomC);
//            System.out.println("m_setComp :" + m_setComp);
//            System.out.println("m_setComp size :" + m_setComp.size());

//            Competence comp = new Competence(nomC);
//            CompType compType = new CompType("souhaitee");
            Competence comp = ComptNoyauFonctionnel.getTblCompetences().get(nomC);
            CompType compType = ComptNoyauFonctionnel.getSouh();

//            CompType compType = new CompType("souhaitee");
            if (optOblig.isSelected()) {
                compType = ComptNoyauFonctionnel.getOblig();
            } else if (optOblig.isSelected()) {
                compType = ComptNoyauFonctionnel.getSouh();
            }

            m_offreEnreg.ajouterComp(comp, compType);
//            m_enregComp.ajouterComp(comp, compType);
//            System.out.println(nomC + "|" + m_enregComp.getSize() + "##|##" + m_offreEnreg.getComps().size() + "PS.java");
        }
    }

    private void retirerComp() {
        tblComp.getSelectedRows();

        int lstCompRows[] = tblComp.getSelectedRows();
//System.out.println(lstCompsStr.size() + "|" + lstCompsStr + "PanelRechercherrrrrrrrrrrrr.java");

//       m_offreEnreg.getComps.
//System.out.println(m_enregistreurDeComp.getCompetences().size() + "|" + m_enregistreurDeComp.getCompetences() + "##PanelRechercher.java");   
        String nomC;
        ArrayList<String> lstCompNomsSup = new ArrayList<>();

        for (int row : lstCompRows) {
//            System.out.println(row + "|" + tblComp.getValueAt(row, 0) + "++row ++++++++++++++++PS.java");
            nomC = (String) tblComp.getValueAt(row, 0); //   cmbComp.getSelectedItem().toString(); 
            lstCompNomsSup.add(nomC);
        }

        for (String nomSup : lstCompNomsSup) {
            if (m_setComp.contains(nomSup)) {
                m_setComp.remove(nomSup);
                Competence comp = ComptNoyauFonctionnel.getTblCompetences().get(nomSup);

                m_offreEnreg.retirerComp(comp);
//            m_enregComp.retirerComp(comp);
//                System.out.println(nomSup + "|" + m_offreEnreg.getComps().size() + "##|##" + m_offreEnreg.getComps().size() + "PS.java");
            }
        }

//                  m_offreEnreg.retirerCompetence(ComptNoyauFonctionnel.getTblCompetences().get());
//System.out.println(nomC + tblComp.getSelectionModel().toString() +  "++nom ++++++++++++++++PS.java");
//nomC = "BI";
//        if (m_setComp.contains(nomC)) {
//            m_setComp.remove(nomC);
//            Competence comp = ComptNoyauFonctionnel.getTblCompetences().get(nomC);
//           
//m_offreEnreg.retirerComp(comp);
////            m_enregComp.retirerComp(comp);
//            System.out.println(nomC + "|" + m_offreEnreg.getComps().size() + "##|##" + m_offreEnreg.getComps().size() + "PS.java"); 
//        }
    }

    private void afficherNoyauFonctionnel() {
//        System.out.println(m_enregComp.getSize());
//        int compsSize = m_enregComp.getSize();
        int compsSize = m_offreEnreg.getComps().size();
        if (compsSize > 0) {
            activerSupprimer(true);
        } else {
            activerSupprimer(false);
        }
//        System.out.println(compsSize + "##|##" + m_offreEnreg.getComps().size());
        m_tblComps = m_offreEnreg.getComps();

        Object[][] m_compContent = new Object[compsSize][2];

        int i = 0;

        Iterator iter = m_tblComps.keySet().iterator();
        while (iter.hasNext()) {
            Competence key = (Competence) iter.next();
            m_compContent[i][0] = key.getNomComp();
            m_compContent[i][1] = m_tblComps.get(key).getLibType();
//            System.out.println("key,val: " + m_compContent[i][0] + "," + m_compContent[i][1]);
            i++;
        }

//        for (int i = 0; i < compsSize; i++) {
//            m_compContent[i][0] = m_tblComps.get(i).getNomComp();
//            m_compContent[i][1] = m_lstcomps.get(i).isObligatoire();
//        }
        //m_lstcomps = enregComp.getComps();      
        String[] columnNames = {"Competence", "Type"};
        //Object[][] data = enregComp.getCompContent();
        DefaultTableModel model = new DefaultTableModel(m_compContent, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tblComp.setModel(model);
    }

//    private int getCompsSize() {
//        return m_offreEnreg.getComps().size();
//    }

    public void activerEnregistrer(boolean b) {
        btnEnreg.setEnabled(b);
        m_enregistrerPossible = b;
    }

    public void activerSupprimer(boolean b) {
        btnSup.setEnabled(b);
    }

    public void activerRAZ(boolean b) {
        btnRAZ.setEnabled(b);
//        m_enregistrerPossible = b;
    }

    public void procBtnRAZ() {
        int compsSize = m_offreEnreg.getComps().size();
        if (!optEmploi.isSelected()
                || !txtTitre.getText().isEmpty()
                || cmbReg.getSelectedIndex() != 0
                || !"0".equals(txtExp.getText())
                || !"0".equals(txtSalmin.getText())
                || !"0".equals(txtSalmax.getText())
                || cmbComp.getSelectedIndex() != 0
                || !optSouh.isSelected()
                || compsSize > 0) {
            activerRAZ(true);
        } else {
            activerRAZ(false);
        }
    }

    public boolean isEmploi() {
        if (optEmploi.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void modelChanged() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public void setErrorMsg(String msg) {
        this.jLabelMsg.setText(msg);
    }
}
