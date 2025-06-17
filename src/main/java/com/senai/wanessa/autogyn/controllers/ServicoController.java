package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.ServicoEntity;
import com.senai.wanessa.autogyn.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = "*")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<ServicoEntity> listar() {
        return servicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoEntity> buscar(@PathVariable Integer id) {
        ServicoEntity servico = servicoService.buscarPorId(id);
        if (servico != null) {
            return ResponseEntity.ok(servico);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ServicoEntity> salvar(@RequestBody ServicoEntity servico) {
        ServicoEntity novoServico = servicoService.salvar(servico);
        return ResponseEntity.ok(novoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoEntity> atualizar(@PathVariable Integer id, @RequestBody ServicoEntity servicoAtualizado) {
        ServicoEntity servico = servicoService.atualizar(id, servicoAtualizado);
        if (servico != null) {
            return ResponseEntity.ok(servico);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
