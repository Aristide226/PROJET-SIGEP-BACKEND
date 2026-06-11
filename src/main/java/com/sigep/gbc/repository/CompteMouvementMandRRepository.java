package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sigep.gbc.entity.CompteMouvementMandR;

@Repository
public interface CompteMouvementMandRRepository extends JpaRepository<CompteMouvementMandR, Long>{

}
