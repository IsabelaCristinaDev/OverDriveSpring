package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.ClienteEntity;
import com.senai.wanessa.autogyn.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/")
    public ClienteEntity criarCliente(@Valid @RequestBody ClienteEntity nome) {
        return this.clienteService.salvarCliente(nome.getName());
    }

    @GetMapping("/{id}")
    public ClienteEntity buscarClientePorId(@PathVariable int id) {
        return this.clienteService.buscarClientePorId(id);
    }

    @GetMapping("/")
    public List<ClienteEntity> buscarTodosClientes() {
        return this.clienteService.buscarTodosClientes();
    }

    @DeleteMapping("/{id}")
    public void deletarClientePorId(@PathVariable int id) {
        this.clienteService.deletarClientePorId(id);
    }

}
