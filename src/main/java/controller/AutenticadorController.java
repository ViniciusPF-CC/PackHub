/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Employee;
import model.auth.Autenticador;
import model.dao.EmployeeDAO;
import model.dao.ManagerDAO;

/**
 *
 * @author gusta
 */
public class AutenticadorController {

    private EmployeeDAO repEmployee;
    private ManagerDAO repManager;

    public AutenticadorController() {
        repEmployee = new EmployeeDAO();
        repManager = new ManagerDAO();
    }

    public char autenticarPorEmailSenha(String email, String senha) {
        Long idEmployee = repEmployee.getEmployeeByEmailAndSenha(email, senha);
        if (!(idEmployee == 0)) {
            Autenticador.setIdLogado(idEmployee);
            return 'e';
        }

        Long idManager = repManager.getManagerByEmailAndSenha(email, senha);
        if (!(idManager == 0)) {
            Autenticador.setIdLogado(idManager);
            return 'm';
        }
        return 'n';
    }

}
