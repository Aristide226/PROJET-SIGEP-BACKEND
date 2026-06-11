package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CompteDestinataire;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.Mandats;

@Repository
public interface MandatsRepository extends JpaRepository<Mandats, Long>{
	// RETOURNE LE NUMERO DU MANDAT : SI NULL 1. CLE PRIMAIRE
	@Query(value = "SELECT ISNULL(MAX(numMand)+1, 1) FROM Mandats", nativeQuery = true)
	public Integer getNumMand();
	
	// RETOURNE LE NUMERO DU MANDAT EN FONCTION DE L'ANNE : SI NULL 1.
	@Query(value = "SELECT ISNULL(MAX(mandNum)+1, 1) FROM Mandats WHERE gestion=?1", nativeQuery = true)
	public Integer getMandNum(Short gestion);
	
	public Mandats findByEngagements(Engagements engagements);
	
	// POUR RECEPTIONNNER UNIQUEMENT LES ENGAGEMENT EN PROCEDURE SIMPLIFIER
	@Modifying
	@Query(value = "UPDATE Mandats SET receptionne=1 WHERE IdBord=?1", nativeQuery = true)
	void receptionnerEN02(Long codBord);
	
	// RETOURNE LE NUMERO numBl POUR CREER UNE LIQUIDATION D'UN ENGAGEMENT EN PROCEDURE NORMALE
	// VERIFIER QUE L'ENGAGEMENT EST EN PROCEDURE NORMALE AVANT D'APPELER CETTE FONCTION
	@Query(value = "SELECT ISNULL(MAX(numBl)+1, 1) FROM Mandats WHERE NumBE=?1", nativeQuery = true)
	public Integer getNumBlEN01(Long numBe);
	
	public boolean existsByCompteDestinataire(CompteDestinataire compteDestinataire);
}
