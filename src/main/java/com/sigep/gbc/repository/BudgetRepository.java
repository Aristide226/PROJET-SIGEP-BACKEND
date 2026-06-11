package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.NomenclatureD;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, String>{
	List<Budget> findByGestionAndBudgetType(Gestion gestion, BudgetType budgetType);
	List<Budget> findByNomenclatureD(NomenclatureD nomenclatureD);
	
	// AVEC SUM, SI LA LIGNE N'EXISTE PAS IL RETOURNE NULL : TECHNIQUE UTILISE POUR POUR RETOURNE 0 DANS TOUT LES CAS
	@Query(value = "SELECT ISNULL(SUM(DotInitiale), 0) FROM Budget WHERE gestion=?1 AND idBudget=?2 AND numNo=?3", nativeQuery = true)
	public Long getDotation(short gestion, Integer idBudget, String numNo);
	
	@Query(value = "SELECT ISNULL(SUM(totalEngag), 0) FROM Budget WHERE gestion=?1 AND idBudget=?2 AND numNo=?3", nativeQuery = true)
	public Long getExecution(short gestion, Integer idBudget, String numNo);
	
	@Query(value = "SELECT * FROM Budget WHERE gestion=?1 AND idBudget=?2 AND numNo LIKE '1%'", nativeQuery = true)
	public List<Budget> getRecettes(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM Budget WHERE gestion=?1 AND idBudget=?2 AND numNo LIKE '2%'", nativeQuery = true)
	public List<Budget> getDepenses(Short gestion, Integer idBudget);
	
	@Modifying
	@Query(value = "UPDATE Budget SET "
			+ "CAajout = (SELECT ISNULL(SUM(Ajoute), 0) FROM BudgetModif WHERE CodBud=?1) - (SELECT ISNULL(SUM(Ajoute), 0) FROM BudgetModif bm, BudgetModifActe bma WHERE bm.CodBMA = bma.CodBMA AND CodBud=?1 AND bma.Valide ='false') , "
			+ "CAannul = (SELECT ISNULL(SUM(Annule), 0) FROM BudgetModif WHERE CodBud=?1) - (SELECT ISNULL(SUM(Annule), 0) FROM BudgetModif bm, BudgetModifActe bma WHERE bm.CodBMA = bma.CodBMA AND CodBud=?1 AND bma.Valide ='false') "
			+ "WHERE CodBud=?1", nativeQuery = true)
	public void editCAajoutCAannul(String codBud);
	
	@Modifying
	@Query(value = "UPDATE Budget SET "
			+ "Ream = ((SELECT ISNULL(SUM(Ouvert), 0) FROM Reamgmt WHERE CodBug=?1)-(SELECT ISNULL(SUM(Annule), 0) FROM Reamgmt WHERE CodBug=?1)) - ((SELECT ISNULL(SUM(Ouvert), 0) FROM Reamgmt r, ReamgmtActe ra WHERE r.CodReam = ra.CodReam AND r.CodBug=?1 AND ra.Valide ='false')-(SELECT ISNULL(SUM(Annule), 0) FROM Reamgmt r, ReamgmtActe ra WHERE r.CodReam = ra.CodReam AND r.CodBug=?1 AND ra.Valide ='false')) "
			+ "WHERE CodBud=?1", nativeQuery = true)
	public void editReam(String codBud);
}
