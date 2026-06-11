package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.AccesLigneBudgetaireNomenclatureDBudgetView;

import java.util.List;

@Repository
public interface AccesLigneBudgetaireNomenclatureDBudgetViewRepository extends JpaRepository<AccesLigneBudgetaireNomenclatureDBudgetView, String>{
	List<AccesLigneBudgetaireNomenclatureDBudgetView> findByUserNameAndGestionAndIdBudget(String userName, Short gestion, Integer idBudget);
}
