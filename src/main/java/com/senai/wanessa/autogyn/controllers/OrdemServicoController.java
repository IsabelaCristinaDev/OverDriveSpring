package com.senai.wanessa.autogyn.controllers;

import com.senai.wanessa.autogyn.entities.OrdemServicoEntity;
import com.senai.wanessa.autogyn.services.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping("/")
    public OrdemServicoEntity criarOrdemServico(@Valid @RequestBody OrdemServicoEntity ordemServico) {
        return this.ordemServicoService.criarOrdemServico(ordemServico);
    }

    @GetMapping("/{id}")
    public OrdemServicoEntity buscarOrdemServicoPorId(@PathVariable int id) {
        return this.ordemServicoService.buscarOrdemServicoPorId(id);
    }

    @GetMapping("/")
    public List<OrdemServicoEntity> buscarTodasOrdensServico() {
        return this.ordemServicoService.buscarTodasOrdensServico();
    }

}
