package com.sigep.gim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.dto.SiteStatistiqueDto;
import com.sigep.gim.entity.Sites;

@Repository
public interface GimSitesRepository extends JpaRepository<Sites, Integer>{
	
	@Query("SELECT new com.sigep.gim.dto.SiteStatistiqueDto(" +
	           "s.codeSite, s.nomSite, " +
	           "COUNT(p), " +
	           "SUM(CASE WHEN p.categorieBien.codCategorie = 1 THEN 1 ELSE 0 END), " +
	           "SUM(CASE WHEN p.categorieBien.codCategorie = 2 THEN 1 ELSE 0 END)) " +
	           "FROM Sites s " +
	           "LEFT JOIN s.patrimoines p " +
	           "GROUP BY s.codeSite, s.nomSite")
	    List<SiteStatistiqueDto> getStatistiquesPatrimoineParCategorie();
}
