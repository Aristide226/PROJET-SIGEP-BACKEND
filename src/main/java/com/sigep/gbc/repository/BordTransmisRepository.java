package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BordTransmis;

@Repository
public interface BordTransmisRepository extends JpaRepository<BordTransmis, Long>{
	@Query(value = "SELECT ISNULL(MAX(codBord), 0)+1 FROM BordTransmis")
	public Long getCodBord();
	
	@Query(value = "SELECT ISNULL(MAX([numero]), 0)+1 FROM BordTransmis WHERE gestion=?1 AND idBudget=?2 AND expeditaire=?3", nativeQuery = true)
	public Integer getNumero(Short gestion, Integer idBudget, String expeditaire);
	
	@Query(value = "SELECT * FROM BordTransmis WHERE gestion=?1 AND idBudget=?2 AND expeditaire=?3 ORDER BY numero DESC", nativeQuery = true)
	public List<BordTransmis> getByGestionAndIdBudgetAndExpeditaire(Short gestion, Integer idBudget, String expeditaire);

}
