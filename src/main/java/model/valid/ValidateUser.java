/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.valid;

import javax.swing.JOptionPane;
import model.User;
import model.exceptions.UserException;

/**
 *
 * @author Gabriel
 */
public class ValidateUser {
    public User validaCamposEntrada(String nome, String email, String cpf, String phone){
        User user = new User();
        if (nome.isEmpty() || email.isEmpty() || cpf.isEmpty() || phone.isEmpty()) {
            throw new UserException("Erro - Preencha todos os campos.");
        }
        
        if(!EmailValid.isEmailValid(email)){
            throw new UserException("O email não é válido.");
        }
        
        if(!ValidateCPF.validaCPF(cpf)){
            throw new UserException("CPF inválido");
        }
        
        user.setNome(nome);
        user.setEmail(email);
        user.setCpf(cpf);
        user.setPhone(phone);
        
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        return user;
    }
}
