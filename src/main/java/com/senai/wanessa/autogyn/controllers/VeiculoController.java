package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;
import com.senai.wanessa.autogyn.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/")
    public VeiculoEntity criarVeiculo(@Valid @RequestBody VeiculoEntity veiculo) {
        return this.veiculoService.salvarVeiculo(veiculo.getPlaca(), veiculo.getModelo());
    }

    @GetMapping("/{id}")
    public VeiculoEntity buscarVeiculoPorId(@PathVariable int id) {
        return this.veiculoService.buscarVeiculoPorId(id);
    }

    @GetMapping("/")
    public List<VeiculoEntity> buscarTodosVeiculos() {
        return this.veiculoService.buscarTodosVeiculos();
    }

    @DeleteMapping("/{id}")
    public void deletarVeiculoPorId(@PathVariable int id) {
        this.veiculoService.deletarVeiculoPorId(id);
    }
}
