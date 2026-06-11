package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sigep.gbc.dto.BudgetModifBudgetDto;
import com.sigep.gbc.entity.BudgetModif;
import com.sigep.gbc.entity.BudgetModifActe;
import com.sigep.gbc.entity.BudgetModifId;

public interface BudgetModifRepository extends JpaRepository<BudgetModif, BudgetModifId>{
	public List<BudgetModif> findByBudgetModifActe(BudgetModifActe budgetModifActe);
	
	//@Query(value = "SELECT new com.sigep.gbc.dto.BudgetModifBudgetDto(b.codBud, b.intitule, b.dotInitiale, m.id.codBma) FROM Budget b INNER JOIN b.budgetModifs m WHERE m.id.codBma=?1")
	//public List<BudgetModifBudgetDto> getLigneModifieesRecettesDepenses(Long codBma);
	
	@Query(value = "SELECT new com.sigep.gbc.dto.BudgetModifBudgetDto("
			+ "b.codBud,"
			+ " b.intitule,"
			+ " b.dotInitiale,"
			+ " b.caajout,"
			+ " b.caannul,"
			+ " b.ream,"
			+ " b.totalEngag,"
			+ " b.dotN1,"
			+ " b.execN1,"
			+ " b.dotN2,"
			+ " b.execN2,"
			+ " b.dotN3,"
			+ " b.execN3,"
			+ " b.gestion.courante,"
			+ " b.nomenclatureD.numNo,"
			+ " b.budgetType.idBudget,"
			+ " b.planComptable.idPlan,"
			+ " m.id.codBma,"
			+ " m.ajoute,"
			+ " m.annule,"
			+ " m.nouvelle)"
			+ " FROM BudgetModif m INNER JOIN Budget b ON m.id.codBud=b.codBud WHERE m.id.codBma=?1")
	public List<BudgetModifBudgetDto> getLigneModifieesRecettesDepenses(Long codBma);
	
	public List<BudgetModif> deleteByBudgetModifActe(BudgetModifActe budgetModifActe);
}
