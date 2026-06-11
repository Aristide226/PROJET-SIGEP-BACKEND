package com.sigep.gbc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.dto.AccesCodeAgentDto;
import com.sigep.gbc.entity.AccesCode;
import com.sigep.gbc.entity.AccesCodeNiveau;

@Repository
public interface AccesCodeRepository extends JpaRepository<AccesCode, String>{
	
	@Query(value = "SELECT MAX(rangCod) FROM AccesCode WHERE code=?1")
	public Integer getMaxRangCod(String code);
	
	@Modifying
	@Query(value = "INSERT INTO AccesCode (userName, motPasse, statu, dateChangement, nbreDeFois, rangCod, id, dateCreat, code, grpe, mle, motDePasse) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)", nativeQuery = true)
	void insert(String userName, String motPasse, String statu, Date dateChangement, Short nbreDeFois, Integer rangCod, Integer id, Date dateCreat, String code, String grpe, Long mle, String motDePasse);
	
	@Modifying
	@Query(value = "UPDATE AccesCode SET motDePasse=?1, statu=?2, dateChangement=?3, nbreDeFois=?4, id=?5, code=?6, grpe=?7, mle=?8 WHERE userName=?9", nativeQuery = true)
	void update(String motDePasse, String statu, Date dateChangement, Short nbreDeFois, Integer id, String code, String grpe, Long mle, String userName);

	public List<AccesCode> findByAccesCodeNiveau(AccesCodeNiveau accesCodeNiveau);
	
	@Query(value = "SELECT new com.sigep.gbc.dto.AccesCodeAgentDto("
			+ " ac.userName,"
			+ " ac.motPasse,"
			+ " ac.motDePasse,"
			+ " ac.statu,"
			+ " ac.dateChangement,"
			+ " ac.nbreDeFois,"
			+ " ac.rangCod,"
			+ " ac.id,"
			+ " ac.dateCreat,"
			+ " ac.accesCodeNiveau.code,"
			+ " ac.grpeCode.grpe,"
			+ " a.mle,"
			+ " a.nom,"
			+ " a.prenom,"
			+ " a.sexe,"
			+ " a.signataire,"
			+ " a.titreHonoSign,"
			+ " a.directionService.idService)"
			+ " FROM AccesCode ac INNER JOIN Agents a ON ac.agents.mle=a.mle")
	public List<AccesCodeAgentDto> getUtilisateur();
}
