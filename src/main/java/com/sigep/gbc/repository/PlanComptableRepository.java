package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sigep.gbc.entity.PlanComptable;

public interface PlanComptableRepository extends JpaRepository<PlanComptable, String>{
	@Query(value = "SELECT * FROM PlanComptable WHERE idPlan LIKE '3%' OR idPlan LIKE '4%'", nativeQuery = true)
	List<PlanComptable> getCompteTiers();
}
