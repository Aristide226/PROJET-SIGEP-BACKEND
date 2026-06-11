package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.EngagementEN02View;

@Repository
public interface EngagementEN02ViewRepository extends JpaRepository<EngagementEN02View, Long>{
	public List<EngagementEN02View> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget, Long montant);
	public EngagementEN02View getByGestionAndIdBudgetAndBenum(Short gestion, Integer idBudget, Integer benum);//

	@Query(value = "SELECT * FROM EngagementEN02View WHERE gestion=?1 AND idBudget=?2 AND etat='E0' AND montant>0 UNION SELECT * FROM EngagementEN02View WHERE gestion=?1 AND idBudget=?2 AND etat='E3' AND montant>0 AND idEtatTrans=1 AND receptionne=1 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementEN02View> getEngagementModifiables(Short gestion, Integer idBudget);
}
