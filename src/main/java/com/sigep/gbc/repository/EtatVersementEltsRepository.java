package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.EtatVersementElts;

@Repository
public interface EtatVersementEltsRepository extends JpaRepository<EtatVersementElts, Integer>{

}
