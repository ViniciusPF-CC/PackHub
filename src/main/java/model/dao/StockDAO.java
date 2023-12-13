/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.DatabaseJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Stock;

/**
 *
 * @author vinic
 */
public class StockDAO implements IDao<Stock> {

    private EntityManager entityManager;

    private Query qry;
    private String jpql;

    public StockDAO() {

    }

    @Override
    public void save(Stock obj) {
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

        Stock stockJPA = this.entityManager.find(Stock.class, id);
        if (stockJPA != null) {
            this.entityManager.remove(stockJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException("Error - Stock inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;

    }

    @Override
    public Stock find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Stock u = this.entityManager.find(Stock.class, id);

        this.entityManager.close();

        return u;
    }

    @Override
    public List<Stock> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT s "
                + " FROM Stock s ";

        qry = this.entityManager.createQuery(jpql);

        List lst = qry.getResultList();

        this.entityManager.close();
        return (List<Stock>) lst;
    }

    @Override
    public void update(Stock obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    public Stock findByCodigo(String codigo) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = "SELECT s FROM Stock s WHERE s.codigo = :codigo";
        qry = this.entityManager.createQuery(jpql);
        qry.setParameter("codigo", codigo);

        List<Stock> resultList = qry.getResultList();

        this.entityManager.close();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public float findPrecoByNome(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        jpql = "SELECT s.precoVenda FROM Stock s WHERE s.descricao = :nome";
        TypedQuery<Float> qry = entityManager.createQuery(jpql, Float.class);
        qry.setParameter("nome", nome);

        try {
            return qry.getSingleResult();
        } catch (NoResultException e) {
            return 0.0f;
        } finally {
            entityManager.close();
        }
    }

}
