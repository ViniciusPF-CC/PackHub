/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import model.User;
import model.exceptions.UserException;

/**
 *
 * @author Gabriel
 */
public class ValidateUser {
    public User validaCamposEntrada(String nome, String email, String cpf, String phone){
        User user = new User();
        if (nome.isEmpty())
            throw new UserException("Error - Campo vazio: 'nome'.");
        user.setNome(nome);
        
        if (email.isEmpty()) 
            throw new UserException("Error - Campo vazio: 'email'.");                
        user.setEmail(email);
        
        if (cpf.isEmpty())
            throw new UserException("Error - Campo vazio: 'cpf'.");                
        user.setCpf(cpf);
        
        if(phone.isEmpty())
            throw new UserException("Error - Campo vazio: 'telefone'.");                
        user.setPhone(phone);

        return user;
    }
}
