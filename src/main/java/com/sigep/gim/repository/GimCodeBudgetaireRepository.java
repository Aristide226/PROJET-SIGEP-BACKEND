package com.sigep.gim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.dto.CodeBudgetaireStatistiqueDto;
import com.sigep.gim.entity.CodeBudgetaire;

@Repository
public interface GimCodeBudgetaireRepository extends JpaRepository<CodeBudgetaire, Integer>{
	
	@Query("""
		    SELECT new com.sigep.gim.dto.CodeBudgetaireStatistiqueDto(
		        c.codBud,
		        c.intituleCodBud,
		        COALESCE(SUM(CASE WHEN e.etatB = 'Bon' THEN 1 ELSE 0 END), 0),
		        COALESCE(SUM(CASE WHEN e.etatB = 'Passable' THEN 1 ELSE 0 END), 0),
		        COALESCE(SUM(CASE WHEN e.etatB = 'Délabré' THEN 1 ELSE 0 END), 0),
		        COALESCE(SUM(CASE WHEN e.etatB = 'Mauvais' THEN 1 ELSE 0 END), 0),
		        COUNT(p)
		    )
		    FROM CodeBudgetaire c
		    LEFT JOIN CodeMateriel cm ON cm.codeBudgetaire.codBud = c.codBud
		    LEFT JOIN Patrimoine p ON p.codeMateriel.codMat = cm.codMat
		    LEFT JOIN p.etatBien e
		    GROUP BY c.codBud, c.intituleCodBud
		    ORDER BY c.codBud
		""")
	List<CodeBudgetaireStatistiqueDto> getCodeBudgetaireStatistiqueDto();
}
