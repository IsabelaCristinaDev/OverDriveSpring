package com.senai.wanessa.autogyn.factory;

import com.senai.wanessa.autogyn.entities.ClienteEntity;

public class ClienteFactory {
    public static ClienteEntity criarCliente(String nome) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(nome);
        return cliente;
    }
}
