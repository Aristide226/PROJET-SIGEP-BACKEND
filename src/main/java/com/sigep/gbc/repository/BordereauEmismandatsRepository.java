package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BordereauEmismandats;

@Repository
public interface BordereauEmismandatsRepository extends JpaRepository<BordereauEmismandats, String>{
	
	@Query(value = "SELECT ISNULL(MAX(Num), 0)+1 FROM BordereauEmismandats WHERE gestion=?1 AND idBudget=?2 AND dossier=?3", nativeQuery = true)
	public Short getNum(Short gestion, Integer idBudget, String dossier);
	
	// RETOURNE UNE SEULE LIGNE : J'UTILISE SUM JUSTE POUR AVOIR NULL AU CAS OU IL NY A PAS DE LIGNE DS LA BASE
	@Query(value = "SELECT ISNULL(SUM(TotalCumul), 0) FROM BordereauEmismandats WHERE gestion=?1 AND idBudget=?2 AND dossier=?3 AND Num = (SELECT MAX(Num) FROM BordereauEmismandats WHERE gestion=?1 AND idBudget=?2 AND dossier=?3)", nativeQuery = true)
	public Long getTotalAnterieur(Short gestion, Integer idBudget, String dossier);
	
	// MONTANT DEDUIT DU DERRIER BORDEREAU : UTIL POUR CALCULER LE CUMUL DU NOUVEAU BORDEREAU
	@Query(value = "SELECT ISNULL(SUM(MontDeduit), 0) FROM BordereauEmismandats WHERE gestion=?1 AND idBudget=?2 AND dossier=?3 AND Num = (SELECT MAX(Num) FROM BordereauEmismandats WHERE gestion=?1 AND idBudget=?2 AND dossier=?3)", nativeQuery = true)
	public Long getMontDeduitDuDernierBordereau(Short gestion, Integer idBudget, String dossier);
	
	@Query(value = "SELECT * FROM BordereauEmismandats WHERE gestion=?1 AND idBudget=?2 AND dossier=?3 ORDER BY Num DESC", nativeQuery = true)
	public List<BordereauEmismandats> getByGestionAndIdBudgetAndDossier(Short gestion, Integer idBudget, String dossier);
}
