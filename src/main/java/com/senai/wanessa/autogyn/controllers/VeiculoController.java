package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;
import com.senai.wanessa.autogyn.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public VeiculoEntity criar(@RequestBody VeiculoEntity veiculo) {
        return veiculoService.salvarVeiculo(veiculo);
    }

    @GetMapping
    public List<VeiculoEntity> buscarTodos() {
        return veiculoService.buscarTodosVeiculos();
    }

    @GetMapping("/{id}")
    public VeiculoEntity buscarPorId(@PathVariable int id) {
        return veiculoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public VeiculoEntity atualizar(@PathVariable int id, @RequestBody VeiculoEntity atualizado) {
        VeiculoEntity existente = veiculoService.buscarPorId(id);
        if (existente == null) return null;

        atualizado.setId(id);
        return veiculoService.salvarVeiculo(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        veiculoService.deletarPorId(id);
    }
}
