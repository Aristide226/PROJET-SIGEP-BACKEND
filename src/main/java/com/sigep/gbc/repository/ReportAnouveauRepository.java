package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.ReportAnouveau;

@Repository
public interface ReportAnouveauRepository extends JpaRepository<ReportAnouveau, Long>{

}
