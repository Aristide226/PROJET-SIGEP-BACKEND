package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BordTransRecouv;
import com.sigep.gbc.entity.BordTransRecouvId;

@Repository
public interface BordTransRecouvRepository extends JpaRepository<BordTransRecouv, BordTransRecouvId>{

}
