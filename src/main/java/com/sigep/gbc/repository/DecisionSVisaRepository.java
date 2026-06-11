package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sigep.gbc.entity.DecisionSvisa;

public interface DecisionSVisaRepository extends JpaRepository<DecisionSvisa, Integer>{
	
	@Modifying
	@Query(value = """ 
			UPDATE DecisionSVisa SET
			RangVisa = :newRangVisa,
			LibelleVisa = :libelleVisa,
			IdType = :idType
			WHERE RangVisa = :oldRangVisa
			""", nativeQuery = true)
	public void update(
			@Param("newRangVisa") int newRangVisa,
			@Param("oldRangVisa") int oldRangVisa,
			@Param("libelleVisa") String libelleVisa,
			@Param("idType") Integer idType
		);
}
