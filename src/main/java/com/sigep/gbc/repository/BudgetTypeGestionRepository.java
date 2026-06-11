package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BudgetTypeGestion;
import com.sigep.gbc.entity.BudgetTypeGestionId;

@Repository
public interface BudgetTypeGestionRepository extends JpaRepository<BudgetTypeGestion, BudgetTypeGestionId>{

}
