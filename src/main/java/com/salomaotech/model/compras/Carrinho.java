package com.salomaotech.model.compras;

import com.salomaotech.model.abstratas.Modelo;
import com.salomaotech.model.cliente.Cliente;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrinho extends Modelo implements Serializable {

    @OneToMany
    private Set<Produto> produtos = new HashSet();

    @OneToOne
    private Cliente cliente;

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
