/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import java.util.List;
import javax.swing.JOptionPane;
import model.Supplier;
import model.exceptions.SupplierException;

/**
 *
 * @author Gabriel
 */
public class ValidateSupplier {
    public Supplier validaCamposEntrada(String endereco, String telefone, String cnpj) {
        if (endereco == null || telefone.isEmpty() || cnpj.isEmpty()) {
            throw new SupplierException("Erro - Preencha todos os campos corretamente.");
        }

        Supplier supplier = new Supplier();
        supplier.setEndereco(endereco);
        supplier.setTelefone(telefone);
        supplier.setCnpj(cnpj);

        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        return supplier;
    
    }
}    
