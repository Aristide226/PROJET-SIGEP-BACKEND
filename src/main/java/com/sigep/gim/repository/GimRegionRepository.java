package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Region;

@Repository
public interface GimRegionRepository extends JpaRepository<Region, Integer>{
	
	@Query("SELECT COALESCE(Max(codReg),0) FROM Region")
	public Integer findByMaxCodeReg();
}
