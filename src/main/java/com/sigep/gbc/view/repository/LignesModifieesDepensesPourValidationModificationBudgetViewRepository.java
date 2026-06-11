package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourValidationModificationBudgetView;

import java.util.List;

@Repository
public interface LignesModifieesDepensesPourValidationModificationBudgetViewRepository extends JpaRepository<LignesModifieesDepensesPourValidationModificationBudgetView, String>{
	List<LignesModifieesDepensesPourValidationModificationBudgetView> findByGestionAndIdBudgetAndCodBma(Short gestion, Integer idBudget, Long codBma);
}
