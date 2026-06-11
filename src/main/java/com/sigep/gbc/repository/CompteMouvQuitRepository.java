package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CompteMouvQuit;

@Repository
public interface CompteMouvQuitRepository extends JpaRepository<CompteMouvQuit, Long>{

}
