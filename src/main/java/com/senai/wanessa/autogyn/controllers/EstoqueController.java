package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.EstoqueEntity;
import com.senai.wanessa.autogyn.services.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/")
    public EstoqueEntity criarEstoque(@Valid @RequestBody EstoqueEntity estoque) {
        return this.estoqueService.criarEstoque(estoque);
    }

    @GetMapping("/{id}")
    public EstoqueEntity buscarEstoquePorId(@PathVariable int id) {
        return this.estoqueService.buscarEstoquePorId(id);
    }

    @GetMapping("/")
    public List<EstoqueEntity> buscarTodosEstoque() {
        return this.estoqueService.buscarTodosEstoque();
    }

}
