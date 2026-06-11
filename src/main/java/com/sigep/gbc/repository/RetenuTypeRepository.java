package com.sigep.gbc.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.RetenuType;

@Repository
public interface RetenuTypeRepository extends JpaRepository<RetenuType, Integer>{
	@Modifying
	@Query(value = "INSERT INTO RetenuType (libelle, taux, codCpte, categorie) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void insert(String libelle, BigDecimal taux, String codCpte, String categorie);
	
	@Modifying
	@Query(value = "UPDATE RetenuType SET libelle=?1, taux=?2, codCpte=?3, categorie=?4 WHERE idTypRetenu=?5", nativeQuery = true)
	void update(String libelle, BigDecimal taux, String codCpte, String categorie, Integer idTypRetenu);
}
