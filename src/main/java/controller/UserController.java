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
    
    public void cadastrarUser(String nome, String email) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email);
                
        if (repositorio.findByEmail(novoUser.getEmail()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'email'.");
        } else {
            repositorio.save(novoUser);
        }
    }    
    
    public void atualizarUser(int idUser, String nome, String email) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email);
        novoUser.setId(idUser);
        repositorio.update(novoUser);
    }    

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMCadUser(repositorio.findAll()), null);
    }

    public void excluirUser(User funcionario) {
        //Encontrar professor e exlcui                   
        
        if (funcionario != null) {
            repositorio.delete(funcionario);
        } else {
            throw new UserException("Error - Usuario inexistente.");
        }
    }
}
