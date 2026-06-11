package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.ReamHvisa;
import com.sigep.gbc.entity.ReamHvisaId;

@Repository
public interface ReamHvisaRepository extends JpaRepository<ReamHvisa, ReamHvisaId>{

}
