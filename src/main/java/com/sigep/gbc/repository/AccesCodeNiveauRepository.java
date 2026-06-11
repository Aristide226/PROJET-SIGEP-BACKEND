package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.AccesCodeNiveau;

@Repository
public interface AccesCodeNiveauRepository extends JpaRepository<AccesCodeNiveau, String>{

}
