package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PieceJustif;

@Repository
public interface PieceJustifRepository extends JpaRepository<PieceJustif, String>{
	public List<PieceJustif> getByNumBeOrderByPieceJustificative(Long numBe);
	public List<PieceJustif> deleteByNumBe(Long numBe);
	
	public List<PieceJustif> getByCodLiqOrderByPieceJustificative(Long codLiq);
	public List<PieceJustif> deleteByCodLiq(Long codLiq);
	
	public List<PieceJustif> getByNumMandOrderByPieceJustificative(Long numMand);
	public List<PieceJustif> deleteByNumMand(Long numMand);
}
