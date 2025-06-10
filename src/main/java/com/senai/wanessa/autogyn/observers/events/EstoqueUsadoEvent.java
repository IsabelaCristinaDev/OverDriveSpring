package com.senai.wanessa.autogyn.observers.events;

import org.springframework.context.ApplicationEvent;

public class EstoqueUsadoEvent extends ApplicationEvent {

    private final int estoqueId;
    private final int quantidadeUsada;

    public EstoqueUsadoEvent(Object source, int estoqueId, int quantidadeUsada) {
        super(source);
        this.estoqueId = estoqueId;
        this.quantidadeUsada = quantidadeUsada;
    }

    public int getEstoqueId() {
        return estoqueId;
    }

    public int getQuantidadeUsada() {
        return quantidadeUsada;
    }

}
