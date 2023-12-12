/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.SaleController;
import controller.StockController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Stock;
import model.exceptions.StockException;
import controller.SupplierController;
import controller.UserController;
import java.time.LocalDateTime;
import model.Sale;
import model.Supplier;
import model.exceptions.SaleException;

/**
 *
 * @author vinic
 */
public class FrRegisterSale extends javax.swing.JDialog {

    SaleController saleController;
    StockController stockController;
    UserController userController;
    Long idSaleEditando;

    public FrRegisterSale(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        saleController = new SaleController();
        saleController.atualizarTabela(grdSales);
    }

    public void produtoCombobox() {
        cbxProduto.addItem("");
        String[] produtosString = stockController.buscarStockString().split("\n");

        for (String stockId : produtosString) {
            cbxProduto.addItem(stockId);
        }
    }

    public void vendedorCombobox() {
        cbxVendedor.addItem("");
        String[] vendedoresString = userController.buscarUserString().split("\n");

        for (String userId : vendedoresString) {
            cbxVendedor.addItem(userId);
        }
    }

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdSales.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdSales.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    public void limparCampos() {
        edtQuantVendida.setText("");
        edtValor.setText("");
        edtPagamento.setText("");
    }

    public void preencherFormulario(Sale sale) {
        edtValor.setText(sale.getValor()+ "");
        edtQuantVendida.setText(sale.getQuantidadeVendida()+ "");
        edtPagamento.setText(sale.getPagamento()+ "");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImgTitle = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdSales = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edtValor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtQuantVendida = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxVendedor = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        edtPagamento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar item");

        lblImgTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Registrar Venda");

        grdSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod.", "Nome", "Preço", "Q. Estoque", "Edit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grdSales);

        jLabel3.setText("Produto:");

        jLabel6.setText("Valor:");

        jLabel7.setText("Quantidade vendida:");

        jLabel8.setText("Vendedor:");

        cbxVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVendedorActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btnSave.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btnEdit.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btnCancel.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel9.setText("Ações para tabela:");

        jLabel10.setText("Pagamento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(edtQuantVendida)
                            .addComponent(jLabel7)
                            .addComponent(cbxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(edtPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImgTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtQuantVendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnExcluir)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVendedorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String produto = String.valueOf(cbxProduto.getSelectedItem());
            String quantidadeVendida = edtQuantVendida.getText();
            float valor = Float.parseFloat(edtValor.getText());
            String vendedor = String.valueOf(cbxVendedor.getSelectedItem());
            String payment = edtPagamento.getText();
            if (idSaleEditando > 0) {
                saleController.atualizarSale(idSaleEditando, LocalDateTime.MAX, produtos, 0, pagamento, FRAMEBITS);
                JOptionPane.showMessageDialog(null, "Edição feita com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                stockController.atualizarTabela(grdSales);
            } else {
                saleController.cadastrarSale(LocalDateTime.MAX, produtos, 0, pagamento, FRAMEBITS);
                JOptionPane.showMessageDialog(null, "Error - Já existe um produto com esse código", "Falha", JOptionPane.INFORMATION_MESSAGE);
                stockController.atualizarTabela(grdSales);
            }
            this.idSaleEditando = -1L;
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valores: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Erro ao converter valores: " + e.getMessage());
        } catch (StockException s) {
            System.err.println(s.getMessage());
            JOptionPane.showMessageDialog(this, s.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Sale saleEditando = (Sale) this.getObjetoSelecionadoNaGrid();

        if (saleEditando == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.preencherFormulario(saleEditando);
            this.idSaleEditando = saleEditando.getId();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Sale saleExcluido = (Sale) this.getObjetoSelecionadoNaGrid();

        if (saleExcluido == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja exlcuir o  \n("
                    + saleExcluido.getProdutos()+ ", ",
                    "Confirmar exclusão",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    this.idSaleEditando = saleExcluido.getId();
                    saleController.excluirSale(this.idSaleEditando);

                    saleController.atualizarTabela(grdSales);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (StockException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JComboBox<String> cbxVendedor;
    private javax.swing.JTextField edtPagamento;
    private javax.swing.JTextField edtQuantVendida;
    private javax.swing.JTextField edtValor;
    private javax.swing.JTable grdSales;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImgTitle;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}