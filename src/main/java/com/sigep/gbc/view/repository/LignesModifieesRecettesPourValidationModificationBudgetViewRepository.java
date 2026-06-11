package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourValidationModificationBudgetView;

import java.util.List;

@Repository
public interface LignesModifieesRecettesPourValidationModificationBudgetViewRepository extends JpaRepository<LignesModifieesRecettesPourValidationModificationBudgetView, String>{
	List<LignesModifieesRecettesPourValidationModificationBudgetView> findByGestionAndIdBudgetAndCodBma(Short gestion, Integer idBudget, Long codBma);
}
