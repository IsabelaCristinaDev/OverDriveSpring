package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.EstoqueEntity;
import com.senai.wanessa.autogyn.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public EstoqueEntity criarEstoque(EstoqueEntity estoque) {
        return this.estoqueRepository.criarEstoque(estoque);
    }

    public List<EstoqueEntity> buscarTodosEstoque() {
        return this.estoqueRepository.buscarTodos();
    }

    public EstoqueEntity buscarEstoquePorId(int id) {
        return this.estoqueRepository.buscarPorId(id);
    }

}
