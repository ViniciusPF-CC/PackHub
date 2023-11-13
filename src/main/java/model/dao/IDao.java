/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface IDao {
    
    public void save(Object obj);
    
    public boolean delete(Long id);
            
    public Object find(Object obj);
        
    public List<Object> findAll();
    
}
