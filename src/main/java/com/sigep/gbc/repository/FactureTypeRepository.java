package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.FactureType;

@Repository
public interface FactureTypeRepository extends JpaRepository<FactureType, String>{

}
