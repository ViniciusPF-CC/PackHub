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

    private Integer getIdDoidNome(String idNome) {
        if (idNome.equals("")) {
            return null;
        }
        String[] novoIdNome = idNome.split(" - ");
        return Integer.parseInt(novoIdNome[0]);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMStock tableModel = new TMStock(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }

    public void cadastrarStock(Integer codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor) {

        long idSupplier = getIdDoidNome(String.valueOf(fornecedor));

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

    public void atualizarStock(Long id, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor) {

        long idSupplier = getIdDoidNome(String.valueOf(fornecedor));

        SupplierController suppC = new SupplierController();

        Supplier suppV = suppC.buscarSupplierPorId(idSupplier);

        ValidateStock valid = new ValidateStock();
        Stock novoStock = valid.validaCamposEntrada(descricao, precoCusto, precoVenda, quantEstoque, suppV);
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

}
