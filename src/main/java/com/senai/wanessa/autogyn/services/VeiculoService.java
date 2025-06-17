package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;
import com.senai.wanessa.autogyn.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoEntity salvarVeiculo(VeiculoEntity veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<VeiculoEntity> buscarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    public VeiculoEntity buscarPorId(int id) {
        Optional<VeiculoEntity> veiculo = veiculoRepository.findById(id);
        return veiculo.orElse(null);
    }

    public void deletarPorId(int id) {
        veiculoRepository.deleteById(id);
    }
}
