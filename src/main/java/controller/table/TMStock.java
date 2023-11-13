/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Stock;

/**
 *
 * @author vinic
 */
public class TMStock extends AbstractTableModel {

    private List<Stock> lista;

    private final int COL_ID = 0;
    private final int COL_CODIGO = 1;
    private final int COL_DESCRICAO = 2;
    private final int COL_FORNECEDOR = 3;
    private final int COL_PRECOCUSTO = 4;
    private final int COL_PRECOVENDA = 5;
    private final int COL_QUANTESTOQUE = 6;

    public TMStock(List<Stock> lstStocks) {
        this.lista = lstStocks;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stock aux = (lista.isEmpty()) ? new Stock() : lista.get(rowIndex);

        switch (columnIndex) {
            case -1 -> {
                return aux;
            }
            case COL_ID -> {
                return aux.getId();
            }
            case COL_CODIGO -> {
                return aux.getCodigo();
            }
            case COL_DESCRICAO -> {
                return aux.getDescricao();
            }
            case COL_FORNECEDOR -> {
                return aux.getFornecedor();
            }
            case COL_PRECOCUSTO -> {
                return aux.getPrecoCusto();
            }
            case COL_PRECOVENDA -> {
                return aux.getPrecoVenda();
            }
            case COL_QUANTESTOQUE -> {
                return aux.getQuantEstoque();
            }
            default -> {
            }
        }

        return aux;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID -> {
                return "Id";
            }
            case COL_CODIGO -> {
                return "Código";
            }
            case COL_DESCRICAO -> {
                return "Descrição";
            }
            case COL_FORNECEDOR -> {
                return "Fornecedor";
            }
            case COL_PRECOCUSTO -> {
                return "P. de Custo";
            }
            case COL_PRECOVENDA -> {
                return "P. de Venda";
            }
            case COL_QUANTESTOQUE -> {
                return "Quat. em estoque";
            }
            default -> {
            }
        }

        return "";
    }

}
