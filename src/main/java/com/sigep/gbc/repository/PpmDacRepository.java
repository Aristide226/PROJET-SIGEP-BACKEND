package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmDac;

@Repository
public interface PpmDacRepository extends JpaRepository<PpmDac, String>{

}
