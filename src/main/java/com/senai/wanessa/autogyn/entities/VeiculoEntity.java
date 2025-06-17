package com.senai.wanessa.autogyn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private String placa;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false, length = 50)
    private String marca;

    public VeiculoEntity() {}

    public VeiculoEntity(Integer id, String placa, String modelo, String marca) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
