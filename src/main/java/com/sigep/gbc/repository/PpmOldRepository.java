package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PpmOld;
import com.sigep.gbc.entity.PpmOldId;

@Repository
public interface PpmOldRepository extends JpaRepository<PpmOld, PpmOldId>{

}
