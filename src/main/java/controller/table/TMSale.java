/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Sale;

/**
 *
 * @author Gabriel
 */
public class TMSale extends AbstractTableModel{
    
    private List<Sale> lista;
    
    private final int COL_ID = 0;
    private final int COL_DATAHORA = 1;
    private final int COL_PRODUTOS = 2;
    private final int COL_VALOR = 3;
    private final int COL_PAGAMENTO = 4;
    
    public TMSale(List<Sale> lstSale) {
        this.lista = lstSale;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale aux = (lista.isEmpty()) ? new Sale() : lista.get(rowIndex);

        switch (columnIndex) {
            case -1 -> {
                return aux;
            }
            case COL_ID -> {
                return aux.getId();
            }
            case COL_DATAHORA -> {
                return aux.getDataHora();
            }
            case COL_PRODUTOS -> {
                return aux.getProdutos();
            }
            case COL_VALOR -> {
                return aux.getValor();
            }
            case COL_PAGAMENTO -> {
                return aux.getPagamento();
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
            case COL_DATAHORA -> {
                return "Data";
            }
            case COL_PRODUTOS -> {
                return "Produtos";
            }
            case COL_VALOR -> {
                return "Valor";
            }
            case COL_PAGAMENTO -> {
                return "Pagamento";
            }
            default -> {
            }
        }
        return "";
    }
}
