package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PjengBrseZz;
import com.sigep.gbc.entity.PjengBrseZzId;

@Repository
public interface PjengBrseZzRepository extends JpaRepository<PjengBrseZz, PjengBrseZzId>{

}
