package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.FactureDetail;

@Repository
public interface FactureDetailRepository extends JpaRepository<FactureDetail, String>{

}
