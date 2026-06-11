//Aristide
package com.sigep.gbc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sigep.gbc.entity.PpmExecBudg;
import com.sigep.gbc.entity.PpmExecBudgId;

public interface PpmExecBudgRepository extends JpaRepository<PpmExecBudg, PpmExecBudgId> {
	@Query("SELECT SUM(peb.montantEstime) FROM PpmExecBudg peb " +
	           "JOIN PpmExec pe ON peb.id.idPpmExe = pe.id.idPpmExec AND peb.id.idLot = pe.id.idLot " +
	           "WHERE pe.ppm.idPpm = :idPpm AND peb.id.codBud = :codBud AND peb.id.idSrceFin = :idSrceFin")
	    Optional<Long> sumMontantEstimeByPpmBudgKey(
	            @Param("idPpm") String idPpm, 
	            @Param("codBud") String codBud, 
	            @Param("idSrceFin") String idSrceFin);
	
	List<PpmExecBudg> findById_IdPpmExeAndId_IdLotAndId_IdBudgetAndId_Exercice(int idPpmExe, int idLot, Integer idBudget, short exercice);
	
	@Query("SELECT SUM(peb.montantEstime) FROM PpmExecBudg peb " +
	           "JOIN PpmExec pe ON peb.id.idPpmExe = pe.id.idPpmExec AND peb.id.idLot = pe.id.idLot " +
	           "WHERE pe.ppm.idPpm = :idPpm " +
	           "  AND peb.id.codBud = :codBud " +
	           "  AND peb.id.idSrceFin = :idSrceFin " +
	           "  AND NOT (peb.id.idPpmExe = :idPpmExeExclude AND peb.id.idLot = :idLotExclude)")
	    Optional<Long> sumMontantEstimeExcludingLot(
	            @Param("idPpm") String idPpm, 
	            @Param("codBud") String codBud, 
	            @Param("idSrceFin") String idSrceFin,
	            @Param("idPpmExeExclude") int idPpmExeToExclude,
	            @Param("idLotExclude") int idLotToExclude);
}