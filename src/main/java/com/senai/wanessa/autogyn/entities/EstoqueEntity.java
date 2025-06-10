package com.senai.wanessa.autogyn.entities;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EstoqueEntity {
    private int id;

    @NotBlank(message = "O nome do produto não pode ser vazio")
    private String nome;

    @DecimalMin(message = "O valor do produto deve ser maior ou igual a 0.01", value = "0.01")
    private double valor;

    @Min(message = "A quantidade do produto deve ser maior ou igual a 0", value = 1)
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
