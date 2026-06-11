package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.DebiteurEleve;

@Repository
public interface DebiteurEleveRepository extends JpaRepository<DebiteurEleve, Long>{

}
