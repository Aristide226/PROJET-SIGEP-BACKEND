//Aristide
package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmExec;
import com.sigep.gbc.entity.PpmExecId;

@Repository
public interface PpmExecRepository extends JpaRepository<PpmExec,PpmExecId>{
	
	@Query("SELECT p FROM PpmExec p WHERE p.id.idPpmExec = :idPpmExec AND p.id.idBudget = :idBudget AND p.id.exercice = :exercice")
    List<PpmExec> findByIdPpmExecAndIdBudgetAndExercice(
        @Param("idPpmExec") int idPpmExec, 
        @Param("idBudget") Integer idBudget, 
        @Param("exercice") short exercice
    );
	
	@Query("SELECT p FROM PpmExec p WHERE p.ppm.idPpm = :idPpm AND p.id.idBudget = :idBudget AND p.id.exercice = :exercice")
    List<PpmExec> findByPpmKeyAndBudgetAndExercice(
        @Param("idPpm") String idPpm, 
        @Param("idBudget") Integer idBudget, 
        @Param("exercice") short exercice
    );
    
    @Query("SELECT MAX(p.id.idPpmExec) FROM PpmExec p")
    Integer findMaxIdPpmExec();
}
