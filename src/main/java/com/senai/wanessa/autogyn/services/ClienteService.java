package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.ClienteEntity;
import com.senai.wanessa.autogyn.factory.ClienteFactory;
import com.senai.wanessa.autogyn.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity salvarCliente(String nome) {
        ClienteEntity cliente = ClienteFactory.criarCliente(nome);
        return this.clienteRepository.salvar(cliente.getNome());
    }

    public ClienteEntity buscarClientePorId(int id) {
        return this.clienteRepository.buscarPorId(id);
    }

    public List<ClienteEntity> buscarTodosClientes() {
        return this.clienteRepository.buscarTodos();
    }

    public void deletarClientePorId(int id) {
        this.clienteRepository.deletarPorId(id);
    }
}
