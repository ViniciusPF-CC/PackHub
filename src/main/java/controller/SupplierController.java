/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.table.TMStock;
import controller.table.TMSupplier;
import java.util.List;
import javax.swing.JTable;
import model.Supplier;
import model.dao.SupplierDAO;
import model.exceptions.SupplierException;
import model.valid.ValidateSupplier;

/**
 *
 * @author Gabriel
 */
public class SupplierController {
    private SupplierDAO repositorio;
    
    public SupplierController(){
        repositorio = new SupplierDAO();
    }
    
    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMSupplier tableModel = new TMSupplier(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }
    
    
    public void cadastrarSupplier(String nome, String endereco, String telefone, String cnpj) {
        ValidateSupplier valid = new ValidateSupplier();
        Supplier supplier = valid.validaCamposEntrada(endereco, telefone, cnpj);
        
        if(repositorio.findByCnpj(supplier.getCnpj()) != null) {
            throw new SupplierException("Error - Já existe um produto com esse código");
        } else {
            repositorio.save(supplier);
        }
    }
    
        public String buscarSupplierString() {
            
        List<Supplier> suppliers = repositorio.findAll();
        
        String supplierString = "";
        for (Supplier supplier : suppliers) {
            supplierString += supplier.getId()+" - "+supplier.getNome()+"\n";
        }

        return supplierString;
    }
        
        public Supplier buscarSupplierPorId(Long id){
        if(id == null){
            return null;
        }
            Supplier supp = (Supplier) repositorio.find(id);
        return supp;
    }
        
    public void excluirSupplier(Long id) {
        if (id != -1) {
            repositorio.delete(id);
        } else {
            throw new SupplierException("Error - Item inexistente.");
        }
    }
}
