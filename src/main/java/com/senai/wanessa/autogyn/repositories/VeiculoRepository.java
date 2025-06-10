package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeiculoRepository {
    private final JdbcTemplate jdbcTemplate;

    public VeiculoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public VeiculoEntity salvar(String placa, String modelo) {
        String sql = "INSERT INTO veiculo (placa, modelo) VALUES (?, ?)";
        jdbcTemplate.update(sql, placa, modelo);

        return buscarUltimoVeiculo();
    }

    public VeiculoEntity buscarPorId(int id) {
        String sql = "SELECT * FROM veiculo WHERE id = ?";
        VeiculoEntity veiculo = new VeiculoEntity();
        jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            veiculo.setId(rs.getInt("id"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setModelo(rs.getString("modelo"));
            return veiculo;
        });
        return veiculo;
    }

    public List<VeiculoEntity> buscarTodos() {
        String sql = "SELECT * FROM veiculo ORDER BY id DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VeiculoEntity veiculo = new VeiculoEntity();
            veiculo.setId(rs.getInt("id"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setModelo(rs.getString("modelo"));
            return veiculo;
        });
    }

    public void deletarPorId(int id) {
        String sql = "DELETE FROM veiculo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private VeiculoEntity buscarUltimoVeiculo() {
        String sql = "SELECT * FROM veiculo ORDER BY id DESC LIMIT 1";
        VeiculoEntity veiculo = new VeiculoEntity();
        jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            veiculo.setId(rs.getInt("id"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setModelo(rs.getString("modelo"));
            return veiculo;
        });
        return veiculo;
    }
}
