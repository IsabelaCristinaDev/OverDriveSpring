package com.senai.wanessa.autogyn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ordem_servico")
public class OrdemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id") 
    private ClienteEntity cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "veiculo_id") 
    private VeiculoEntity veiculo;

    @ManyToOne
    @JoinColumn(name = "peca_id") 
    private PecaEntity peca;

    @ManyToOne
    @JoinColumn(name = "servico_id") 
    private ServicoEntity servico;

    @NotBlank(message = "A descrição do serviço não pode ser vazia")
    private String descricao;

    @NotNull(message = "O valor do serviço não pode ser nulo")
    @DecimalMin(value = "0.01", message = "O valor do serviço deve ser maior ou igual a 0.01")
    private double valor;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public VeiculoEntity getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoEntity veiculo) {
        this.veiculo = veiculo;
    }

    public PecaEntity getPeca() {
        return peca;
    }

    public void setPeca(PecaEntity peca) {
        this.peca = peca;
    }

    public ServicoEntity getServico() {
        return servico;
    }

    public void setServico(ServicoEntity servico) {
        this.servico = servico;
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
