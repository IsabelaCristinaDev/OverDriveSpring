package com.senai.wanessa.autogyn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class PecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer quantidade;

    public PecaEntity() {}

    public PecaEntity(Integer id, String nome, Double valor, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}