package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.EtatFiche;

@Repository
public interface GimEtatFicheRepository extends JpaRepository<EtatFiche, String>{
	
}
