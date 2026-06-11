package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.TitreInscritPour;
import com.sigep.gbc.entity.TitreInscritPourId;

@Repository
public interface TitreInscritPourRepository extends JpaRepository<TitreInscritPour, TitreInscritPourId>{

}
