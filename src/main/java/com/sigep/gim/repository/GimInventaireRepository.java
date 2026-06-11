package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Inventaire;

@Repository
public interface GimInventaireRepository extends JpaRepository<Inventaire, Long>{
	
	@Query("SELECT COALESCE(Max(idInvent),0) FROM Inventaire")
	public long findMaxIdInvent();
}
