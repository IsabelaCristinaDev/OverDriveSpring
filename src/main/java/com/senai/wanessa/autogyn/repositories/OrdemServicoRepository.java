package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.OrdemServicoEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdemServicoRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrdemServicoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public OrdemServicoEntity criarOrdemServico(OrdemServicoEntity ordemServico) {
        String sql = "INSERT INTO ordem_servico (cliente_id, veiculo_id, estoque_id, descricao, valor) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                ordemServico.getClienteId(),
                ordemServico.getVeiculoId(),
                ordemServico.getEstoqueId() > 0 ? ordemServico.getEstoqueId() : null,
                ordemServico.getDescricao(),
                ordemServico.getValor()
        );

        return buscarUltimaOrdemServico();
    }

    public OrdemServicoEntity buscarPorId(int id) {
        String sql = "SELECT * FROM ordem_servico WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            OrdemServicoEntity ordemServico = new OrdemServicoEntity();
            ordemServico.setId(rs.getInt("id"));
            ordemServico.setClienteId(rs.getInt("cliente_id"));
            ordemServico.setVeiculoId(rs.getInt("veiculo_id"));
            ordemServico.setEstoqueId(rs.getInt("estoque_id"));
            ordemServico.setDescricao(rs.getString("descricao"));
            ordemServico.setValor(rs.getDouble("valor"));
            return ordemServico;
        });
    }

    public List<OrdemServicoEntity> buscarTodos() {
        String sql = "SELECT * FROM ordem_servico ORDER BY id DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            OrdemServicoEntity ordemServico = new OrdemServicoEntity();
            ordemServico.setId(rs.getInt("id"));
            ordemServico.setClienteId(rs.getInt("cliente_id"));
            ordemServico.setVeiculoId(rs.getInt("veiculo_id"));
            ordemServico.setEstoqueId(rs.getInt("estoque_id"));
            ordemServico.setDescricao(rs.getString("descricao"));
            ordemServico.setValor(rs.getDouble("valor"));
            return ordemServico;
        });
    }

    private OrdemServicoEntity buscarUltimaOrdemServico() {
        String sql = "SELECT * FROM ordem_servico ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            OrdemServicoEntity ordemServico = new OrdemServicoEntity();
            ordemServico.setId(rs.getInt("id"));
            ordemServico.setClienteId(rs.getInt("cliente_id"));
            ordemServico.setVeiculoId(rs.getInt("veiculo_id"));
            ordemServico.setEstoqueId(rs.getInt("estoque_id"));
            ordemServico.setDescricao(rs.getString("descricao"));
            ordemServico.setValor(rs.getDouble("valor"));
            return ordemServico;
        });
    }
}
