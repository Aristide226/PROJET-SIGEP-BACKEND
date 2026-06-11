package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sigep.gbc.entity.CompteMouvTypOp;

@Repository
public interface CompteMouvTypOpRepository extends JpaRepository<CompteMouvTypOp, String>{

}
