package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigep.gbc.entity.ChequesVirements;
import com.sigep.gbc.entity.ChequesVirementsId;

public interface ChequesVirementsRepository extends JpaRepository<ChequesVirements, ChequesVirementsId>{

}
