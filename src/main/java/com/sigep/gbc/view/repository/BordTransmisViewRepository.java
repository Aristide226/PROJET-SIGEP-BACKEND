package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.BordTransmisView;

@Repository
public interface BordTransmisViewRepository extends JpaRepository<BordTransmisView, Long>{ 
	
	@Query(value = "SELECT * FROM BordTransmisView WHERE gestion=?1 AND idBudget=?2 AND dossier IN ('E1', 'E3') AND idLoginRecep IS NULL ORDER BY Numero DESC", nativeQuery = true)
	public List<BordTransmisView> getBordTransmisEtNonReceptionne(Short gestion, Integer idBudget);
}
