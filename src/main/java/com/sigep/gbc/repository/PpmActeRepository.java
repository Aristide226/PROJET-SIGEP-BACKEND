package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.sigep.gbc.entity.PpmActe;

@Repository
public interface PpmActeRepository extends JpaRepository<PpmActe, String>{
	
	//Aristide
	List <PpmActe> findByGestion(Short gestion);
	List <PpmActe> findByGestionAndBudgetTypeIdBudget(Short gestion, Integer idBudget);
}
