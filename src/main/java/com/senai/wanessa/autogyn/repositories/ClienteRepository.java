package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.ClienteEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ClienteEntity salvar(String nome) {
        String sql = "INSERT INTO cliente (nome) VALUES (?)";
        jdbcTemplate.update(sql, nome);

        return buscarUltimoCliente();
    }

    public ClienteEntity buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        ClienteEntity cliente = new ClienteEntity();
        jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            return cliente;
        });
        return cliente;
    }

    public List<ClienteEntity> buscarTodos() {
        String sql = "SELECT * FROM cliente ORDER BY id DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ClienteEntity cliente = new ClienteEntity();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            return cliente;
        });
    }

    public void deletarPorId(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private ClienteEntity buscarUltimoCliente() {
        String sql = "SELECT * FROM cliente ORDER BY id DESC LIMIT 1";
        ClienteEntity cliente = new ClienteEntity();
        jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            return cliente;
        });
        return cliente;
    }
}
