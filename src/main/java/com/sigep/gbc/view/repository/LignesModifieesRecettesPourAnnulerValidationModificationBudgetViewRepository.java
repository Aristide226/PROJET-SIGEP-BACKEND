package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourAnnulerValidationModificationBudgetView;

import java.util.List;

@Repository
public interface LignesModifieesRecettesPourAnnulerValidationModificationBudgetViewRepository extends JpaRepository<LignesModifieesRecettesPourAnnulerValidationModificationBudgetView, String>{
	List<LignesModifieesRecettesPourAnnulerValidationModificationBudgetView> findByGestionAndIdBudgetAndCodBma(Short gestion, Integer idBudget, Long codBma);
}
