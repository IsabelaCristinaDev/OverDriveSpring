package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.ClienteEntity;
import com.senai.wanessa.autogyn.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteEntity criarCliente(@Valid @RequestBody ClienteEntity cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping
    public List<ClienteEntity> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/{id}")
    public ClienteEntity buscarClientePorId(@PathVariable int id) {
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarClientePorId(@PathVariable int id) {
        clienteService.deletarClientePorId(id);
    }

    @PutMapping("/{id}")
    public ClienteEntity atualizarCliente(@PathVariable int id, @Valid @RequestBody ClienteEntity clienteAtualizado) {
        ClienteEntity clienteExistente = clienteService.buscarClientePorId(id);
        if (clienteExistente == null) return null;

        clienteAtualizado.setId(id);
        return clienteService.salvarCliente(clienteAtualizado);
    }
}
