package com.sigep.gbc.view.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sigep.gbc.view.entity.LiquidationView;

@Repository
public interface LiquidationViewRepository extends JpaRepository<LiquidationView, Long>{
	public List<LiquidationView> getByGestionAndIdBudgetOrderByNumBlDesc(Short gestion, Integer idBudget);
	
	// RECU QUE L'ON PEUT MODIFIER : SOIT IL N'A PAS UN MANDAT SOIT IL A UN MANDAT AVEC L'ETAT M0 OU M3
	@Query(value = "SELECT * FROM LiquidationView WHERE gestion=?1 AND idBudget=?2 AND (numMand IS NULL OR etatMand IN('M0','M3')) ORDER BY numBl DESC", nativeQuery = true)
	public List<LiquidationView> getReçuModifiables(Short gestion, Integer idBudget);
	
	// RECU A PARTIR DESQUELS ON PEUT CREER UNE LIQUIDATION
	@Query(value = "SELECT * FROM LiquidationView WHERE gestion=?1 AND idBudget=?2 AND numMand IS NULL ORDER BY numBl DESC", nativeQuery = true)
	public List<LiquidationView> getReçuSansMandats(Short gestion, Integer idBudget); 
	
	// LIQUIDATIONS QUE L'ON PEUT MODIFIER : RECU AVEC UN MANDAT A L'ETAT M0 OU M3
	@Query(value = "SELECT * FROM LiquidationView WHERE gestion=?1 AND idBudget=?2 AND (numMand IS NOT NULL AND etatMand IN('M0','M3')) ORDER BY numBe DESC", nativeQuery = true)
	public List<LiquidationView> getLiquidationModifiables(Short gestion, Integer idBudget);
	
	// TOUTES LES LIQUIDATION SELON GESTION, IDBUDGET ET ORDONNE SELON LE NUMERO DE L'ENGAGEMENT
	public List<LiquidationView> getByGestionAndIdBudgetOrderByNumBeDesc(Short gestion, Integer idBudget);
	
	// LIQUIDATIONS QUE L'ON PEUT VALIDER : RECU AVEC UN MANDAT A L'ETAT M0 OU RECU AVEC UN MANDAT A L'ETAT M3 ET idEtatTransLMand = 1 
	@Query(value = "SELECT * FROM LiquidationView WHERE gestion=?1 AND idBudget=?2 AND numMand IS NOT NULL AND etatMand='M0' UNION SELECT * FROM LiquidationView WHERE gestion=?1 AND idBudget=?2 AND numMand IS NOT NULL AND etatMand='M3' AND idEtatTransLMand=1 ORDER BY benum DESC, numBlMand DESC", nativeQuery = true)
	public List<LiquidationView> getLiquidationValidables(Short gestion, Integer idBudget);
	
	// LIQUIDATIONS QUE L'ON PEUT RETROGRADER : RECU AVEC UN MANDAT A L'ETAT M2 OU M3 ET idEtatTransLMand = 0
	@Query(value = "SELECT * FROM LiquidationView WHERE gestion=?1 AND idBudget=?2 AND idUser=?3 AND numMand IS NOT NULL AND idEtatTransLMand=0 AND etatMand IN ('M2', 'M3') ORDER BY benum DESC, numBlMand DESC", nativeQuery = true)
	public List<LiquidationView> getLiquidationRetrogradables(Short gestion, Integer idBudget, String idUser);
}
