/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import javax.swing.JOptionPane;
import model.Stock;
import model.exceptions.StockException;

/**
 *
 * @author vinic
 */
public class ValidateStock {

    public Stock validaCamposEntrada(Integer codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor) {
        if (codigo == null || descricao.isEmpty() || precoCusto <= 0 || precoVenda <= 0 || quantEstoque == null || fornecedor.isEmpty()) {
            throw new StockException("Erro - Preencha todos os campos corretamente.");
        }

        Stock stock = new Stock();
        stock.setCodigo(codigo);
        stock.setDescricao(descricao);
        stock.setPrecoCusto(precoCusto);
        stock.setPrecoVenda(precoVenda);
        stock.setQuantEstoque(quantEstoque);
        stock.setFornecedor(fornecedor);

        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        return stock;
    }

}
