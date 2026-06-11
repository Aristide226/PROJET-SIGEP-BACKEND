package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.HistoEtat;
import com.sigep.gim.entity.HistoEtatId;

@Repository
public interface GimHistoEtatRepository extends JpaRepository<HistoEtat, HistoEtatId>{
	
}
