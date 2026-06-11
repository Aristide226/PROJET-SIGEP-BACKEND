package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.ElementEauCourante;

@Repository
public interface GimElementEauCouranteRepository extends JpaRepository<ElementEauCourante, Integer>{
	
}
