package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Suspension;

@Repository
public interface SuspensionRepository extends JpaRepository<Suspension, String>{

}
