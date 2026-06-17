package com.sigep.gim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.dto.TypeBienStatistiqueDto;
import com.sigep.gim.entity.CodeBudgType;

@Repository
public interface GimCodeBudgTypeRepository extends JpaRepository<CodeBudgType, Integer>{
	
	@Query("SELECT COALESCE(Max(codTyp),0) FROM CodeBudgType")
	public Integer findMaxCodTyp();
	
	@Query("""
		    SELECT new com.sigep.gim.dto.TypeBienStatistiqueDto(
		        c.codTyp,
		        c.intituleTyp,
		        COALESCE(SUM(CASE WHEN e.etatB = 'Bon' THEN 1 ELSE 0 END),0),
		        COALESCE(SUM(CASE WHEN e.etatB = 'Passable' THEN 1 ELSE 0 END),0),
		        COALESCE(SUM(CASE WHEN e.etatB = 'Délabré' THEN 1 ELSE 0 END),0),
		        COALESCE(SUM(CASE WHEN e.etatB = 'Mauvais' THEN 1 ELSE 0 END),0),
		        COALESCE(SUM(CASE WHEN e.etatB IN ('Bon', 'Passable', 'Délabré', 'Mauvais') THEN 1 ELSE 0 END), 0)
		    )
		    FROM CodeBudgType c
		    LEFT JOIN Patrimoine p
		        ON p.categorieBien.codCategorie = c.categorieBien.codCategorie
		    LEFT JOIN p.etatBien e
		    GROUP BY c.codTyp, c.intituleTyp
		    ORDER BY c.codTyp
		""")
		List<TypeBienStatistiqueDto> getTypeBienStatistiqueDto();
}
