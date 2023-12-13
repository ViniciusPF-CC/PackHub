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

    public User validaCamposEntrada(String nome, String email, String senha, String cpf, String phone) {
        User user = new User();
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty() || phone.isEmpty()) {
            throw new UserException("Erro - Preencha todos os campos.");
        }

        if (!EmailValid.isEmailValid(email)) {
            throw new UserException("O email não é válido.");
        }

        if (!ValidateCPF.validaCPF(cpf)) {
            throw new UserException("CPF inválido");
        }
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        user.setCpf(cpf);
        user.setPhone(phone);

        return user;
    }

    public User validaCamposEntradaAdmin(String nome, String email, String senha, String cpf, String phone, String typePositions) {
        User user = new User();
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty() || phone.isEmpty() || typePositions.isEmpty()) {
            throw new UserException("Erro - Preencha todos os campos.");
        }

        if (!EmailValid.isEmailValid(email)) {
            throw new UserException("O email não é válido.");
        }

        if (!ValidateCPF.validaCPF(cpf)) {
            throw new UserException("CPF inválido");
        }
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        user.setCpf(cpf);
        user.setPhone(phone);
        user.setTypePositions(typePositions);

        JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        return user;
    }
}
