package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigep.gbc.entity.DecisionHvisa;
import com.sigep.gbc.entity.DecisionHvisaId;

public interface DecisionHvisaRepository extends JpaRepository<DecisionHvisa, DecisionHvisaId>{

}
