package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.BordereauEmismandatsView;

@Repository
public interface BordereauEmismandatsViewRepository extends JpaRepository<BordereauEmismandatsView, String>{ 
	
	@Query(value = "SELECT * FROM BordereauEmismandatsView WHERE gestion=?1 AND idBudget=?2 AND dossier=?3 ORDER BY Num DESC", nativeQuery = true)
	public List<BordereauEmismandatsView> getByGestionAndIdBudgetAndDossier(Short gestion, Integer idBudget, String dossier);
}
