package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.CodModPass;

@Repository
public interface CodModPassRepository extends JpaRepository<CodModPass, String>{

}
