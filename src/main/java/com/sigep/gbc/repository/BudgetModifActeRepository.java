package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BudgetModifActe;

@Repository
public interface BudgetModifActeRepository extends JpaRepository<BudgetModifActe, Long>{
	@Query(value = "SELECT MAX(Id) FROM (SELECT codReam AS Id FROM ReamgmtActe UNION SELECT codBMA AS Id FROM BudgetModifActe) AS Subquery", nativeQuery = true)
	public Long getMaxCodReamCodBMA();
	
	public Boolean existsByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide);

	public List<BudgetModifActe> getByGestionAndIdBudgetAndValideOrderByDateSaisieDesc(Short gestion, Integer idBudget, Boolean valide);
}
