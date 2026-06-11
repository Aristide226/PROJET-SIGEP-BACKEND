//Aristide
package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.DepensesPourPpmBudgetView;

import java.util.List;

@Repository
public interface DepensesPourPpmBudgetViewRepository extends JpaRepository<DepensesPourPpmBudgetView, String>{
	List<DepensesPourPpmBudgetView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
