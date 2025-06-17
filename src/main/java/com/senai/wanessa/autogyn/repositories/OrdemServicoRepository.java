
package com.senai.wanessa.autogyn.repositories;

import com.senai.wanessa.autogyn.entities.OrdemServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoEntity, Integer> {

}
