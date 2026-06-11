package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.PatrimoineMateriels;

@Repository
public interface GimPatrimoineMaterielsRepository extends JpaRepository<PatrimoineMateriels, String>{
	
}
