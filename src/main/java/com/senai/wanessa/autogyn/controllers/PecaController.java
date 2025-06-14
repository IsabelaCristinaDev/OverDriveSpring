package com.senai.wanessa.autogyn.controllers;


import com.senai.wanessa.autogyn.entities.PecaEntity;
import com.senai.wanessa.autogyn.services.PecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peca")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    @PostMapping("/")
    public PecaEntity criarEstoque(@Valid @RequestBody PecaEntity peca) {
        return pecaService.criarEstoque(peca);
    }

    @GetMapping("/{id}")
    public PecaEntity buscarEstoquePorId(@PathVariable int id) {
        return pecaService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<PecaEntity> buscarTodosEstoque() {
        return pecaService.buscarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPeca(@PathVariable Integer id, @RequestBody PecaEntity pecaAtualizada) {
        PecaEntity pecaExistente = pecaService.buscarPorId(id);
        pecaAtualizada.setId(pecaExistente.getId());
        pecaService.atualizar(pecaAtualizada);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public void deletarEstoque(@PathVariable int id) {
        pecaService.deletarPorId(id);
    }
}
