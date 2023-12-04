/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Supplier;

/**
 *
 * @author Gabriel
 */
public class TMSupplier extends AbstractTableModel {
    private List<Supplier> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_ENDERECO = 2;
    private final int COL_PHONE = 3;
    private final int COL_CNPJ = 4;

    public TMSupplier(List<Supplier> lstSupplier) {
        this.lista = lstSupplier;
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
        Supplier aux = (lista.isEmpty()) ? new Supplier() : lista.get(rowIndex);

        switch (columnIndex) {
            case -1 -> {
                return aux;
            }
            case COL_ID -> {
                return aux.getId();
            }
            case COL_NOME -> {
                return aux.getNome();
            }
            case COL_ENDERECO -> {
                return aux.getEndereco();
            }
            case COL_CNPJ -> {
                return aux.getCnpj();
            }
            case COL_PHONE -> {
                return aux.getTelefone();
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
            case COL_NOME -> {
                return "Nome";
            }
            case COL_ENDERECO -> {
                return "Endereço";
            }
            case COL_CNPJ -> {
                return "CNPJ";
            }
            case COL_PHONE -> {
                return "Phone";
            }
            default -> {
            }
        }

        return "";
    }
}
