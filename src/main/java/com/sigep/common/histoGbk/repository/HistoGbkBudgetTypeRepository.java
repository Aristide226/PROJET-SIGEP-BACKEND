package com.sigep.common.histoGbk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.common.histoGbk.entity.BudgetType;


@Repository
public interface HistoGbkBudgetTypeRepository extends JpaRepository<BudgetType, Integer>{

}
