package com.sigep.grh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.grh.entity.GrpeCode;

@Repository
public interface GrhGrpeCodeRepository extends JpaRepository<GrpeCode, String> {

}
