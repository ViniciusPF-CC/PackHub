/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;

/**
 *
 * @author Vinicius
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String cnpj;
    private String phone;
    private String typePositions;
    
    public User(){
        id= -1L;
        nome = "";
        email = "";
        cpf = "";
        cnpj = "";
        phone = "";
        typePositions = "user";
    }
    public User(Long id, String nome, String email, String cpf, String cnpj, String phone, String typePositions){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf =  cpf;
        this.cnpj = cnpj;
        this.phone = phone;
        this.typePositions = typePositions;
    }
    
    public void copy(User other){
        this.id = other.id;
        this.nome = other.nome;
        this.email = other.email;
        this.cpf = other.cpf;
        this.cnpj = other.cnpj;
        this.phone = other.phone;
        this.typePositions = other.typePositions;
    }
}
