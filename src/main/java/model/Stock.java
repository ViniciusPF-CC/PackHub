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
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author vinic
 */
@Entity
@Data
public class Stock implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codigo;
    private String descricao;
    private float precoCusto;
    private float precoVenda;
    private int quantEstoque;
    @ManyToOne
    private Supplier supplier;
    
    public Stock(){
        id = -1L;
        codigo = 0;
        descricao = "";
        precoCusto = 0;
        precoVenda = 0;
        quantEstoque = 0;
        supplier = new Supplier();
    }
    public Stock(Long id, Integer codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, Supplier supplier){
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantEstoque = quantEstoque;
        this.supplier = supplier;
    }
    
    public void copy(Stock other){
        this.id = other.id;
        this.codigo = other.codigo;
        this.descricao = other.descricao;
        this.precoCusto = other.precoCusto;
        this.precoVenda = other.precoVenda;
        this.quantEstoque = other.quantEstoque;
        this.supplier = other.supplier;
        
    }
}
