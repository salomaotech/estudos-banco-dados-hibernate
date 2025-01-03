package com.salomaotech.model.compras;

import com.salomaotech.model.abstratas.Modelo;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity
public class Produto extends Modelo implements Serializable {

    private String nome;
    private BigDecimal preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
