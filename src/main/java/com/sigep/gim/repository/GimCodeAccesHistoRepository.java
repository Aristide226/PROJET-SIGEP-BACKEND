package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.CodeAccesHisto;
import com.sigep.gim.entity.CodeAccesHistoId;

@Repository
public interface GimCodeAccesHistoRepository extends JpaRepository<CodeAccesHisto, CodeAccesHistoId>{
	
	@Query("SELECT COALESCE(Max(id.id),0) FROM CodeAccesHisto")
	public Integer findMaxId();
}
