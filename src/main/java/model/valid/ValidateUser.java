/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import model.User;

/**
 *
 * @author Gabriel
 */
public class ValidateUser {
    public User validaCamposEntrada(String nome, String email){
        User user = new User();
        if (nome.isEmpty())
            throw new UserException("Error - Campo vazio: 'nome'.");
        user.setNome(nome);
        
        if (email.isEmpty()) 
            throw new UserException("Error - Campo vazio: 'email'.");                
        user.setEmail(email);

        return user;
    }
}
