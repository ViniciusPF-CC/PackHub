/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Vinicius
 */
@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String phone;
    private String typePositions;
    
    public User(){
        id= -1;
        nome = "";
        email = "";
        cpf = "";
        phone = "";
        typePositions = "user";
    }
    public User(Integer id, String nome, String email, String cpf, String phone, String typePositions){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf =  cpf;
        this.phone = phone;
        this.typePositions = typePositions;
    }
    
}
