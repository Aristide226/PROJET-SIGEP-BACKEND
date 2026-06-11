package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.LignesModifieesDepensesPourValidationReamenagementView;

import java.util.List;

@Repository
public interface LignesModifieesDepensesPourValidationReamenagementViewRepository extends JpaRepository<LignesModifieesDepensesPourValidationReamenagementView, String>{
	List<LignesModifieesDepensesPourValidationReamenagementView> findByGestionAndIdBudgetAndCodReam(Short gestion, Integer idBudget, Long codReam);
}
