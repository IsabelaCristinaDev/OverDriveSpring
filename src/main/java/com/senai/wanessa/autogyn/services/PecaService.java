package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.PecaEntity;
import com.senai.wanessa.autogyn.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    public PecaEntity criarEstoque(PecaEntity peca) {
        return pecaRepository.save(peca);
    }


    public void atualizar(PecaEntity pecas) {
       pecaRepository.save(pecas);
    }

    public PecaEntity buscarPorId(int id) {
        return pecaRepository.findById(id).orElse(null);
    }

    public List<PecaEntity> buscarTodos() {
        return pecaRepository.findAll();
    }

    public void deletarPorId(int id) {
        pecaRepository.deleteById(id);
    }
}
