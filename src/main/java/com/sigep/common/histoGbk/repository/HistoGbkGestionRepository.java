package com.sigep.common.histoGbk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.common.histoGbk.entity.Gestion;


@Repository
public interface HistoGbkGestionRepository extends JpaRepository<Gestion, Short>{
	Gestion findTopByEtatOrderByCouranteDesc(String etat);
	List<Gestion> findByEtatOrderByCouranteDesc(String etat);
}
