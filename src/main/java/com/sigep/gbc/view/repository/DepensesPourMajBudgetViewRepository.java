package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.DepensesPourMajBudgetView;

import java.util.List;

@Repository
public interface DepensesPourMajBudgetViewRepository extends JpaRepository<DepensesPourMajBudgetView, String>{
	List<DepensesPourMajBudgetView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
