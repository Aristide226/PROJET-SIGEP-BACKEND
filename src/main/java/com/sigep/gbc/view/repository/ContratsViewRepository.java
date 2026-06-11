package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sigep.gbc.view.entity.ContratsView;

import java.util.List;

@Repository
public interface ContratsViewRepository extends JpaRepository<ContratsView, Long>{
	@Query(value = "SELECT * FROM ContratsView WHERE idBudget=?1 ORDER BY numero DESC", nativeQuery = true)
	List<ContratsView> getByIdBudget(Integer idBudget);
	
	@Query(value = "SELECT * FROM ContratsView WHERE annee=?1 AND idBudget=?2 ORDER BY numero DESC", nativeQuery = true)
	List<ContratsView> getByGestionAndIdBudget(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM ContratsView WHERE annee=?1 AND idBudget=?2 AND ResteAEngager>0 ORDER BY numero DESC", nativeQuery = true)
	public List<ContratsView> getContratsPartiellementEngages(Short gestion, Integer idBudget);
	
	@Query(value = "SELECT * FROM ContratsView WHERE idContrat=?1", nativeQuery = true)
	public ContratsView getByIdContrat(Long idContrat);
}
