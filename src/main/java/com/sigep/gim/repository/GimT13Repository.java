package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.T13;

@Repository
public interface GimT13Repository extends JpaRepository<T13, String>{
	
}
