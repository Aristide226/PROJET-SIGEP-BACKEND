package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.ContratType;

@Repository
public interface ContratTypeRepository extends JpaRepository<ContratType, String>{

}
