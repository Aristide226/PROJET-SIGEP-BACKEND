package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.GrpeCode;

@Repository
public interface GrpeCodeRepository extends JpaRepository<GrpeCode, String>{

}
