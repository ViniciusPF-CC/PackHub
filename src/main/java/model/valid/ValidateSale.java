/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import java.time.LocalDateTime;
import java.util.List;
import model.Sale;
import model.Stock;
import model.User;
import model.exceptions.SaleException;

/**
 *
 * @author Gabriel
 */
public class ValidateSale {

    public Sale validaCamposEntrada(LocalDateTime dataHora, Stock produto, double valor, String pagamento, int quantidadeVendida, User vendedor) {
        Sale sale = new Sale();
        if (dataHora.equals(null) || produto.equals(null) || valor == 0.0 || pagamento.isEmpty() || quantidadeVendida == 0 || vendedor.equals(null)) {
            throw new SaleException("Erro - Preencha todos os campos.");
        }

        sale.setDataHora(dataHora);
        sale.setProduto(produto);
        sale.setValor(valor);
        sale.setPagamento(pagamento);
        sale.setQuantidadeVendida(quantidadeVendida);
        sale.setVendedor(vendedor);

        return sale;
    }

}
