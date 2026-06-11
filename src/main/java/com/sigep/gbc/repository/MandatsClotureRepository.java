package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.MandatsCloture;

@Repository
public interface MandatsClotureRepository extends JpaRepository<MandatsCloture, Long>{

}
