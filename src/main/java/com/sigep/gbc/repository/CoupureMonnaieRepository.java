package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CoupureMonnaie;
import com.sigep.gbc.entity.CoupureMonnaieId;

@Repository
public interface CoupureMonnaieRepository extends JpaRepository<CoupureMonnaie, CoupureMonnaieId>{
	@Modifying
	@Query(value = "UPDATE CoupureMonnaie SET designa=?1, idCoupure=?2 WHERE designa=?3 AND idCoupure=?4", nativeQuery = true)
	void update(String newDesigna, Long newIdCoupure, String designa, Long idCoupure);
}
