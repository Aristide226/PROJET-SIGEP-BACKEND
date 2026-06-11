package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Destinataires;

@Repository
public interface DestinatairesRepository extends JpaRepository<Destinataires, Long>{
	
	public Destinataires findTopByOrderByIdDestDesc();
	
	public boolean existsByIfumleAndIfumleNot(String ifumle, String excludedValue);
	public boolean existsByIfumleAndIfumleNotOrNom(String ifumle, String excludedValue, String nom);
	public boolean existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot(String ifumle, String excludedValue, Long idDest1, String nom, Long idDest2);
	
	@Query(value = "SELECT MAX(idDest) FROM Destinataires")
	public Long getMaxIDest();
	
	@Modifying
	@Query(value = "INSERT INTO Destinataires (idDest, ifumle, ftype, contactTel, contactEmail) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	void insert(long idDest, String ifumle, String ftype, String contactTel, String contactEmail);
	
	@Modifying
	@Query(value = "UPDATE Destinataires SET ifumle=?1, ftype=?2, contactTel=?3, contactEmail=?4 WHERE idDest=?5", nativeQuery = true)
	void update(String ifumle, String ftype, String contactTel, String contactEmail, long idDest);

	@Query(value = "SELECT * FROM Destinataires WHERE ftype!='A'", nativeQuery = true)
	public List<Destinataires> getDestinataireSansAgents();
	
	//Aristide
	@Query("SELECT d FROM Destinataires d WHERE d.ftype = 'F'")
	List<Destinataires> findFournisseurs();
}
