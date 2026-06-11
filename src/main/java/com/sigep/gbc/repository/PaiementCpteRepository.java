package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PaiementCpte;
import com.sigep.gbc.entity.PaiementCpteId;

@Repository
public interface PaiementCpteRepository extends JpaRepository<PaiementCpte, PaiementCpteId>{

}
