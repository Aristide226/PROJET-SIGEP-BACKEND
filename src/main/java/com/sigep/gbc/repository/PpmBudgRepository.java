package com.sigep.gbc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmBudg;
import com.sigep.gbc.entity.PpmBudgId;

@Repository
public interface PpmBudgRepository extends JpaRepository<PpmBudg, PpmBudgId>{
	
	//Aristide
	List<PpmBudg> findById_IdPpm(String idPpm);
	
}
