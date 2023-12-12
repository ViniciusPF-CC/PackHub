/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Employee;
import static org.hibernate.criterion.Expression.sql;

public class EmployeeDAO {

    private EntityManager entityManager;
    private Query qry;
    private String sql;

    public Long getEmployeeByEmailAndSenha(String email, String senha) {
        sql = " SELECT e "
                + " FROM Employee e "
                + " WHERE email = :email"
                + " AND senha = :senha ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("email", email);
        qry.setParameter("senha", senha);

        List<Employee> lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0).getId();
        }
    }
}
