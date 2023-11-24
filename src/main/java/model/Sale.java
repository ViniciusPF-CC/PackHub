/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Gabriel
 */
@Entity
@Data
public class Sale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime dataHora;
    @OneToMany(mappedBy = "supplier")
    private List<Stock> produtos;
    @Column
    private double valor;
    @ManyToOne
    private Payment pagamento;
    
    public void Sale(){
        this.id = -1L;
        this.dataHora = LocalDateTime.of(2023, 1, 1, 0, 0);
        this.produtos = new ArrayList<>();
        this.valor = 0.0;
        this.pagamento = new Payment();
    }
    
    public void Sale(Long id, LocalDateTime data, List produtos, Double valor, Payment pagamento){
        this.id = id;
        this.dataHora = data;
        this.produtos = produtos;
        this.valor = valor;
        this.pagamento = pagamento;
    }
    
    public void copy(Sale other){
        this.id = other.id;
        this.dataHora = other.dataHora;
        this.produtos = other.produtos;
        this.valor = other.valor;
        this.pagamento = other.pagamento;
    }
}
