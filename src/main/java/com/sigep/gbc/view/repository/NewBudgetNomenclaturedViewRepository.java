package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.NewBudgetNomenclaturedView;

import java.util.List;

@Repository
public interface NewBudgetNomenclaturedViewRepository extends JpaRepository<NewBudgetNomenclaturedView, String>{
	List<NewBudgetNomenclaturedView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
