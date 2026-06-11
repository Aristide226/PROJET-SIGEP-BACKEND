package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.ActeNature;

@Repository
public interface ActeNatureRepository extends JpaRepository<ActeNature, Integer>{

}
