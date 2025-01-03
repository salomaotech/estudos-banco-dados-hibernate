package com.salomaotech.model.cliente;

import com.salomaotech.model.abstratas.Modelo;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Cliente extends Modelo implements Serializable {

    private String nome;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
