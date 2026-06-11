package com.sigep.grh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sigep.grh.entity.AccesCodeNiveau;

@Repository
public interface GrhAccesCodeNiveauRepository extends JpaRepository<AccesCodeNiveau, String>{
	
	@Query(value = "SELECT DISTINCT a FROM AccesCodeNiveau a LEFT JOIN FETCH a.grpeCodes")
	public List<AccesCodeNiveau> findAllWithGrpeCodes();
	
	@Query(value = "SELECT a FROM AccesCodeNiveau a LEFT JOIN FETCH a.grpeCodes WHERE a.code = :id")
	public AccesCodeNiveau findByIdWithGrpeCodes(@Param("id") String id);
}
