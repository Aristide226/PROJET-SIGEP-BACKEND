package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.dto.ReamgmtBudgetDto;
import com.sigep.gbc.entity.Reamgmt;
import com.sigep.gbc.entity.ReamgmtActe;
import com.sigep.gbc.entity.ReamgmtId;

@Repository
public interface ReamgmtRepository extends JpaRepository<Reamgmt, ReamgmtId>{
	public List<Reamgmt> findByReamgmtActe(ReamgmtActe reamgmtActe);
	
	@Query(value = "SELECT new com.sigep.gbc.dto.ReamgmtBudgetDto("
			+ " b.codBud,"
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
			+ " r.id.codReam,"
			+ " r.id.codBug,"
			+ " r.ouvert,"
			+ " r.annule,"
			+ " r.nouvelle)"
			+ " FROM Reamgmt r INNER JOIN Budget b ON r.id.codBug=b.codBud WHERE r.id.codReam=?1")
	public List<ReamgmtBudgetDto> getLigneModifieesRecettesDepenses(Long codReam);
	
	public List<Reamgmt> deleteByReamgmtActe(ReamgmtActe reamgmtActe);
}
