package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Justificatif;

@Repository
public interface JustificatifRepository extends JpaRepository<Justificatif, String>{

}
