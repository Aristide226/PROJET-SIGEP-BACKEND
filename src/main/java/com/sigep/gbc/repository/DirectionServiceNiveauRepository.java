package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.DirectionServiceNiveau;

@Repository
public interface DirectionServiceNiveauRepository extends JpaRepository<DirectionServiceNiveau, Integer>{

}
