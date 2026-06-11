package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.InstitutFinancier;

@Repository
public interface InstitutFinancierRepository extends JpaRepository<InstitutFinancier, String>{
	
}
