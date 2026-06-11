package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.StElements;
import com.sigep.gbc.entity.StElementsNomencla;
import com.sigep.gbc.entity.StElementsNomenclaId;

public interface StElementsNomenclaRepository extends JpaRepository<StElementsNomencla, StElementsNomenclaId>{
	List<StElementsNomencla> findByStElementsAndGestion(StElements stElements, Gestion gestion);
}
