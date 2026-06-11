package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Fournisseurs;

@Repository
public interface GimFournisseursRepository extends JpaRepository<Fournisseurs, Long>{
	
	@Query("SELECT COALESCE(Max(f.idFourn), 0) FROM Fournisseurs f")
	public Long findByMaxIdFourn(); 
}
