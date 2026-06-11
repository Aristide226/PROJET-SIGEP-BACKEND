package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Integer>{

}
