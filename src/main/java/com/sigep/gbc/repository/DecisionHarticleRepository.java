package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.DecisionHarticle;
import com.sigep.gbc.entity.DecisionHarticleId;

@Repository
public interface DecisionHarticleRepository extends JpaRepository<DecisionHarticle, DecisionHarticleId>{

}
