package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Gestion;

@Repository
public interface GestionRepository extends JpaRepository<Gestion, Short>{
	Gestion findTopByEtatOrderByCouranteDesc(String etat);
	List<Gestion> findByEtatOrderByCouranteDesc(String etat);
}
