package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.DepensesPourCreationEngagementView;

import java.util.List;

@Repository
public interface DepensesPourCreationEngagementViewRepository extends JpaRepository<DepensesPourCreationEngagementView, String>{
	List<DepensesPourCreationEngagementView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
