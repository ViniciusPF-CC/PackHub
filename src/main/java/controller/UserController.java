/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.table.TMUser;
import java.util.List;
import javax.swing.JOptionPane;
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

    public UserController() {
        repositorio = new UserDAO();
    }

    public void cadastrarUser(String nome, String email, String cpf, String phone) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email, cpf, phone);

        if (repositorio.findByEmail(novoUser.getEmail()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'email'.");
        } else if (repositorio.findByCPF(novoUser.getCpf()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'cpf'.");
        } else {
            repositorio.save(novoUser);
        }
    }

    public void atualizarUser(Long idUser, String nome, String email, String cpf, String phone) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email, cpf, phone);
        novoUser.setId(idUser);
        repositorio.update(novoUser);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMUser tableModel = new TMUser(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }

    public void atualizarUserAdmin(Long idUser, String nome, String email, String documento, String phone, String typeUser) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntradaAdmin(nome, email, documento, phone, typeUser);
        novoUser.setId(idUser);
        repositorio.update(novoUser);
    }

    public void cadastrarUserAdmin(String nome, String email, String documento, String phone, String typeUser) {
        ValidateUser valid = new ValidateUser();
        User novoUser = valid.validaCamposEntrada(nome, email, documento, phone);

        if (repositorio.findByEmail(novoUser.getEmail()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'email'.");
        } else if (repositorio.findByCPF(novoUser.getCpf()) != null) {
            throw new UserException("Error - Já existe um usuario com este 'cpf'.");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            repositorio.save(novoUser);
        }
    }

    public void excluirUser(Long id) {
        if (id != -1) {
            repositorio.delete(id);
        } else {
            throw new UserException("Error - Item inexistente.");
        }
    }
}
