package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.ReamgmtActe;

@Repository
public interface ReamgmtActeRepository extends JpaRepository<ReamgmtActe, Long>{
	public Boolean existsByGestionAndBudgetTypeAndValide(Gestion gestion, BudgetType budgetType, Boolean valide);
	
	public List<ReamgmtActe> getByGestionAndBudgetTypeAndValideOrderByDateSaisieDesc(Gestion gestion, BudgetType budgetType, Boolean valide);
 
	// RETOURNE LE NUMERO DE L'ACTE EN FONCTION DE L'ANNE ET DE LA DECISION : SI NULL 1
	@Query(value = "SELECT ISNULL(MAX(ActeNum)+1, 1) FROM ReamgmtActe WHERE gestion=?1 AND acte=?2", nativeQuery = true)
	public Integer getActeNum(Short gestion, String acte);
	
	// RETOURNE LE NUMERO DE L'ACTE EN FONCTION DE L'ANNE ET DE LA DECISION : UTILISER POUR LA MODIFICATION DU NUMERO EN AUTO
	@Query(value = "SELECT MAX(ActeNum) FROM ReamgmtActe WHERE gestion=?1 AND acte=?2", nativeQuery = true)
	public Integer getActeNum_(Short gestion, String acte);
}
