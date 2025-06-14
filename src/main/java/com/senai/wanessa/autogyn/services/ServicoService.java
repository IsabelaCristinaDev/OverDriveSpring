package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.ServicoEntity;
import com.senai.wanessa.autogyn.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<ServicoEntity> listarTodos() {
        return servicoRepository.findAll();
    }

    public ServicoEntity buscarPorId(Integer id) {
        Optional<ServicoEntity> servico = servicoRepository.findById(id);
        return servico.orElse(null);
    }

    public ServicoEntity salvar(ServicoEntity servico) {
        return servicoRepository.save(servico);
    }

    public ServicoEntity atualizar(Integer id, ServicoEntity novoServico) {
        ServicoEntity servicoExistente = buscarPorId(id);
        if (servicoExistente != null) {
            servicoExistente.setNome(novoServico.getNome());
            servicoExistente.setPrecoUnitario(novoServico.getPrecoUnitario());
            servicoExistente.setQuemFez(novoServico.getQuemFez());
            servicoExistente.setStatus(novoServico.getStatus());
            return servicoRepository.save(servicoExistente);
        }
        return null;
    }

    public void deletar(Integer id) {
        servicoRepository.deleteById(id);
    }
}
