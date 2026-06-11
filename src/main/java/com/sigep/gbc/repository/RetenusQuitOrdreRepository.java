package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.RetenusQuitOrdre;

@Repository
public interface RetenusQuitOrdreRepository extends JpaRepository<RetenusQuitOrdre, String>{

}
