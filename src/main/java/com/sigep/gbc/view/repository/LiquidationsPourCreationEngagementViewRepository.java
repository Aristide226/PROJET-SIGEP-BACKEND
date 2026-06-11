package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sigep.gbc.view.entity.LiquidationsPourCreationEngagementView;

import java.util.List;

@Repository
public interface LiquidationsPourCreationEngagementViewRepository extends JpaRepository<LiquidationsPourCreationEngagementView, Long>{
	List<LiquidationsPourCreationEngagementView> findByGestion(Short gestion);
}
