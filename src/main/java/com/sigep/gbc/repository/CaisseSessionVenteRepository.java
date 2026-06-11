package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CaisseSessionVente;

@Repository
public interface CaisseSessionVenteRepository extends JpaRepository<CaisseSessionVente, String>{

}
