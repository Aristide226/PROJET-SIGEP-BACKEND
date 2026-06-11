package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.TitreDetail;

@Repository
public interface TitreDetailRepository extends JpaRepository<TitreDetail, Long>{
	@Query(value = "SELECT SUM(montant) FROM TitreDetail WHERE gestion=?1 AND codBud=?2")
	public Long getTitreMontant(Short gestion, String codBud);
}
