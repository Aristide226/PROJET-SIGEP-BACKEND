package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.dto.CompteDestinataireInstitutFinAgenceDto;
import com.sigep.gbc.entity.CompteDestinataire;

@Repository
public interface CompteDestinataireRepository extends JpaRepository<CompteDestinataire, String>{
	
	@Query(value = "SELECT new com.sigep.gbc.dto.CompteDestinataireInstitutFinAgenceDto("
			+ " cd.id,"
			+ " cd.codeBanque,"
			+ " cd.codeAgence,"
			+ " cd.numCompte,"
			+ " cd.cleRib,"
			+ " cd.caissePop,"
			+ " cd.numCaissePop,"
			+ " cd.codeBic,"
			+ " cd.iban,"
			+ " cd.tiersCaissePop.idCaissePop,"
			+ " cd.destinataires.idDest,"
			+ " cd.institutFinancier.abreviation,"
			+ " cd.institutFinAgence.idAgence,"
			+ " ifa.libelleAgence,"
			+ " ifa.domicilieA,"
			+ " CASE WHEN EXISTS (SELECT 1 FROM Liquidation l WHERE l.compteDestinataire.id = cd.id) OR EXISTS (SELECT 1 FROM Mandats m WHERE m.compteDestinataire.id = cd.id) THEN false ELSE true END)"
			+ " FROM CompteDestinataire cd INNER JOIN InstitutFinAgence ifa ON cd.institutFinAgence.idAgence = ifa.idAgence"
			+ " WHERE cd.destinataires.idDest= :idDest")
	public List<CompteDestinataireInstitutFinAgenceDto> getByDestinataires(@Param("idDest") Long idDest);
}
