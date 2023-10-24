/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Supplier;
import model.dao.SupplierDAO;
import model.exceptions.SupplierException;
import model.valid.ValidateSupplier;

/**
 *
 * @author Gabriel
 */
public class SupplierController {
    private SupplierDAO respositorio;
    
    public SupplierController(){
        respositorio = new SupplierDAO();
    }
    
    public void cadastrarSupplier(String endereco, String telefone, String cnpj, List produtosFornecidos) {
        ValidateSupplier valid = new ValidateSupplier();
        Supplier supplier = valid.validaCamposEntrada(endereco, telefone, cnpj, produtosFornecidos);
        
        if(respositorio.findByCnpj(supplier.getCnpj()) != null) {
            throw new SupplierException("Error - Já existe um produto com esse código");
        } else {
            respositorio.save(supplier);
        }
    }
}
