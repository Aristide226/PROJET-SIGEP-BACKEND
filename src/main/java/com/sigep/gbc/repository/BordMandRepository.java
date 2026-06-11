package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sigep.gbc.entity.BordMand;
import com.sigep.gbc.entity.BordMandId;

@Repository
public interface BordMandRepository extends JpaRepository<BordMand, BordMandId>{
	@Query(value = "SELECT * FROM BordMand WHERE idbord=?1", nativeQuery = true)
	List<BordMand> getByIdBord(String idbord);
}
