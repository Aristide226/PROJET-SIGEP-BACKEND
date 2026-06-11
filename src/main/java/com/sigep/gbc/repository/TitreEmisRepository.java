package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.TitreEmis;

@Repository
public interface TitreEmisRepository extends JpaRepository<TitreEmis, String>{

}
