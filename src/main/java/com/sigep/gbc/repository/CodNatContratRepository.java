package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CodNatContrat;

@Repository
public interface CodNatContratRepository extends JpaRepository<CodNatContrat, String>{

}
