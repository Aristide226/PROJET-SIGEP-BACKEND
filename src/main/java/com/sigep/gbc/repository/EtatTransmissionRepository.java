package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.EtatTransmission;

@Repository
public interface EtatTransmissionRepository extends JpaRepository<EtatTransmission, Integer>{

}
