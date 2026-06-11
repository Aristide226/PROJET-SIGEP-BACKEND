package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmProcedure;

@Repository
public interface PpmProcedureRepository extends JpaRepository<PpmProcedure, Integer>{

}
