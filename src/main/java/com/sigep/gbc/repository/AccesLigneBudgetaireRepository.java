package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.AccesLigneBudgetaire;
import com.sigep.gbc.entity.AccesLigneBudgetaireId;

@Repository
public interface AccesLigneBudgetaireRepository extends JpaRepository<AccesLigneBudgetaire, AccesLigneBudgetaireId>{
	@Query(value = "SELECT * FROM AccesLigneBudgetaire WHERE userName=?1 AND gestion=?2", nativeQuery = true)
	List<AccesLigneBudgetaire> getByUserNameAndGestion(String userName, Short gestion);
	
	@Modifying
	@Query(value = "DELETE FROM AccesLigneBudgetaire WHERE userName=?1 AND gestion=?2 AND idBudgett=?3", nativeQuery = true)
	void deleteByUserNameAndGestionAndIdBudget(String userName, Short gestion, Integer idBudget);
}
