package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CaisseSessionBilletage;
import com.sigep.gbc.entity.CaisseSessionBilletageId;

@Repository
public interface CaisseSessionBilletageRepository extends JpaRepository<CaisseSessionBilletage, CaisseSessionBilletageId>{

}
