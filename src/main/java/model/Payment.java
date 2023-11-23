/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.OneToOne;

/**
 *
 * @author Gabriel
 */
@Entity
@Data
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPagamento;
    @Column
    private LocalDateTime dataHora;
    private double valor;
    
    public Payment(){
        this.id = -1L;
        this.tipoPagamento = "";
        this.dataHora = LocalDateTime.of(2023, 1, 1, 0, 0);
        this.valor = 0.0;
    }
    
    public Payment(Long id, String tipoPagamento, LocalDateTime data, Double valor){
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.dataHora = data;
        this.valor = valor;
    }
    
    public void copy(Payment other){
        this.id = other.id;
        this.tipoPagamento = other.tipoPagamento;
        this.dataHora = other.dataHora;
        this.valor = other.valor;
    }
    
}
