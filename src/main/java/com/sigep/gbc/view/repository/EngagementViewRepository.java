package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.EngagementView;

@Repository
public interface EngagementViewRepository extends JpaRepository<EngagementView, Long>{
	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E0' AND montant>0 UNION SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E3' AND montant>0 AND idEtatTrans=1 AND receptionne=1 ORDER BY beNum DESC", nativeQuery = true)
	//@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat IN('E0','E3') AND montant>0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementModifiables(Short gestion, Integer idBudget);
	
	public List<EngagementView> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget, Long montant);

	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E0' UNION SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E3' AND idEtatTrans=1 AND receptionne=1 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementValidables(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND idUser=?3 AND idEtatTrans=0 AND etat IN ('E1', 'E2', 'E3') ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementRetrogradables(Short gestion, Integer idBudget, String idUser);
	
	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E1' AND idEtatTrans=0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementValideEtNonTransmis(Short gestion, Integer idBudget);

	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E1' AND idEtatTrans=1 AND receptionne=1 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementValideEtTransmisEtReceptionne(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E2' AND idEtatTrans=0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementValideAE2EtNonTransmis(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM EngagementView WHERE gestion=?1 AND idBudget=?2 AND etat='E3' AND idEtatTrans=0 ORDER BY beNum DESC", nativeQuery = true)
	public List<EngagementView> getEngagementRejeteAE3EtNonTransmis(Short gestion, Integer idBudget);
}
