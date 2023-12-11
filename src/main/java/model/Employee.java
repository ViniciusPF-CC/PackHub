/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Gabriel
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends User implements Serializable{
    public Employee(){
        super();
        this.setTypePositions("employee");
    }
    
    public Employee(Long id, String nome, String email, String cpf, String cnpj, String phone, String typePositions){
        super();
    }
    
    @Override
     public void copy(User other){
        this.setId(other.getId());
        this.setNome(other.getNome());
        this.setEmail(other.getEmail());
        this.setCpf(other.getCpf());
        this.setCnpj(other.getCnpj());
        this.setPhone(other.getPhone());
        this.setTypePositions(other.getTypePositions());
    }
}
