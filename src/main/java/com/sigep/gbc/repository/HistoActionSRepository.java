package com.sigep.gbc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.dto.HistoActionSHistoConSDto;
import com.sigep.gbc.entity.HistoActionS;
import com.sigep.gbc.entity.HistoActionSId;

@Repository
public interface HistoActionSRepository extends JpaRepository<HistoActionS, HistoActionSId>{
	@Query(value = "SELECT new com.sigep.gbc.dto.HistoActionSHistoConSDto("
			+ "ha.id.dateAct,"
			+ " ha.id.codH,"
			+ " ha.action,"
			+ " hc.idl,"
			+ " hc.dateConnexion,"
			+ " hc.pc,"
			+ " hc.adressMac)"
			+ " FROM HistoActionS ha INNER JOIN HistoConS hc ON ha.id.codH=hc.codH")
	public List<HistoActionSHistoConSDto> getHistoActionSHistoConS();
}
