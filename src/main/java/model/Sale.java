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
import javax.persistence.JoinColumn;
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
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock produto;
    @Column
    private double valor;
    private String pagamento;
    private int quantidadeVendida;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User vendedor;

    public void Sale() {
        this.id = -1L;
        this.dataHora = LocalDateTime.of(2023, 1, 1, 0, 0);
        produto = new Stock();
        this.valor = 0.0;
        this.pagamento = "";
        this.quantidadeVendida = 0;
        vendedor = new User();
    }

    public void Sale(Long id, LocalDateTime data, Stock produto, Double valor, String pagamento, int quantidadeVendida, User vendedor) {
        this.id = id;
        this.dataHora = data;
        this.produto = produto;
        this.valor = valor;
        this.pagamento = pagamento;
        this.quantidadeVendida = quantidadeVendida;
        this.vendedor = vendedor;
    }

    public void copy(Sale other) {
        this.id = other.id;
        this.dataHora = other.dataHora;
        this.produto = other.produto;
        this.valor = other.valor;
        this.pagamento = other.pagamento;
        this.quantidadeVendida = other.quantidadeVendida;
        this.vendedor = other.vendedor;
    }
}
