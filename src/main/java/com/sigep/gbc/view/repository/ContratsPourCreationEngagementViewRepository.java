package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.ContratsPourCreationEngagementView;

import java.util.List;

@Repository
public interface ContratsPourCreationEngagementViewRepository extends JpaRepository<ContratsPourCreationEngagementView, Long>{
	List<ContratsPourCreationEngagementView> findByAnneeAndIdBudget(Short gestion, Integer idBudget);
}
