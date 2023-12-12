/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Sale;
import model.Stock;

/**
 *
 * @author Gabriel
 */
public class SaleDAO implements IDao<Sale>{
    private EntityManager entityManager;
    private Query qry;
    private String jpql;
    
    public SaleDAO(){
        
    }
    
    @Override
    public void save(Sale obj) {
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

        Sale saleJPA = this.entityManager.find(Sale.class, id);
        if (saleJPA != null) {
            this.entityManager.remove(saleJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - Stock inexistente.");
        }
        
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }
    
    @Override
    public Sale find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Sale s = this.entityManager.find(Sale.class, id);

        this.entityManager.close();

        return s;
    }
    
    
    @Override
    public List<Sale> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT s "
                + " FROM Sale s ";

        qry = this.entityManager.createQuery(jpql);

        List lst = qry.getResultList();

        this.entityManager.close();
        return (List<Sale>) lst;
    }
    
    
    @Override
    public void update(Sale obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }
    
    
    public Stock findById(String id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = "SELECT s FROM Sale s WHERE s.id = :id";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("id", id);

        List<Stock> resultList = qry.getResultList();

        this.entityManager.close();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }
}
