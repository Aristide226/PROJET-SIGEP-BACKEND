package com.sigep.gim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.dto.FinancementStatistiqueDto;
import com.sigep.gim.entity.SourceFinancement;

@Repository
public interface GimSourceFinancementRepository extends JpaRepository<SourceFinancement, String>{
	
	@Query("SELECT new com.sigep.gim.dto.FinancementStatistiqueDto(" +
			"s.codSourceFin, s.libSourceFin, " +
			"COUNT(p), " +
			"SUM(CASE WHEN p.categorieBien.codCategorie = 1 THEN 1 ELSE 0 END), " +
	        "SUM(CASE WHEN p.categorieBien.codCategorie = 2 THEN 1 ELSE 0 END)) " +
	        "FROM SourceFinancement s " +
	        "LEFT JOIN s.patrimoines p " +
			"GROUP BY s.codSourceFin,s.libSourceFin")
	List<FinancementStatistiqueDto> getFinancementStatistiqueParCategorie();
}
