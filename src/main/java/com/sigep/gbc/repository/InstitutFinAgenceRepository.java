package com.sigep.gbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.InstitutFinAgence;
import com.sigep.gbc.entity.InstitutFinancier;

@Repository
public interface InstitutFinAgenceRepository extends JpaRepository<InstitutFinAgence, String>{
	List<InstitutFinAgence> findByInstitutFinancier(InstitutFinancier institutFinancier);
}
