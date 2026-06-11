package com.sigep.gim.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gim.dto.CodeAccesAgentDto;
import com.sigep.gim.entity.CodeAcces;


@Repository
public interface GimCodeAccesRepository extends JpaRepository<CodeAcces, Integer>{
	
	@Query(value = "SELECT ISNULL(MAX(idUser), 0)+1 FROM CodeAcces", nativeQuery = true)
	public Integer getIdUser();
	
	@Modifying
	@Query(value = "INSERT INTO CodeAcces (idUser, userName, passWord, motDePasse, etat, nbreConnect, nbreCpte, dateChangement, mleAgent, idCodeAccessType) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
	void insert(int idUser, String userName, String passWord, String motDePasse, boolean etat, int nbreConnect, Integer nbreCpte, Date dateChangement, String mleAgent, char idCodeAccessType);
	
	@Modifying
	@Query(value = "UPDATE CodeAcces SET motDePasse=?1, etat=?2, nbreConnect=?3, nbreCpte=?4, dateChangement=?5, mleAgent=?6, idCodeAccessType=?7 WHERE idUser=?8", nativeQuery = true)
	void update(String motDePasse, boolean etat, int nbreConnect, Integer nbreCpte, Date dateChangement, String mleAgent, char idCodeAccessType, int idUser);
	
	@Query(value = "SELECT new com.sigep.gim.dto.CodeAccesAgentDto("
			+ " ca.idUser,"
			+ " ca.userName,"
			+ " ca.motDePasse,"
			+ " ca.etat,"
			+ " ca.nbreConnect,"
			+ " ca.nbreCpte,"
			+ " ca.dateChangement,"
			+ " ca.agents.mleAgent,"
			+ " ca.codeAccesType.idCodeAccessType,"
			+ " a.nom,"
			+ " a.prenom,"
			+ " a.sexe,"
			+ " a.fonctActuelle,"
			+ " a.titreHono,"
			+ " a.directions.codDirect)"
			+ "FROM CodeAcces ca INNER JOIN Agents a ON ca.agents.mleAgent=a.mleAgent")
	public List<CodeAccesAgentDto> getUtilisateur();
	
	public CodeAcces findByUserName(String username);
}
