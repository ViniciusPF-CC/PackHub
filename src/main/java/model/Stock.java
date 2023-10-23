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
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codigo;
    private String descricao;
    private float precoCusto;
    private float precoVenda;
    private int quantEstoque;
    private String fornecedor;
    
    public Stock(){
        id= -1;
        codigo = 0;
        descricao = "";
        precoCusto = 0;
        precoVenda = 0;
        quantEstoque = 0;
        fornecedor = "";
    }
    public Stock(Integer id, Integer codigo, String descricao, float precoCusto, float precoVenda, Integer quantEstoque, String fornecedor){
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantEstoque = quantEstoque;
        this.fornecedor = fornecedor;
    }
    
    public void copy(Stock other){
        this.id = other.id;
        this.codigo = other.codigo;
        this.descricao = other.descricao;
        this.precoCusto = other.precoCusto;
        this.precoVenda = other.precoVenda;
        this.quantEstoque = other.quantEstoque;
        this.fornecedor = other.fornecedor;
    }
}
