/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.senac.toys2you.View;

import com.senac.toys2you.Controller.Toys2YouController;
import com.senac.toys2you.DAO.ProdutoDAOImpl;
import com.senac.toys2you.Model.Cliente;
import com.senac.toys2you.Model.Movimento;
import com.senac.toys2you.Model.Produto;
import com.senac.toys2you.Model.Venda;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class TelaFrenteCaixaPDV extends javax.swing.JInternalFrame {

    ProdutoDAOImpl produtoDAOImpl = new ProdutoDAOImpl();
    Toys2YouController toy = new Toys2YouController();
    Integer venda = 0;
    DefaultTableModel modelo = null;
    /**
     * Creates new form TelaFrenteCaixaPDV
     */
    public TelaFrenteCaixaPDV() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        initComponents();
        this.txtDS_TOTALVENDA.setText("0");
        this.txtDS_VOLUME.setText("0");
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDS_CODIGO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDS_QUANTIDADE = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDS_VALORUNITARIO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDS_VALORTOTAL = new javax.swing.JTextField();
        txtDS_TOTALVENDA = new javax.swing.JTextField();
        txtDS_VOLUME = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDS_CODIGOCLI = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Quant.", "Valor Unit.", "Preço Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Código:");

        txtDS_CODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDS_CODIGOActionPerformed(evt);
            }
        });
        txtDS_CODIGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDS_CODIGOKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Quantidade:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Geral:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Valor Unitario:");

        txtDS_QUANTIDADE.setText("1");
        txtDS_QUANTIDADE.setEnabled(false);
        txtDS_QUANTIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDS_QUANTIDADEActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Lista de compras");

        txtDS_VALORUNITARIO.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Valor Total:");

        txtDS_VALORTOTAL.setEnabled(false);

        txtDS_TOTALVENDA.setEnabled(false);

        txtDS_VOLUME.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Itens:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cliente:");

        txtDS_CODIGOCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDS_CODIGOCLIActionPerformed(evt);
            }
        });
        txtDS_CODIGOCLI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDS_CODIGOCLIKeyPressed(evt);
            }
        });

        jButton6.setText("Finalizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtDS_CODIGOCLI, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(txtDS_VALORUNITARIO)
                    .addComponent(txtDS_QUANTIDADE)
                    .addComponent(txtDS_CODIGO, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtDS_VALORTOTAL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtDS_VOLUME, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDS_TOTALVENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDS_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDS_QUANTIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDS_VALORUNITARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDS_VALORTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDS_CODIGOCLI, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDS_TOTALVENDA)
                            .addComponent(txtDS_VOLUME, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDS_QUANTIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDS_QUANTIDADEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDS_QUANTIDADEActionPerformed

    private void txtDS_CODIGOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDS_CODIGOKeyPressed
        if(evt.getKeyCode() == 10){
                Produto obj = new Produto();
                
                if(!txtDS_CODIGO.getText().isBlank()){
                    List<Produto> lista =  toy.ConsultaProduto("", txtDS_CODIGO.getText() );
                    

                     for (Produto item : lista) {
                         txtDS_VALORUNITARIO.setText(String.valueOf(item.getValor()));
                         txtDS_VALORTOTAL.setText(String.valueOf(item.getValor()));
                         txtDS_TOTALVENDA.setText(String.valueOf(Double.valueOf(txtDS_TOTALVENDA.getText()) + item.getValor()));
                         txtDS_VOLUME.setText(String.valueOf(Integer.valueOf(txtDS_VOLUME.getText()) + 1));
                         
                         modelo.addRow(new String[]{String.valueOf(item.getId()),
                                            item.getNome(),
                                            "1",
                                            String.valueOf(item.getValor()),
                                            String.valueOf(item.getValor())
                                         });
                         Movimento mov = new Movimento();
                         
                         mov.setProduto(Integer.valueOf(txtDS_CODIGO.getText()));
                         mov.setQtProduto(1);
                         mov.setTotal(Double.valueOf(txtDS_VALORUNITARIO.getText()));
                         mov.setTipo("S");
                         
                        toy.adicionaMovimento(mov, venda );
                         
                     }
                    }else{
                        List<Produto> lista = toy.ConsultaProduto("", txtDS_CODIGO.getText() );
                        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

                        modelo.setRowCount(0);
                         for (Produto item : lista) {
                            txtDS_VALORUNITARIO.setText(String.valueOf(item.getValor()));
                            txtDS_VALORTOTAL.setText(String.valueOf(item.getValor()));
                            txtDS_TOTALVENDA.setText(String.valueOf(Double.valueOf(txtDS_TOTALVENDA.getText()) + item.getValor()));
                            txtDS_VOLUME.setText(String.valueOf(Integer.valueOf(txtDS_VOLUME.getText()) + 1));
                         }
                    }   
        }
        if(evt.getKeyCode() == 27){
            
        }
    }//GEN-LAST:event_txtDS_CODIGOKeyPressed

    private void txtDS_CODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDS_CODIGOActionPerformed
    }//GEN-LAST:event_txtDS_CODIGOActionPerformed

    private void txtDS_CODIGOCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDS_CODIGOCLIActionPerformed
    }//GEN-LAST:event_txtDS_CODIGOCLIActionPerformed

    private void txtDS_CODIGOCLIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDS_CODIGOCLIKeyPressed
        if(evt.getKeyCode() == 10){
            
            String sql = "SELECT * FROM TB_VENDA ORDER BY PK_ID DESC LIMIT 1 ";

            Connection conexao = produtoDAOImpl.connect(toy.getUrl(), "root", "");
            try {
                
                Venda ven = new Venda();
                
                ven.setCliente(Integer.valueOf(txtDS_CODIGOCLI.getText()));
                ven.setValorTotal(Double.valueOf(txtDS_TOTALVENDA.getText()));
                ven.setDataPagamento(Date.valueOf(LocalDate.now()));
                
                toy.adicionaVenda(ven);
                
                PreparedStatement statement = conexao.prepareStatement(sql);

                ResultSet resultado = statement.executeQuery(sql);
                
               
                venda = Integer.valueOf(resultado.getString("PK_ID"));
                
                if(venda < 6){
                    venda = 6;
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtDS_CODIGOCLIKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        toy.alteraVenda(venda, Double.valueOf(txtDS_TOTALVENDA.getText()));
        
        
        TelaFrenteCaixaPDV telaNew = new TelaFrenteCaixaPDV();
        
        
        try {
            telaNew.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        telaNew.setVisible(true);
        
        this.dispose();
        
        
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDS_CODIGO;
    private javax.swing.JTextField txtDS_CODIGOCLI;
    private javax.swing.JTextField txtDS_QUANTIDADE;
    private javax.swing.JTextField txtDS_TOTALVENDA;
    private javax.swing.JTextField txtDS_VALORTOTAL;
    private javax.swing.JTextField txtDS_VALORUNITARIO;
    private javax.swing.JTextField txtDS_VOLUME;
    // End of variables declaration//GEN-END:variables
}
