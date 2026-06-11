package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.AgentAccesCodeAccesCodeNiveauGrpeCodeView;

import java.util.List;

@Repository
public interface AgentAccesCodeAccesCodeNiveauGrpeCodeViewRepository extends JpaRepository<AgentAccesCodeAccesCodeNiveauGrpeCodeView, String>{
	List<AgentAccesCodeAccesCodeNiveauGrpeCodeView> findByCode(String code);
}
