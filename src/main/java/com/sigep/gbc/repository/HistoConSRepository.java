package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.HistoConS;

@Repository
public interface HistoConSRepository extends JpaRepository<HistoConS, String>{

}
