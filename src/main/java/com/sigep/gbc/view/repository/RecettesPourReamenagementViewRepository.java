package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.RecettesPourReamenagementView;

import java.util.List;

@Repository
public interface RecettesPourReamenagementViewRepository extends JpaRepository<RecettesPourReamenagementView, String>{
	List<RecettesPourReamenagementView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
