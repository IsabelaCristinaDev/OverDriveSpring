package com.senai.wanessa.autogyn.factory;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;

public class VeiculoFactory {
    public static VeiculoEntity criarVeiculo(String placa, String modelo) {
        VeiculoEntity veiculo = new VeiculoEntity();
        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        return veiculo;
    }
}
