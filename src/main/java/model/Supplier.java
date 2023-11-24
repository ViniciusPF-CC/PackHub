/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author Gabriel
 */
@Entity
@Data
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private String telefone;
    private String cnpj;
    
    public Supplier(){
        this.id = -1L;
        this.endereco = "";
        this.telefone = "";
        this.cnpj = "";
    }
    
    public Supplier(Long id, String endereco, String telefone, String cnpj){
        this.id = id;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }
    
    public void copy(Supplier other){
        this.id = other.id;
        this.endereco = other.endereco;
        this.telefone = other.telefone;
        this.cnpj = other.cnpj;
    }
}
