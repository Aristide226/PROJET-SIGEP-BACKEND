package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmExecBudgId;
import com.sigep.gbc.view.entity.PpmExecBudgView;

@Repository
public interface PpmExecBudgViewRepository extends JpaRepository<PpmExecBudgView, PpmExecBudgId>{
	
	@Query(value = "SELECT * FROM PpmExecBudgView P WHERE NOT EXISTS (SELECT * FROM Contrats C WHERE P.IdPPMExe = C.IdPPMExe AND P.IdLot = C.IdLot AND P.IdBudget = C.IdBudget AND P.Exercice = C.Annee AND P.CodBud = C.CodBud AND P.IdSrceFin = C.IdSrceFin) AND Exercice=?1 AND IdBudget=?2", nativeQuery = true)
	public List<PpmExecBudgView> getByExerciceAndIdBudget(Short exercice, Integer idBudget);
}
