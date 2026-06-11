package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourAnnulerValidationReamenagementView;

import java.util.List;

@Repository
public interface LignesModifieesDepensesPourAnnulerValidationReamenagementViewRepository extends JpaRepository<LignesModifieesDepensesPourAnnulerValidationReamenagementView, String>{
	List<LignesModifieesDepensesPourAnnulerValidationReamenagementView> findByGestionAndIdBudgetAndCodReam(Short gestion, Integer idBudget, Long codReam);
}
