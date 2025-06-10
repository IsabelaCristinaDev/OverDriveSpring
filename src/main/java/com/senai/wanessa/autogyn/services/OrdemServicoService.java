package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.EstoqueEntity;
import com.senai.wanessa.autogyn.entities.OrdemServicoEntity;
import com.senai.wanessa.autogyn.observers.events.EstoqueUsadoEvent;
import com.senai.wanessa.autogyn.repositories.EstoqueRepository;
import com.senai.wanessa.autogyn.repositories.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public OrdemServicoEntity criarOrdemServico(OrdemServicoEntity ordemServico) {
        if (ordemServico.getEstoqueId() > 0) {
            EstoqueEntity estoque = this.estoqueRepository.buscarPorId(ordemServico.getEstoqueId());
            if (estoque == null) {
                throw new IllegalArgumentException("Estoque não encontrado.");
            }

            if (estoque.getQuantidade() <= 0) {
                throw new IllegalArgumentException("Estoque insuficiente para criar a ordem de serviço.");
            }

            ordemServico.setValor(ordemServico.getValor() + estoque.getValor());
        }

        OrdemServicoEntity ordemServicoCriada = this.ordemServicoRepository.criarOrdemServico(ordemServico);

        if (ordemServicoCriada.getEstoqueId() > 0) {
            // Publica o evento de estoque usado após a criação da ordem de serviço
            this.eventPublisher.publishEvent(new EstoqueUsadoEvent(this, ordemServicoCriada.getEstoqueId(), 1));
        }

        return ordemServicoCriada;
    }

    public OrdemServicoEntity buscarOrdemServicoPorId(int id) {
        return this.ordemServicoRepository.buscarPorId(id);
    }

    public List<OrdemServicoEntity> buscarTodasOrdensServico() {
        return this.ordemServicoRepository.buscarTodos();
    }

}
