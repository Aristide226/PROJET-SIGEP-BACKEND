package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.TypesFrais;

@Repository
public interface TypesFraisRepository extends JpaRepository<TypesFrais, Integer>{

}
