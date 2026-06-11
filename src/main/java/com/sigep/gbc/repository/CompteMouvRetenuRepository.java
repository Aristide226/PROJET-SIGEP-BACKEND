package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CompteMouvRetenu;
import com.sigep.gbc.entity.CompteMouvRetenuId;

@Repository
public interface CompteMouvRetenuRepository extends JpaRepository<CompteMouvRetenu, CompteMouvRetenuId>{

}
