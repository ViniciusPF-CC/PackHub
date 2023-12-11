/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Bills;

/**
 *
 * @author vinic
 */
public class BillsDAO implements IDao<Bills> {

    private EntityManager entityManager;

    private Query qry;
    private String jpql;


    @Override
    public void save(Bills obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Bills billsJPA = this.entityManager.find(Bills.class, id);
        if (billsJPA != null) {
            this.entityManager.remove(billsJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - Conta inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;

    }

    @Override
    public Bills find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Bills b = this.entityManager.find(Bills.class, id);

        this.entityManager.close();

        return b;
    }

    @Override
    public List<Bills> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT b "
                + " FROM Bills b ";

        qry = this.entityManager.createQuery(jpql);

        List lst = qry.getResultList();

        this.entityManager.close();
        return (List<Bills>) lst;
    }

    @Override
    public void update(Bills obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    public Bills findById(String id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = "SELECT b FROM Bills b WHERE b.id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);

        List<Bills> resultList = qry.getResultList();

        this.entityManager.close();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

}
