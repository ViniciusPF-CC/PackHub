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

/**
 *
 * @author Gabriel
 */
public class UserDAO implements IDao {
    private EntityManager entityManager;
    
    private Query qry;
    private String jpql;
    
    public UserDAO(){
        
    }
    
    @Override
    public void save(Object obj){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        this.entityManager.getTransaction().begin();       
        this.entityManager.persist(obj);                    
        this.entityManager.getTransaction().commit();        
        
        this.entityManager.close();
    }
    
    
    public void update(Object obj) {
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
        this.entityManager.remove(id);
        this.entityManager.getTransaction().commit();
        
        this.entityManager.close();
        return true;
    }      
    
    @Override
    public Object find(Object obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        User user = (User) obj;
        
        User u = this.entityManager.find(User.class, user.getId());
        
        this.entityManager.close();
        
        return u;
    }
    
    public List<Object> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        jpql = " SELECT u "
             + " FROM User u ";

        qry = this.entityManager.createQuery(jpql);
        
        List lst = qry.getResultList();
        
        this.entityManager.close();
        return (List<Object>) lst;
                
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
}
