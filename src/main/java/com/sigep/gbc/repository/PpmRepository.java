package com.sigep.gbc.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sigep.gbc.entity.Ppm;

@Repository
public interface PpmRepository extends JpaRepository<Ppm, String>{
	
	//Aristide
	List<Ppm> findByBudgetTypeIdBudgetAndExercice(Integer idBudget, Short exercice);
	
	 @Query("SELECT MAX(p.num) FROM Ppm p WHERE p.budgetType.id = :idBudget AND p.exercice = :exercice")
	    Integer findMaxNumByIdBudgetAndExercice(@Param("idBudget") Integer idBudget, 
	                                            @Param("exercice") Short exercice);
	 
	 
}
