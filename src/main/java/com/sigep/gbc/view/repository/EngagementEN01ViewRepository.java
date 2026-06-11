package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.EngagementEN01View;

@Repository
public interface EngagementEN01ViewRepository extends JpaRepository<EngagementEN01View, Long>{
	public List<EngagementEN01View> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget, Long montant);
	public EngagementEN01View getByGestionAndIdBudgetAndBenum(Short gestion, Integer idBudget, Integer benum);

	@Query(value = "SELECT * FROM EngagementEN01View WHERE gestion=?1 AND idBudget=?2 AND etat='E0' AND montant>0 UNION SELECT * FROM EngagementEN01View WHERE gestion=?1 AND idBudget=?2 AND etat='E3' AND montant>0 AND idEtatTrans=1 AND receptionne=1 ORDER BY beNum DESC", nativeQuery = true)
	//@Query(value = "SELECT * FROM EngagementEN01View WHERE gestion=?1 AND idBudget=?2 AND etat IN('E0','E3') AND montant>0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementEN01View> getEngagementModifiables(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM EngagementEN01View WHERE gestion=?1 AND idBudget=?2 AND proced='EN01' AND etat='E2' AND ResteALiquider>0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementEN01View> getLesEngagementsPartiellementLiquides(Short gestion, Integer idBudget);

	@Query(value = "SELECT * FROM EngagementEN01View WHERE gestion=?1 AND idBudget=?2 AND proced='EN01' AND etat='E0' AND Montant<0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementEN01View> getBonDAnnulationModifiables(Short gestion, Integer idBudget);
	
	public EngagementEN01View getByNumBe(Long numbe);

	@Query(value = "SELECT * FROM EngagementEN01View WHERE gestion=?1 AND idBudget=?2 AND proced='EN01' AND etat='E2' AND idEtatTrans=1 AND ResteALiquider>0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementEN01View> getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides(Short gestion, Integer idBudget);
}
