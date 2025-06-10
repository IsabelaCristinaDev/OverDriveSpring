package com.senai.wanessa.autogyn.entities;

import jakarta.validation.constraints.NotNull;

public class ClienteEntity {
    private int id;

    @NotNull(message = "O nome do cliente não pode ser nulo")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
