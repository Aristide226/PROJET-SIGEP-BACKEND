package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.BordTitre;
import com.sigep.gbc.entity.BordTitreId;

@Repository
public interface BordTitreRepository extends JpaRepository<BordTitre, BordTitreId>{

}
