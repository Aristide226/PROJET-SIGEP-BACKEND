package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.ElementElectricite;

@Repository
public interface GimElementElectriciteRepository extends JpaRepository<ElementElectricite, Integer>{
	
}
