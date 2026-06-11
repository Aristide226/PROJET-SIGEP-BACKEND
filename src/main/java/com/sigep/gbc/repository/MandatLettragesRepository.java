package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.MandatLettrages;

@Repository
public interface MandatLettragesRepository extends JpaRepository<MandatLettrages, String>{

}
