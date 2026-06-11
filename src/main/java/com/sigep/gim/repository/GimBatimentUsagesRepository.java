package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.BatimentUsages;

@Repository
public interface GimBatimentUsagesRepository extends JpaRepository<BatimentUsages, Integer>{
	
}
