package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.FraisInscription;
import com.sigep.gbc.entity.FraisInscriptionId;

@Repository
public interface FraisInscriptionRepository extends JpaRepository<FraisInscription, FraisInscriptionId>{

}
