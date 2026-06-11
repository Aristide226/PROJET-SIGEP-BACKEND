package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Pj;

@Repository
public interface PjRepository extends JpaRepository<Pj, Integer>{
	
}
