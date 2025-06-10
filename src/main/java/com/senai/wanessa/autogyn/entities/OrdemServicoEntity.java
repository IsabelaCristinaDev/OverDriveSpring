package com.senai.wanessa.autogyn.entities;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdemServicoEntity {
    private int id;

    @NotNull(message = "O ID do cliente não pode ser nulo")
    private int clienteId;

    @NotNull(message = "O ID do veículo não pode ser nulo")
    private int veiculoId;

    private int estoqueId;

    @NotBlank(message = "A descrição do serviço não pode ser vazia")
    private String descricao;

    @NotNull(message = "O valor do serviço não pode ser nulo")
    @DecimalMin(message = "O valor do serviço deve ser maior ou igual a 0.01", value = "0.01")
    private double valor;

    public int getId() {
        return id;
    }

    public int getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(int estoqueId) {
        this.estoqueId = estoqueId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
