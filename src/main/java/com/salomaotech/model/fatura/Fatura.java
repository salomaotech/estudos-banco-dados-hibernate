package com.salomaotech.model.fatura;

import com.salomaotech.model.abstratas.Modelo;
import com.salomaotech.model.cliente.Cliente;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Fatura extends Modelo implements Serializable {

    @OneToOne
    private Cliente cliente;

    private BigDecimal valor;
    private LocalDate dataVencimento;
    private boolean isPago;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isIsPago() {
        return isPago;
    }

    public void setIsPago(boolean isPago) {
        this.isPago = isPago;
    }

}
