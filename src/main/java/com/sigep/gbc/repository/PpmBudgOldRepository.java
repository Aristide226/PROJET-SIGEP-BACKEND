package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmBudgOld;
import com.sigep.gbc.entity.PpmBudgOldId;

@Repository
public interface PpmBudgOldRepository extends JpaRepository<PpmBudgOld, PpmBudgOldId>{

}
