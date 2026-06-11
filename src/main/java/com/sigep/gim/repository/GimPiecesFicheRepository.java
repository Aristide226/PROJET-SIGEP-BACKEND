package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.PiecesFiche;

@Repository
public interface GimPiecesFicheRepository extends JpaRepository<PiecesFiche, Long>{
	
}
