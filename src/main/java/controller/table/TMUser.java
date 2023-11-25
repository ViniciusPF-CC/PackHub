package controller.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.User;

/**
 *
 * @author vinic
 */
public class TMUser extends AbstractTableModel {

    private List<User> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_EMAIL = 2;
    private final int COL_CPF = 3;
    private final int COL_CNPJ = 4;
    private final int COL_PHONE = 5;
    private final int COL_TYPEPOSITIONS = 6;

    public TMUser(List<User> lstUser) {
        this.lista = lstUser;
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
        User aux = (lista.isEmpty()) ? new User() : lista.get(rowIndex);

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
            case COL_EMAIL -> {
                return aux.getEmail();
            }
            case COL_CPF -> {
                return aux.getCpf();
            }
            case COL_CNPJ -> {
                return aux.getCnpj();
            }
            case COL_PHONE -> {
                return aux.getPhone();
            }
            case COL_TYPEPOSITIONS -> {
                return aux.getTypePositions();
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
            case COL_EMAIL -> {
                return "Email";
            }
            case COL_CPF -> {
                return "CPF";
            }
            case COL_CNPJ -> {
                return "CNPJ";
            }
            case COL_PHONE -> {
                return "Phone";
            }
            case COL_TYPEPOSITIONS -> {
                return "Typepositions";
            }
            default -> {
            }
        }

        return "";
    }
}
