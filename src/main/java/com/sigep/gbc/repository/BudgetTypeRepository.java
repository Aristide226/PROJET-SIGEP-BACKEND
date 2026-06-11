package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BudgetType;

@Repository
public interface BudgetTypeRepository extends JpaRepository<BudgetType, Integer>{

}
