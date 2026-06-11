package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.EleveType;

@Repository
public interface EleveTypeRepository extends JpaRepository<EleveType, String>{

}
