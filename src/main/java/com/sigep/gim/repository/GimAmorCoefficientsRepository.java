package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.AmorCoefficients;
import com.sigep.gim.entity.AmorCoefficientsId;

@Repository
public interface GimAmorCoefficientsRepository extends JpaRepository<AmorCoefficients, AmorCoefficientsId>{
	
}
