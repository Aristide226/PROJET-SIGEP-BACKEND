package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Departement;

@Repository
public interface GimDepartementRepository extends JpaRepository<Departement, Integer>{
	
}
