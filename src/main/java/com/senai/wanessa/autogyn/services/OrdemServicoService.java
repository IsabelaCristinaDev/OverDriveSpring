package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.OrdemServicoEntity;
import com.senai.wanessa.autogyn.repositories.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository repository;

    public List<OrdemServicoEntity> listarTodos() {
        return repository.findAll();
    }

    public OrdemServicoEntity buscarPorId(Integer id) {
        Optional<OrdemServicoEntity> ordem = repository.findById(id);
        return ordem.orElse(null);
    }

    public OrdemServicoEntity salvar(OrdemServicoEntity ordem) {
        return repository.save(ordem);
    }

    public OrdemServicoEntity atualizar(Integer id, OrdemServicoEntity novaOrdem) {
        OrdemServicoEntity existente = buscarPorId(id);
        if (existente != null) {
            existente.setCliente(novaOrdem.getCliente());
            existente.setVeiculo(novaOrdem.getVeiculo());
            existente.setPeca(novaOrdem.getPeca());
            existente.setServico(novaOrdem.getServico());
            existente.setDescricao(novaOrdem.getDescricao());
            existente.setValor(novaOrdem.getValor());
            return repository.save(existente);
        }
        return null;
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
