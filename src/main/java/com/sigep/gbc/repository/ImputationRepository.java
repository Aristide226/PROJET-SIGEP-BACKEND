package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Imputation;

@Repository
public interface ImputationRepository extends JpaRepository<Imputation, String>{

}
