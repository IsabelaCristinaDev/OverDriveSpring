package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.PecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends JpaRepository<PecaEntity, Integer> {

}
