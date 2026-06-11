package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sigep.gbc.entity.CompteMouvement;

@Repository
public interface CompteMouvementRepository extends JpaRepository<CompteMouvement, Long>{

}
