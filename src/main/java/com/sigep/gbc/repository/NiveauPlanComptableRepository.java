package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.NiveauPlanComptable;

@Repository
public interface NiveauPlanComptableRepository extends JpaRepository<NiveauPlanComptable, Integer>{

}
