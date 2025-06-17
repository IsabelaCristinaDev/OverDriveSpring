package com.senai.wanessa.autogyn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String nome;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "celular", nullable = false, length = 20)
    private String celular;

    @Column(name = "cpf",  unique = true)
    private String cpf;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    public ClienteEntity() {}

    public ClienteEntity(int id, String nome, String lastName, String email, String celular, String cpf, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.lastName = lastName;
        this.email = email;
        this.celular = celular;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }



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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
