package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Decision;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, String>{

}
