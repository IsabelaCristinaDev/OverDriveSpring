package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;
import com.senai.wanessa.autogyn.factory.VeiculoFactory;
import com.senai.wanessa.autogyn.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoEntity salvarVeiculo(String placa, String modelo) {
        VeiculoEntity veiculo = VeiculoFactory.criarVeiculo(placa, modelo);
        return this.veiculoRepository.salvar(veiculo.getPlaca(), veiculo.getModelo());
    }

    public VeiculoEntity buscarVeiculoPorId(int id) {
        return this.veiculoRepository.buscarPorId(id);
    }

    public List<VeiculoEntity> buscarTodosVeiculos() {
        return this.veiculoRepository.buscarTodos();
    }

    public void deletarVeiculoPorId(int id) {
        this.veiculoRepository.deletarPorId(id);
    }
}
