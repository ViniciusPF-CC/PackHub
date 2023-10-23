/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Stock;
import model.dao.StockDAO;
import model.exceptions.StockException;
import model.valid.ValidateStock;
/**
 *
 * @author vinic
 */
public class StockController {
    private StockDAO respositorio;
    
    public StockController(){
        respositorio = new StockDAO();
    }
    
    public void cadastrarStock(Integer codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor) {
        ValidateStock valid = new ValidateStock();
        Stock stock = valid.validaCamposEntrada(codigo, descricao, precoCusto, precoVenda, quantEstoque, fornecedor);
        
        if(respositorio.findByCodigo(stock.getCodigo()) != null) {
            throw new StockException("Error - Já existe um produto com esse código");
        } else {
            respositorio.save(stock);
        }
    }
    
}
