package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.FournisseurType;

@Repository
public interface GimFournisseurTypeRepository extends JpaRepository<FournisseurType, String>{
	
}
