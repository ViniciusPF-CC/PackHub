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
import controller.SupplierController;
import controller.UserController;
import java.time.LocalDateTime;
import java.util.List;
import model.Sale;
import model.Supplier;
import model.User;
import model.auth.Autenticador;
import model.exceptions.SaleException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
        edtValor.setEditable(false);
        saleController = new SaleController();
        userController = new UserController();
        saleController.atualizarTabelaUser(grdSales);
        idSaleEditando = -1L;
        produtoCombobox();

        edtQuantVendida.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateValor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateValor();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateValor();
            }

            private void updateValor() {
                try {
                    int quantidadeVendida = Integer.parseInt(edtQuantVendida.getText());

                    String[] produto = String.valueOf(cbxProduto.getSelectedItem()).split("-");

                    long idProduto = Long.parseLong(produto[0].trim());

                    double preco = stockController.buscarPrecoPorId(idProduto);

                    double valorTotal = quantidadeVendida * preco;

                    edtValor.setText(String.valueOf(valorTotal));
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                    edtValor.setText("");
                }
            }
        });
    }

    public void produtoCombobox() {
        stockController = new StockController();
        cbxProduto.addItem("");
        String[] produtosString = stockController.buscarStockString().split("\n");

        for (String stockId : produtosString) {
            cbxProduto.addItem(stockId);
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
    }

    public void preencherFormulario(Sale sale) {

        if (sale.getProduto() != null) {
            cbxProduto.setSelectedItem(sale.getProduto());
        }
        edtValor.setText(sale.getValor() + "");
        edtQuantVendida.setText(sale.getQuantidadeVendida() + "");
        if (sale.getPagamento() != null) {
            cbxPagamento.setSelectedItem(sale.getPagamento());
        }
    }

    private boolean verificarEstoqueSuficiente(long idProduto, int quantidadeVendida) {
        int estoqueAtual = stockController.buscarQuantidadeEstoquebyId(idProduto);
        return estoqueAtual >= quantidadeVendida;
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
        btnSalvar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxPagamento = new javax.swing.JComboBox<>();
        btnLimparCampos = new javax.swing.JButton();
        lbUserName = new javax.swing.JLabel();
        lblValorComissao = new javax.swing.JLabel();
        imgUser = new javax.swing.JLabel();

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

        edtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtValorActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade vendida:");

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

        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        jLabel10.setText("Pagamento:");

        cbxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "à vista", "a prazo" }));
        cbxPagamento.setSelectedIndex(-1);
        cbxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPagamentoActionPerformed(evt);
            }
        });

        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        lbUserName.setText("Olá Fulano");

        lblValorComissao.setText("Comissao");

        imgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblImgTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValorComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxPagamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtQuantVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnEdit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimparCampos)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgUser)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lbUserName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorComissao)))
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
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnExcluir)
                    .addComponent(jLabel9)
                    .addComponent(btnLimparCampos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String produto = String.valueOf(cbxProduto.getSelectedItem());

            String[] produto1 = String.valueOf(cbxProduto.getSelectedItem()).split("-");

            long idProduto = Long.parseLong(produto1[0].trim());

            int quantidadeVendida = Integer.parseInt(edtQuantVendida.getText());
            double valor = Double.parseDouble(edtValor.getText());

            String pagamento = String.valueOf(cbxPagamento.getSelectedItem());
            String vendedor = String.valueOf(Autenticador.getIdLogado());

            if (verificarEstoqueSuficiente(idProduto, quantidadeVendida)) {
                
                // Atualiza a venda
                if (idSaleEditando > 0) {
                    saleController.atualizarSale(idSaleEditando, LocalDateTime.now(), produto, valor, pagamento, quantidadeVendida, vendedor);
                    JOptionPane.showMessageDialog(null, "Edição feita com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    saleController.atualizarTabelaUser(grdSales);
                } else {
                    saleController.cadastrarSale(LocalDateTime.now(), produto, valor, pagamento, quantidadeVendida, vendedor);
                    JOptionPane.showMessageDialog(null, "Venda registrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    userController.atualizarValorReceber(Autenticador.getIdLogado(), valor);
                    saleController.atualizarTabelaUser(grdSales);
                }
                
                stockController.atualizarQauntidadeEstoque(idProduto, quantidadeVendida);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente para a venda", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            limparCampos();
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valores: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Erro ao converter valores: " + e.getMessage());
        } catch (SaleException s) {
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
                    + saleExcluido.getProduto() + ", ",
                    "Confirmar exclusão",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    this.idSaleEditando = saleExcluido.getId();
                    saleController.excluirSale(this.idSaleEditando);

                    saleController.atualizarTabela(grdSales);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (SaleException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPagamentoActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        // TODO add your handling code here:
        edtQuantVendida.setText("");
        edtValor.setText("");
        cbxProduto.removeAllItems();
        idSaleEditando = -1L;
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProdutoActionPerformed

    private void edtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtValorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxPagamento;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JTextField edtQuantVendida;
    private javax.swing.JTextField edtValor;
    private javax.swing.JTable grdSales;
    private javax.swing.JLabel imgUser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lblImgTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValorComissao;
    // End of variables declaration//GEN-END:variables
}
