/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.table.TMSale;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JTable;
import model.Sale;
import model.User;
import model.Stock;
import model.dao.SaleDAO;
import model.exceptions.SaleException;
import model.valid.ValidateSale;
import model.auth.Autenticador;
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

    private Integer getIdDoidUser(String idUser) {
        if (idUser.equals("")) {
            return null;
        }
        String[] novoIdUser = idUser.split(" - ");
        return Integer.parseInt(novoIdUser[0]);
    }

    public void atualizarTabelaUser(JTable grd) {
        String idUsuarioLogado = Autenticador.getIdLogado().toString();
        List<Sale> lst = buscarVendasPorUsuario(idUsuarioLogado);
        TMSale tableModel = new TMSale(lst);
        Util.jTableShow(grd, tableModel, null);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMSale tableModel = new TMSale(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }

    public void cadastrarSale(LocalDateTime dataHora, String produto, double valor, String pagamento, int quantidadeVendida, String vendedor) {

        long idStock = getIdDoidStock(String.valueOf(produto));

        StockController stockS = new StockController();

        Stock stockV = stockS.buscarStockPorId(idStock);

        long idUser = getIdDoidUser(String.valueOf(vendedor));

        UserController userU = new UserController();

        User UserV = userU.buscarUserPorId(idUser);

        ValidateSale valid = new ValidateSale();
        Sale sale = valid.validaCamposEntrada(dataHora, stockV, valor, pagamento, quantidadeVendida, UserV);

        repositorio.save(sale);
    }

    public void atualizarSale(Long id, LocalDateTime dataHora, String produto, double valor, String pagamento, int quantidadeVendida, String vendedor) {

        long idStock = getIdDoidStock(String.valueOf(produto));

        StockController stockS = new StockController();

        Stock stockV = stockS.buscarStockPorId(idStock);

        long idUser = getIdDoidUser(String.valueOf(vendedor));

        UserController userU = new UserController();

        User UserV = userU.buscarUserPorId(idUser);

        ValidateSale valid = new ValidateSale();
        Sale novaSale = valid.validaCamposEntrada(dataHora, stockV, valor, pagamento, quantidadeVendida, UserV);

        novaSale.setId(id);

        if (repositorio.find(id) == null) {
            throw new SaleException("Error - Não existe uma venda com o ID fornecido para atualizar");
        }

        repositorio.update(novaSale);
    }

    public List<Sale> buscarVendasPorUsuario(String vendedorId) {
        if (vendedorId.equals("")) {
            return null;
        }
        return repositorio.findByUsuario(vendedorId);
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
