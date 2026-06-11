package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.MandatPec;
import com.sigep.gbc.entity.MandatPecId;

@Repository
public interface MandatPecRepository extends JpaRepository<MandatPec, MandatPecId>{

}
