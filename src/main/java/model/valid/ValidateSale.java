/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import java.time.LocalDateTime;
import java.util.List;
import model.Payment;
import model.Sale;
import model.Stock;
import model.exceptions.SaleException;

/**
 *
 * @author Gabriel
 */
public class ValidateSale {
    public Sale validaCamposEntrada(LocalDateTime dataHora, List<Stock> produtos, double valor, Payment pagamento){
        Sale sale = new Sale();
        if (dataHora.equals(null)|| produtos.isEmpty() || valor == 0.0 || pagamento.equals(null)) {
            throw new SaleException("Erro - Preencha todos os campos.");
        }
        
        sale.setDataHora(dataHora);
        sale.setProdutos(produtos);
        sale.setValor(valor);
        sale.setPagamento(pagamento);   

        return sale;
    }
    
}
