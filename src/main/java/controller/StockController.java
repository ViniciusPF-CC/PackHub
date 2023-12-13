/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.table.TMStock;
import java.util.List;
import javax.swing.JTable;
import model.Stock;
import model.Supplier;
import model.dao.StockDAO;
import model.exceptions.StockException;
import model.valid.ValidateStock;

/**
 *
 * @author vinic
 */
public class StockController {

    private StockDAO repositorio;

    public StockController() {
        repositorio = new StockDAO();
    }

    private Integer getIdDoidSupplier(String idSupplier) {
        if (idSupplier.equals("")) {
            return null;
        }
        String[] novoIdSupplier = idSupplier.split(" - ");
        return Integer.parseInt(novoIdSupplier[0]);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMStock tableModel = new TMStock(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }

    public void cadastrarStock(String codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor) {

        long idSupplier = getIdDoidSupplier(String.valueOf(fornecedor));

        SupplierController suppC = new SupplierController();

        Supplier suppV = suppC.buscarSupplierPorId(idSupplier);

        ValidateStock valid = new ValidateStock();
        Stock stock = valid.validaCamposEntrada(codigo, descricao, precoCusto, precoVenda, quantEstoque, suppV);

        if (repositorio.findByCodigo(stock.getCodigo()) != null) {
            throw new StockException("Error - Já existe um produto com esse código");
        } else {
            repositorio.save(stock);
        }
    }

    public void atualizarStock(Long id, String codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor) {

        long idSupplier = getIdDoidSupplier(String.valueOf(fornecedor));

        SupplierController suppC = new SupplierController();

        Supplier suppV = suppC.buscarSupplierPorId(idSupplier);

        ValidateStock valid = new ValidateStock();
        Stock novoStock = valid.validaCamposEntrada(codigo, descricao, precoCusto, precoVenda, quantEstoque, suppV);
        novoStock.setId(id);
        repositorio.update(novoStock);

    }

    public void excluirStock(Long id) {
        if (id != -1) {
            repositorio.delete(id);
        } else {
            throw new StockException("Error - Item inexistente.");
        }
    }

    public String buscarStockString() {

        List<Stock> stocks = repositorio.findAll();

        String stockString = "";
        for (Stock stock : stocks) {
            stockString += stock.getId() + " - " + stock.getDescricao() + "\n";
        }

        return stockString;
    }

    public Stock buscarStockPorId(Long id) {
        if (id == null) {
            return null;
        }
        Stock stock = (Stock) repositorio.find(id);
        return stock;
    }

    public double buscarPrecoPorId(Long id) {
        Stock stock = (Stock) repositorio.find(id);
        if (stock != null) {
            return stock.getPrecoVenda();
        }
        return 0.0;
    }

    public int buscarQuantidadeEstoquebyId(Long id) {

        Stock stock = (Stock) repositorio.find(id);
        if (stock != null) {
            return stock.getQuantEstoque();
        }
        return 0;
    }

    public void atualizarQauntidadeEstoque(Long id, int quantidadeVendida) {
        Stock stock = (Stock) repositorio.find(id);
        if (stock != null) {
            int quantidadeAtual = stock.getQuantEstoque();
            int novaQuantidade = quantidadeAtual - quantidadeVendida;

            novaQuantidade = Math.max(0, novaQuantidade);

            stock.setQuantEstoque(novaQuantidade);

            repositorio.update(stock);
        }

    }
}
