package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CompteMouvEtatVelts;
import com.sigep.gbc.entity.CompteMouvEtatVeltsId;

@Repository
public interface CompteMouvEtatVeltsRepository extends JpaRepository<CompteMouvEtatVelts, CompteMouvEtatVeltsId>{

}
