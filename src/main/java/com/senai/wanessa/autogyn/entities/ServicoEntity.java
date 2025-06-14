package com.senai.wanessa.autogyn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name = "preco_unitario")
    private double precoUnitario;
    private String quemFez;
    private String status;
    public ServicoEntity() {
    }

    public ServicoEntity(Integer id, String nome, double precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getQuemFez() {
        return quemFez;
    }

    public void setQuemFez(String quemFez) {
        this.quemFez = quemFez;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}