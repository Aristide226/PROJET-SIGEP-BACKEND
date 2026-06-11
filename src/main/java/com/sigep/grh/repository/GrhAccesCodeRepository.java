package com.sigep.grh.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.grh.entity.AccesCode;
import com.sigep.grh.entity.AccesCodeNiveau;

@Repository
public interface GrhAccesCodeRepository extends JpaRepository<AccesCode, String>{
	
	@Query(value = "SELECT MAX(rangCod) FROM AccesCode WHERE code=?1")
	public Integer getMaxRangCod(String code);
	
	@Modifying
	@Query(value = "INSERT INTO AccesCode (userName, motPasse, statu, dateChangement, nbreDeFois, rangCod, id, code, grpe, mle, motDePasse) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)", nativeQuery = true)
	void insert(String userName, String motPasse, String statu, Date dateChangement, Short nbreDeFois, Integer rangCod, Integer id, String code, String grpe, Integer mle, String motDePasse);
	
	@Modifying
	@Query(value = "UPDATE AccesCode SET motDePasse=?1, statu=?2, dateChangement=?3, nbreDeFois=?4, id=?5, code=?6, grpe=?7, mle=?8 WHERE userName=?9", nativeQuery = true)
	void update(String motDePasse, String statu, Date dateChangement, Short nbreDeFois, Integer id, String code, String grpe, Integer mle, String userName);
	
	public List<AccesCode> findByAccesCodeNiveau(AccesCodeNiveau accesCodeNiveau);
}
