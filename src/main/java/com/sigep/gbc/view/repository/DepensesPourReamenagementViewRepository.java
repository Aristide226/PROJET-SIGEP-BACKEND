package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.DepensesPourReamenagementView;

import java.util.List;

@Repository
public interface DepensesPourReamenagementViewRepository extends JpaRepository<DepensesPourReamenagementView, String>{
	List<DepensesPourReamenagementView> findByGestionAndIdBudget(Short gestion, Integer idBudget);
}
