package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Integer> {
}
