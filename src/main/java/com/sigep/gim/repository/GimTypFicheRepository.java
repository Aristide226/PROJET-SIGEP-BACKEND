package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.TypFiche;

@Repository
public interface GimTypFicheRepository extends JpaRepository<TypFiche, String>{
	
}
