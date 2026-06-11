package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.MandatsModePaie;

@Repository
public interface MandatsModePaieRepository extends JpaRepository<MandatsModePaie, String>{

}
