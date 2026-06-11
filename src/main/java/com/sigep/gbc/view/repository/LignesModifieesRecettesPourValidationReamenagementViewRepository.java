package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesRecettesPourValidationReamenagementView;

import java.util.List;

@Repository
public interface LignesModifieesRecettesPourValidationReamenagementViewRepository extends JpaRepository<LignesModifieesRecettesPourValidationReamenagementView, String>{
	List<LignesModifieesRecettesPourValidationReamenagementView> findByGestionAndIdBudgetAndCodReam(Short gestion, Integer idBudget, Long codReam);
}
