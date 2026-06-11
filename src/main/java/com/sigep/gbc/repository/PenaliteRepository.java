package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Penalite;

@Repository
public interface PenaliteRepository extends JpaRepository<Penalite, String>{

}
