package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Engagements;

@Repository
public interface EngagementsRepository extends JpaRepository<Engagements, Long>{
	// RETOURNE LE NUMERO DE L'ENGAGEMENT : SI NULL 1. CLE PRIMAIRE
	@Query(value = "SELECT ISNULL(MAX(NumBE)+1, 1) FROM Engagements", nativeQuery = true)
	public Integer getNumBE();
	
	// RETOURNE LE NUMERO DE D'ENGAGEMENT EN FONCTION DE L'ANNE : SI NULL 1.
	@Query(value = "SELECT ISNULL(MAX(BENum)+1, 1) FROM Engagements WHERE gestion=?1", nativeQuery = true)
	public Integer getBENum(Short gestion);
	
	@Modifying
	@Query(value = "UPDATE Engagements SET receptionne=1 WHERE IdBord=?1", nativeQuery = true)
	void receptionner(Long codBord);
}
