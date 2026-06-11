package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.MandatsView;

@Repository
public interface MandatsViewRepository extends JpaRepository<MandatsView, Long>{
	
	// MANDATS A PARTIR DESQUELS ON PEUT CREER UN NOUVEAU BORDEREAU : ETAT A M2 ET SANS idBordEmis
	@Query(value = "SELECT * FROM MandatsView WHERE gestion=?1 AND idBudget=?2 AND etat='M2' AND idBordEmis IS NULL ORDER BY MandNum DESC", nativeQuery = true)
	public List<MandatsView> getMandatValideAE2EtSansBordereaus(Short gestion, Integer idBudget);
	
}
