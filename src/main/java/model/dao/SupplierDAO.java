/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Supplier;


/**
 *
 * @author Gabriel
 */
public class SupplierDAO implements IDao{
    private EntityManager entityManager;

    private Query qry;
    private String jpql;

    public SupplierDAO() {

    }

    @Override
    public void save(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean delete(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.remove(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

    @Override
    public Object find(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Supplier stock = (Supplier) obj;

        Supplier u = this.entityManager.find(Supplier.class, stock.getId());

        this.entityManager.close();

        return u;
    }

    @Override
    public List<Object> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT s "
                + " FROM Supplier s ";

        qry = this.entityManager.createQuery(jpql);

        List lst = qry.getResultList();

        this.entityManager.close();
        return (List<Object>) lst;
    }

    public void update(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    public Supplier findByCnpj(String cnpj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = "SELECT s FROM Supplier s WHERE s.cnpj = :cnpj";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("cnpj", cnpj);

        List<Supplier> resultList = qry.getResultList();

        this.entityManager.close();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }
}
