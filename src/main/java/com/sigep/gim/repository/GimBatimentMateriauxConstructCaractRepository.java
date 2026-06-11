package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.BatimentMateriauxConstructCaract;

@Repository
public interface GimBatimentMateriauxConstructCaractRepository extends JpaRepository<BatimentMateriauxConstructCaract, Integer>{
	
}
