package com.senai.wanessa.autogyn.observers.listeners;

import com.senai.wanessa.autogyn.entities.EstoqueEntity;
import com.senai.wanessa.autogyn.observers.events.EstoqueUsadoEvent;
import com.senai.wanessa.autogyn.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueListener {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @EventListener
    public void onEstoqueUsadoEvent(EstoqueUsadoEvent event) {
        int estoqueId = event.getEstoqueId();
        int quantidadeUsada = event.getQuantidadeUsada();

        EstoqueEntity estoque = this.estoqueRepository.buscarPorId(estoqueId);

        if (estoque != null) {
            int quantidadeAtual = estoque.getQuantidade();
            if (quantidadeAtual >= quantidadeUsada) {
                estoque.setQuantidade(quantidadeAtual - quantidadeUsada);
                this.estoqueRepository.atualizarQuantidade(estoque.getId(), estoque.getQuantidade());
            } else {
                throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
            }
        } else {
            throw new IllegalArgumentException("Estoque não encontrado.");
        }
    }

}
