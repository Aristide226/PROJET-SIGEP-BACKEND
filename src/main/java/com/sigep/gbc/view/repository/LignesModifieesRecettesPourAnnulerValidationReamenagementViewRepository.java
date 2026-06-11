package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourAnnulerValidationReamenagementView;

import java.util.List;

@Repository
public interface LignesModifieesRecettesPourAnnulerValidationReamenagementViewRepository extends JpaRepository<LignesModifieesRecettesPourAnnulerValidationReamenagementView, String>{
	List<LignesModifieesRecettesPourAnnulerValidationReamenagementView> findByGestionAndIdBudgetAndCodReam(Short gestion, Integer idBudget, Long codReam);
}
