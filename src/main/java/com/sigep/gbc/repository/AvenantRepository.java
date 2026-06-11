package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Avenant;

@Repository
public interface AvenantRepository extends JpaRepository<Avenant, Integer>{

}
