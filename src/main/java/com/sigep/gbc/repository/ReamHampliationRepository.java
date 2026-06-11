package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.ReamHampliation;
import com.sigep.gbc.entity.ReamHampliationId;

@Repository
public interface ReamHampliationRepository extends JpaRepository<ReamHampliation, ReamHampliationId>{

}
