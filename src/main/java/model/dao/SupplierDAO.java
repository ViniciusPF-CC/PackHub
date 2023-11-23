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
public class SupplierDAO implements IDao<Supplier>{
    private EntityManager entityManager;

    private Query qry;
    private String jpql;

    public SupplierDAO() {

    }

    /**
     *
     * @param obj
     */
    @Override
    public void save(Supplier obj) {
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
        this.entityManager.remove(id);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
        return true;
    }

   
    @Override
    public Supplier find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Supplier u = this.entityManager.find(Supplier.class, id);

        this.entityManager.close();

        return u;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Supplier> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT s "
                + " FROM Supplier s ";

        qry = this.entityManager.createQuery(jpql);

        List lst = qry.getResultList();

        this.entityManager.close();
        return (List<Supplier>) lst;
    }

    @Override
    public void update(Supplier obj) {
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
