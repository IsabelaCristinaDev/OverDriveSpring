package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.OrdemServicoEntity;
import com.senai.wanessa.autogyn.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordens-servico")
@CrossOrigin(origins = "*")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService service;

    @GetMapping
    public List<OrdemServicoEntity> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoEntity> buscarPorId(@PathVariable Integer id) {
        OrdemServicoEntity ordem = service.buscarPorId(id);
        if (ordem != null) {
            return ResponseEntity.ok(ordem);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrdemServicoEntity> salvar(@RequestBody OrdemServicoEntity ordem) {
        OrdemServicoEntity nova = service.salvar(ordem);
        return ResponseEntity.ok(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoEntity> atualizar(@PathVariable Integer id, @RequestBody OrdemServicoEntity novaOrdem) {
        OrdemServicoEntity atualizada = service.atualizar(id, novaOrdem);
        if (atualizada != null) {
            return ResponseEntity.ok(atualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
