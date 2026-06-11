package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CompteDestinataire;
import com.sigep.gbc.entity.Liquidation;

@Repository
public interface LiquidationRepository extends JpaRepository<Liquidation, Long>{
	// RETOURNE LE NUMERO DE LA LIQUIDATION : SI NULL 1. CLE PRIMAIRE
	@Query(value = "SELECT ISNULL(MAX(CodLiq)+1, 1) FROM Liquidation", nativeQuery = true)
	public Integer getCodLiq();
	
	// RETOURNE LE NUMERO DE LA LIQUIDATION EN FONCTION DE L'ANNE : SI NULL 1.
	@Query(value = "SELECT ISNULL(MAX(NumBl)+1, 1) FROM Liquidation WHERE gestion=?1", nativeQuery = true)
	public Integer getNumBl(Short gestion);
	
	public boolean existsByCompteDestinataire(CompteDestinataire compteDestinataire);
}
