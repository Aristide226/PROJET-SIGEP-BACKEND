package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.RecettesPourMajBudgetView;

import java.util.List;

@Repository
public interface RecettesPourMajBudgetViewRepository extends JpaRepository<RecettesPourMajBudgetView, String>{
	List<RecettesPourMajBudgetView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
