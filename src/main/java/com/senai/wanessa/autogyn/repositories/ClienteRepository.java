package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
