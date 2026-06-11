package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.DirectionService;

@Repository
public interface DirectionServiceRepository extends JpaRepository<DirectionService, Integer>{
	@Modifying
	@Query(value = "UPDATE DirectionServiceS SET idParent=?1 WHERE idService=?2", nativeQuery = true)
	void updateIdParent(Integer idParent, Integer idService);
}
