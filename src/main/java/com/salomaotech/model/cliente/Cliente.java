package com.salomaotech.model.cliente;

import com.salomaotech.model.abstratas.Modelo;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Transient;

@Entity
public class Cliente extends Modelo implements Serializable {

    private String nome;
    private String telefone;
    private String email;

    private LocalDate dataNascimento;

    @Transient
    private long idade;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calcularIdade() {

        idade = ChronoUnit.YEARS.between(this.dataNascimento, LocalDate.now());

        System.out.println("Calculando idade = " + idade);

    }

}
