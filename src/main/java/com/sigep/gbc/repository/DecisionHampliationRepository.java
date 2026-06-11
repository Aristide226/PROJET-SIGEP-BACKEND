package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.DecisionHampliation;
import com.sigep.gbc.entity.DecisionHampliationId;

@Repository
public interface DecisionHampliationRepository extends JpaRepository<DecisionHampliation, DecisionHampliationId>{

}
