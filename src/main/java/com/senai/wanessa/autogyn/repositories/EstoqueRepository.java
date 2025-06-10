package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.EstoqueEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstoqueRepository {
    private final JdbcTemplate jdbcTemplate;

    public EstoqueRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EstoqueEntity criarEstoque(EstoqueEntity estoque) {
        String sql = "INSERT INTO estoque (nome, valor, quantidade) VALUES (?, ?, ?)";
        System.out.println("Inserindo estoque: " + estoque.getNome() + ", Valor: " + estoque.getValor() + ", Quantidade: " + estoque.getQuantidade());
        jdbcTemplate.update(sql, estoque.getNome(), estoque.getValor(), estoque.getQuantidade());

        return buscarUltimoEstoque();
    }

    public void atualizarQuantidade(int id, int quantidade) {
        String sql = "UPDATE estoque SET quantidade = ? WHERE id = ?";
        jdbcTemplate.update(sql, quantidade, id);
    }

    public EstoqueEntity buscarPorId(int id) {
        String sql = "SELECT * FROM estoque WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setId(rs.getInt("id"));
            estoque.setNome(rs.getString("nome"));
            estoque.setValor(rs.getDouble("valor"));
            estoque.setQuantidade(rs.getInt("quantidade"));
            return estoque;
        });
    }

    public List<EstoqueEntity> buscarTodos() {
        String sql = "SELECT * FROM estoque ORDER BY id DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setId(rs.getInt("id"));
            estoque.setNome(rs.getString("nome"));
            estoque.setValor(rs.getDouble("valor"));
            estoque.setQuantidade(rs.getInt("quantidade"));
            return estoque;
        });
    }

    private EstoqueEntity buscarUltimoEstoque() {
        String sql = "SELECT * FROM estoque ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setId(rs.getInt("id"));
            estoque.setNome(rs.getString("nome"));
            estoque.setValor(rs.getDouble("valor"));
            estoque.setQuantidade(rs.getInt("quantidade"));
            return estoque;
        });
    }

}
