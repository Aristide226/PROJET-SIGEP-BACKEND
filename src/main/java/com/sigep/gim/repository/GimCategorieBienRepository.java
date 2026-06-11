package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.CategorieBien;

@Repository
public interface GimCategorieBienRepository extends JpaRepository<CategorieBien, Integer>{
	
	@Query("SELECT COALESCE(Max(c.codCategorie),0) FROM CategorieBien c")
	public Integer findMaxCodCategorie();
}
