package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sigep.gbc.entity.NomenclatureD;

public interface NomenclatureDRepository extends JpaRepository<NomenclatureD, String>{
	@Modifying
	@Query(value = "INSERT INTO NomenclatureD (numNo, titre, section, chap, art, parag, rub, intitule, Dot_Est_Exec) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
	void insert(String numNo, String titre, String section, String chap, String art, String parag, String rub, String intitule, Boolean dotEstExec);
	
	@Modifying
	@Query(value = "UPDATE NomenclatureD SET intitule=?1, Dot_Est_Exec=?2 WHERE numNo=?3", nativeQuery = true)
	void update(String intitule, Boolean dotEstExec, String numNo);
	
	@Query(value = "SELECT * FROM NomenclatureD WHERE Intitule NOT IN ('RECETTES', 'DEPENSES') AND Titre IN ('1', '2') ORDER BY Titre, Section, Chap, Art, Parag, CAST(Rub AS BIGINT)", nativeQuery = true)
	public List<NomenclatureD> getRecettesEtDepenses();
	
	@Query(value = "SELECT * FROM NomenclatureD WHERE chap IS NOT NULL AND titre=1 ORDER BY titre, section, chap, art, parag, CAST(Rub AS BIGINT)", nativeQuery = true)
	public List<NomenclatureD> getRecettes();
	
	@Query(value = "SELECT * FROM NomenclatureD WHERE chap IS NOT NULL AND titre=2 ORDER BY titre, section, chap, art, parag, CAST(Rub AS BIGINT)", nativeQuery = true)
	public List<NomenclatureD> getDepenses();
}
