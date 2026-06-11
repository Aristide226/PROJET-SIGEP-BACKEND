package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.RecouvrementBilletage;
import com.sigep.gbc.entity.RecouvrementBilletageId;

@Repository
public interface RecouvrementBilletageRepository extends JpaRepository<RecouvrementBilletage, RecouvrementBilletageId>{

}
