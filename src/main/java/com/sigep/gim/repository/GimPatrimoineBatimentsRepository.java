package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.PatrimoineBatiments;

@Repository
public interface GimPatrimoineBatimentsRepository extends JpaRepository<PatrimoineBatiments, String>{
	
}
