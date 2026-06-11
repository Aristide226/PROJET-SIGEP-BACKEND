//Aristide
package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.DepensesLignesBudgetaireEnFonctionDePpmView;

@Repository
public interface DepensesLignesBudgetaireEnFonctionDePpmViewRepository extends JpaRepository<DepensesLignesBudgetaireEnFonctionDePpmView , String> {
	List <DepensesLignesBudgetaireEnFonctionDePpmView> findByGestionAndIdBudgetAndIdPPM(Short gestion, Integer idBudget, String idPpm);
	
}
