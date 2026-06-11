package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.MagasinEntrepot;

@Repository
public interface GimMagasinEntrepotRepository extends JpaRepository<MagasinEntrepot, Integer>{
	
}
