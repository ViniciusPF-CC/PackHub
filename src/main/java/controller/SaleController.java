/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.table.TMSale;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JTable;
import model.Employee;
import model.Sale;
import model.Stock;
import model.dao.SaleDAO;
import model.exceptions.SaleException;
import model.valid.ValidateSale;
import model.valid.ValidateStock;

/**
 *
 * @author Gabriel
 */
public class SaleController {

    private SaleDAO repositorio;

    public SaleController() {
        repositorio = new SaleDAO();
    }

    private Integer getIdDoidStock(String idStock) {
        if (idStock.equals("")) {
            return null;
        }
        String[] novoIdStock = idStock.split(" - ");
        return Integer.parseInt(novoIdStock[0]);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMSale tableModel = new TMSale(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }

    public void atualizarTabela(JTable grd, String idFuncionario) {

        List lst = repositorio.findAll();
        TMSale tableModel = new TMSale(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }

    public void cadastrarSale(LocalDateTime dataHora, List<Stock> produtos, double valor, double pagamento, int quantidadeVendida) {

        ValidateSale valid = new ValidateSale();
        Sale sale = valid.validaCamposEntrada(dataHora, produtos, valor, pagamento, 0);

        if (repositorio.find(sale.getId()) != null) {
            throw new SaleException("Error - Já existe um produto com esse código");
        } else {
            repositorio.save(sale);
        }
    }

    public void atualizarSale(Long id, LocalDateTime dataHora, List<Stock> produtos, double valor, double pagamento, int quantidadeVendida) {

        ValidateSale valid = new ValidateSale();
        Sale novaSale = valid.validaCamposEntrada(dataHora, produtos, valor, pagamento, 0);
        novaSale.setId(id);
        repositorio.update(novaSale);
    }

    public Sale buscarSalePorId(Long id) {
        if (id == null) {
            return null;
        }
        Sale sale = (Sale) repositorio.find(id);
        return sale;
    }

    public void excluirSale(Long id) {
        if (id != -1) {
            repositorio.delete(id);
        } else {
            throw new SaleException("Error - Item inexistente.");
        }
    }

}
