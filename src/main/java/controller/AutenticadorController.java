/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import factory.DatabaseJPA;
import java.awt.datatransfer.SystemFlavorMap;
import javax.persistence.EntityManager;
import model.auth.Autenticador;
import model.dao.UserDAO;

public class AutenticadorController {

    private UserDAO repUser;
    private EntityManager entityManager;

    public AutenticadorController() {
        repUser = new UserDAO();
        entityManager = DatabaseJPA.getInstance().getEntityManager();
    }

    public char autenticarPorEmailSenha(String email, String senha) {

        Long idUser = repUser.getUserEmailAndSenha(email, senha);
        String typePositions = repUser.getUserTypePosition(email);
//        System.out.println("type:" + typePositions);

        if (idUser != null && "Admin".equals(typePositions)) {

            Autenticador.setIdLogado(idUser);
            return 'a';
        }

        if (idUser != null && "Funcionario".equals(typePositions)) {

            Autenticador.setIdLogado(idUser);
            return 'f';
        }

        if (idUser != null && "user".equals(typePositions)) {

            Autenticador.setIdLogado(idUser);
            return 'u';
        }

        return 'n';
    }

}
