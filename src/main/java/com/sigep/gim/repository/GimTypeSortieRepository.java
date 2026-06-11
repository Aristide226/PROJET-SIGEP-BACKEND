package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.TypeSortie;

@Repository
public interface GimTypeSortieRepository extends JpaRepository<TypeSortie, Short>{
	
	@Query("SELECT COALESCE(Max(typSortie),0) FROM TypeSortie")
	public short findByMaxTypSortie();
}
