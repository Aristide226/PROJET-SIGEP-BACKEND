package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Fiches;

@Repository
public interface GimFichesRepository extends JpaRepository<Fiches, Long>{
	
	@Query("SELECT COALESCE(Max(f.idFiche),0) FROM Fiches f")
	public Long findByMaxIdFiche();
}
