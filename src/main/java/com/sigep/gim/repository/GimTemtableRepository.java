package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Temtable;

@Repository
public interface GimTemtableRepository extends JpaRepository<Temtable, String>{
	
}
