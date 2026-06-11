package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.DestinataireTier;

@Repository
public interface GimDestinataireTierRepository extends JpaRepository<DestinataireTier, Integer>{
	
}
