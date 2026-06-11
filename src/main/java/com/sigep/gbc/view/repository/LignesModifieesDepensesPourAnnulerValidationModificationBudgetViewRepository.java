package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourAnnulerValidationModificationBudgetView;

import java.util.List;

@Repository
public interface LignesModifieesDepensesPourAnnulerValidationModificationBudgetViewRepository extends JpaRepository<LignesModifieesDepensesPourAnnulerValidationModificationBudgetView, String>{
	List<LignesModifieesDepensesPourAnnulerValidationModificationBudgetView> findByGestionAndIdBudgetAndCodBma(Short gestion, Integer idBudget, Long codBma);
}
