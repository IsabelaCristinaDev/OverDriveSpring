package com.senai.wanessa.autogyn.services;

import com.senai.wanessa.autogyn.entities.ClienteEntity;
import com.senai.wanessa.autogyn.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteEntity buscarClientePorId(int id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public List<ClienteEntity> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public void deletarClientePorId(int id) {
        clienteRepository.deleteById(id);
    }
}
