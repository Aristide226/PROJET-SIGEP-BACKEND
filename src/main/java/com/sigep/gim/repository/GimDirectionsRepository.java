package com.sigep.gim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gim.entity.Directions;

@Repository
public interface GimDirectionsRepository extends JpaRepository<Directions, Integer>{

}
