package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.TitreEmisCloture;

@Repository
public interface TitreEmisClotureRepository extends JpaRepository<TitreEmisCloture, String>{

}
