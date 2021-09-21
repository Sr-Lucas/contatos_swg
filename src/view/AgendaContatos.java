/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import model.Contato;

/**
 *
 * @author 71124
 */
public class AgendaContatos extends javax.swing.JFrame {
    private static final String INSERCAO = "insercao";
    private static final String EDICAO = "edicao";
    
    private String modo = "";
    private String codigoAtualEditando;
    private int linhaSelecionadaEditando;
    
    private static final String TIPO_CONTATO_PROFISSIONAL = "Profissional";
    private static final String TIPO_CONTATO_PESSOAL = "Pessoal";
    private static final String TIPO_CONTATO_OUTROS = "Outros";
    
    ArrayList<Contato> contatos;    
    /**
     * Creates new form AgendaContatos
     */
    public AgendaContatos() {
        contatos = new ArrayList<>();
        
        initComponents();
        setModo("");
        empresaPn.setVisible(false);
    }
    
    private void setModo(String modo) {
        
        boolean isModoInsercao = modo.equals(INSERCAO) || modo.equals(EDICAO);
        
        inserirBtn.setEnabled(!isModoInsercao);
        editarBtn.setEnabled(!isModoInsercao);
        excluirBtn.setEnabled(!isModoInsercao);
        
        cancelBtn.setEnabled(isModoInsercao);
        gravarBtn.setEnabled(isModoInsercao);
        
        nomeTxt.setEnabled(isModoInsercao);
        telTxt.setEnabled(isModoInsercao);
        celTxt.setEnabled(isModoInsercao);
        emailTxt.setEnabled(isModoInsercao);
        nomeEmpTxt.setEnabled(isModoInsercao);
        cargoEmpTxt.setEnabled(isModoInsercao);
        obsTxt.setEnabled(isModoInsercao);
        tipoContatoCb.setEnabled(isModoInsercao);
        favoritoChk.setEnabled(isModoInsercao);
        
        this.modo = modo;
        
        if (modo.equals(EDICAO)) getSelectedGridValues();
    }
    
    private void getSelectedGridValues() {
        this.linhaSelecionadaEditando = contatosTbl.getSelectedRow();
        
        nomeTxt.setText(contatosTbl.getModel().getValueAt(linhaSelecionadaEditando, 0).toString());
        String tipoContato =  contatosTbl.getModel().getValueAt(linhaSelecionadaEditando, 1).toString();
        
        switch (tipoContato) {
            case TIPO_CONTATO_PESSOAL:
                tipoContatoCb.setSelectedIndex(0);
                break;
            case TIPO_CONTATO_PROFISSIONAL:
                tipoContatoCb.setSelectedIndex(1);
                break;
            default:
                tipoContatoCb.setSelectedIndex(2);
                break;
        }
                
        favoritoChk.setSelected((boolean) contatosTbl.getModel().getValueAt(linhaSelecionadaEditando, 2));
        codigoAtualEditando = contatosTbl.getModel().getValueAt(linhaSelecionadaEditando, 3).toString();
    }
    
    private void inserirContato() {
        Contato contato = new Contato(
                UUID.randomUUID().toString(), 
                nomeTxt.getText(), 
                (String) tipoContatoCb.getSelectedItem(), 
                rootPaneCheckingEnabled, 
                celTxt.getText(), 
                emailTxt.getText(), 
                obsTxt.getText(), 
                nomeEmpTxt.getText(), 
                cargoEmpTxt.getText()
        );
        
        inserirTabela(contato);
    }
    
    private void inserirTabela(Contato contato) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) contatosTbl.getModel();
        
        Object[] linha = new Object[4];
        linha[0] = contato.getNome();
        linha[1] = contato.getTipo();
        linha[2] = contato.isFavorito();
        linha[3] = contato.getCodigo();
        
        defaultTableModel.addRow(linha);
    }
    
    private void editarTabela(Contato contato, int row) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) contatosTbl.getModel();
        
        defaultTableModel.setValueAt(contato.getNome(), row, 0);
        defaultTableModel.setValueAt(contato.getTipo(), row, 1);
        defaultTableModel.setValueAt(contato.isFavorito(), row, 2);
        defaultTableModel.setValueAt(contato.getCodigo(), row, 3);
    }
    
    private void removerTabela(int index) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) contatosTbl.getModel();
        
        defaultTableModel.removeRow(index);
    }
    
    private void editarContato(String codigo) {
        Contato contato = new Contato(
                codigo, 
                nomeTxt.getText(), 
                (String) tipoContatoCb.getSelectedItem(), 
                rootPaneCheckingEnabled, 
                celTxt.getText(), 
                emailTxt.getText(), 
                obsTxt.getText(), 
                nomeEmpTxt.getText(), 
                cargoEmpTxt.getText()
        );
        
        editarTabela(contato, linhaSelecionadaEditando);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        tipoContatoCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        favoritoChk = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        celTxt = new javax.swing.JTextField();
        telTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        obsTxt = new javax.swing.JEditorPane();
        empresaPn = new javax.swing.JPanel();
        cargoEmpTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomeEmpTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        contatosTbl = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        editarBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        gravarBtn = new javax.swing.JButton();
        inserirBtn = new javax.swing.JButton();
        excluirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agenda de Contatos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(282, 282, 282))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));
        jPanel2.setToolTipText("");

        jLabel2.setText("Tipo de contato");

        tipoContatoCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoal", "Profissional", "Outros" }));
        tipoContatoCb.setToolTipText("");
        tipoContatoCb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoContatoCbItemStateChanged(evt);
            }
        });

        jLabel3.setText("Nome");

        favoritoChk.setText("Favoritos");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefones"));

        jLabel4.setText("Telefone");

        jLabel5.setText("Celular");

        jLabel6.setText("Email");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telTxt)
                    .addComponent(celTxt)
                    .addComponent(emailTxt)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 169, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(celTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));

        jScrollPane1.setViewportView(obsTxt);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        empresaPn.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));

        jLabel7.setText("Cargo");

        jLabel8.setText("Nome");

        javax.swing.GroupLayout empresaPnLayout = new javax.swing.GroupLayout(empresaPn);
        empresaPn.setLayout(empresaPnLayout);
        empresaPnLayout.setHorizontalGroup(
            empresaPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empresaPnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(empresaPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeEmpTxt)
                    .addComponent(cargoEmpTxt)
                    .addGroup(empresaPnLayout.createSequentialGroup()
                        .addGroup(empresaPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        empresaPnLayout.setVerticalGroup(
            empresaPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empresaPnLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeEmpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargoEmpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contatosTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Contato", "Favorito", "Codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(contatosTbl);
        if (contatosTbl.getColumnModel().getColumnCount() > 0) {
            contatosTbl.getColumnModel().getColumn(0).setPreferredWidth(200);
            contatosTbl.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(empresaPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nomeTxt))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tipoContatoCb, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(favoritoChk)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoContatoCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favoritoChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(empresaPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editarBtn.setText("Editar");
        editarBtn.setMargin(null);
        editarBtn.setMaximumSize(null);
        editarBtn.setMinimumSize(null);
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancelar");
        cancelBtn.setMargin(null);
        cancelBtn.setMaximumSize(null);
        cancelBtn.setMinimumSize(null);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        gravarBtn.setText("Gravar");
        gravarBtn.setMargin(null);
        gravarBtn.setMaximumSize(null);
        gravarBtn.setMinimumSize(null);
        gravarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarBtnActionPerformed(evt);
            }
        });

        inserirBtn.setText("Inserir");
        inserirBtn.setMargin(null);
        inserirBtn.setMaximumSize(null);
        inserirBtn.setMinimumSize(null);
        inserirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirBtnActionPerformed(evt);
            }
        });

        excluirBtn.setText("Excluir");
        excluirBtn.setMargin(null);
        excluirBtn.setMaximumSize(null);
        excluirBtn.setMinimumSize(null);
        excluirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(inserirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gravarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(excluirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(190, 190, 190))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(excluirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(gravarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inserirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirBtnActionPerformed
        setModo(INSERCAO);
    }//GEN-LAST:event_inserirBtnActionPerformed

    private void gravarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarBtnActionPerformed
        if (modo.equals(INSERCAO)) {
            inserirContato();
        } else {
            editarContato(codigoAtualEditando);
        }
        
        setModo("");
        limparCampos();
    }//GEN-LAST:event_gravarBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setModo("");
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void tipoContatoCbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoContatoCbItemStateChanged
        String tipoContato = (String) tipoContatoCb.getSelectedItem();
        
        if(tipoContato.equals(TIPO_CONTATO_PROFISSIONAL)) {
            empresaPn.setVisible(true);
        } else {
            empresaPn.setVisible(false);
        }
    }//GEN-LAST:event_tipoContatoCbItemStateChanged

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        setModo(EDICAO);
    }//GEN-LAST:event_editarBtnActionPerformed

    private void excluirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBtnActionPerformed
        removerTabela(contatosTbl.getSelectedRow());
    }//GEN-LAST:event_excluirBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaContatos().setVisible(true);
            }
        });
    }
    
    private void limparCampos() {
        nomeTxt.setText("");
        telTxt.setText("");
        celTxt.setText("");
        emailTxt.setText("");
        nomeEmpTxt.setText("");
        cargoEmpTxt.setText("");
        obsTxt.setText("");
        favoritoChk.setSelected(false);
        tipoContatoCb.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField cargoEmpTxt;
    private javax.swing.JTextField celTxt;
    private javax.swing.JTable contatosTbl;
    private javax.swing.JButton editarBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JPanel empresaPn;
    private javax.swing.JButton excluirBtn;
    private javax.swing.JCheckBox favoritoChk;
    private javax.swing.JButton gravarBtn;
    private javax.swing.JButton inserirBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeEmpTxt;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JEditorPane obsTxt;
    private javax.swing.JTextField telTxt;
    private javax.swing.JComboBox<String> tipoContatoCb;
    // End of variables declaration//GEN-END:variables
}
