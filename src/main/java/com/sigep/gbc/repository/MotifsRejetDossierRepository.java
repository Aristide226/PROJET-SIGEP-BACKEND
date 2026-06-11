package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.MotifsRejetDossier;

@Repository
public interface MotifsRejetDossierRepository extends JpaRepository<MotifsRejetDossier, String>{
	@Modifying
	@Query(value = "DELETE FROM MotifsRejetDossier WHERE Id_motif IN (SELECT TOP 1 Id_motif FROM MotifsRejetDossier WHERE numbe=?1 ORDER BY DateSaisie DESC)", nativeQuery = true)
	void deleteLastRecord(Long numbe);
	
	@Modifying
	@Query(value = "UPDATE MotifsRejetDossier SET actif=0 WHERE numBe=?1 AND actif=1", nativeQuery = true)
	void setActifToFalse(Long numBe);
}
