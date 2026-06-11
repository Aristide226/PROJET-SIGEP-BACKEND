package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sigep.gbc.entity.CompteMouvDebit;
import com.sigep.gbc.entity.CompteMouvDebitId;

@Repository
public interface CompteMouvDebitRepository extends JpaRepository<CompteMouvDebit, CompteMouvDebitId>{

}
