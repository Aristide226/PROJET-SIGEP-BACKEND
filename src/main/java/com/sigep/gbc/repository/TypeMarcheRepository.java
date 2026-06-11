package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.TypeMarche;

@Repository
public interface TypeMarcheRepository extends JpaRepository<TypeMarche, String>{

}
