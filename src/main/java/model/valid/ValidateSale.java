/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import java.time.LocalDateTime;
import java.util.List;
import model.Sale;
import model.Stock;
import model.exceptions.SaleException;

/**
 *
 * @author Gabriel
 */
public class ValidateSale {

    public Sale validaCamposEntrada(LocalDateTime dataHora, List<Stock> produtos, double valor, double pagamento, int quantidadeVendida) {
        Sale sale = new Sale();
        if (dataHora.equals(null) || produtos.isEmpty() || valor == 0.0 || pagamento == 0.0 || quantidadeVendida == 0.0) {
            throw new SaleException("Erro - Preencha todos os campos.");
        }

        sale.setDataHora(dataHora);
        sale.setProdutos(produtos);
        sale.setValor(valor);
        sale.setPagamento(pagamento);
        sale.setQuantidadeVendida(quantidadeVendida);

        return sale;
    }

}
