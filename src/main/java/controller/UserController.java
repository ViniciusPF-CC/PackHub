/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTable;
import model.User;
import model.dao.UserDAO;
import model.exceptions.UserException;
import model.valid.ValidateUser;

/**
 *
 * @author vinic
 */
public class UserController {
    private UserDAO repositorio;
    
    public UserController(){
        repositorio = new UserDAO();  
    }
    
    public void cadastrarUser(String nome, String email, String cpf, String phone) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email, cpf, phone);
                
        if (repositorio.findByEmail(novoUser.getEmail()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'email'.");
        } else if(repositorio.findByCPF(novoUser.getCpf()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'cpf'.");
        }else{
            repositorio.save(novoUser);
        }
    }    
    
    public void atualizarUser(Long idUser, String nome, String email, String cpf, String phone) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email, cpf, phone);
        novoUser.setId(idUser);
        repositorio.update(novoUser);
    }    
}
