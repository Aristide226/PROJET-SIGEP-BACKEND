package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CodSourceFin;

@Repository
public interface CodSourceFinRepository extends JpaRepository<CodSourceFin, String>{

}
