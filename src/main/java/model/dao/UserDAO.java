/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.User;
import static org.hibernate.criterion.Expression.sql;

/**
 *
 * @author Gabriel
 */
public class UserDAO implements IDao<User> {

    private EntityManager entityManager;

    private Query qry;
    private String jpql;

    public UserDAO() {

    }

    @Override
    public void save(User obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    public void update(User obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        User UserJPA = this.entityManager.find(User.class, id);
        if (UserJPA != null) {
            this.entityManager.remove(UserJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - User inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public User find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        User u = this.entityManager.find(User.class, id);

        this.entityManager.close();

        return u;
    }

    @Override
    public List<User> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM User u ";

        qry = this.entityManager.createQuery(jpql);

        List lst = qry.getResultList();

        this.entityManager.close();
        return (List<User>) lst;

    }

    public User findByEmail(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM User u "
                + " WHERE u.email like :email ";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("email", email);

        List lst = qry.getResultList();

        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (User) lst.get(0);
        }
    }

    public User findByCPF(String Cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM User u "
                + " WHERE u.cpf like :cpf ";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("cpf", Cpf);

        List lst = qry.getResultList();

        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (User) lst.get(0);
        }
    }

    public Long getUserEmailAndSenha(String email, String senha) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM User u "
                + " WHERE email = :email"
                + " AND senha = :senha ";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("email", email);
        qry.setParameter("senha", senha);
        
        

        List<User> lst = qry.getResultList();
        System.out.println(jpql);

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0).getId();
        }
    }

    public String getUserTypePosition(String email) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = "SELECT u "
                + "FROM User u "
                + "WHERE email = :email";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("email", email);

        List<User> resultList = qry.getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0).getTypePositions();
        }
    }
}
