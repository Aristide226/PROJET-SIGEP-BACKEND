package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sigep.gbc.entity.Contrats;

@Repository
public interface ContratsRepository extends JpaRepository<Contrats, Long>{
	// RETOURNE LE NUMERO DU CONTRAT : SI NULL 1. CLE PRIMAIRE
	@Query(value = "SELECT ISNULL(MAX(IdContrat)+1, 1) FROM Contrats", nativeQuery = true)
	public Long getIdContrat();
	
	// RETOURNE LE NUMERO DU CONTRAT EN FONCTION DE L'ANNEE ET IDBUDGET : SI NULL 1.
	@Query(value = "SELECT ISNULL(MAX(Numero)+1, 1) FROM Contrats WHERE annee=?1 AND idBudget=?2", nativeQuery = true)
	public Integer getNumero(Short gestion, Integer idBudget);
	
	// RETOURNE UN NUMERO ORDRE POUR UN CONTRAT ACCORD-CADRE (04) EN FONCTION DE L'ANNEE ET IDBUDGET. 
	@Query(value = "SELECT COUNT(IdContrat)+1  FROM Contrats WHERE annee=?1 AND idBudget=?2 AND codIdentiteExecution='04'", nativeQuery = true)
	public Integer getNumeroContratAccordCadre(Short gestion, Integer idBudget);	
}
