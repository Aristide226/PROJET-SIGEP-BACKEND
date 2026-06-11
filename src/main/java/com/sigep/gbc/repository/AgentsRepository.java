package com.sigep.gbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.Agents;

@Repository
public interface AgentsRepository extends JpaRepository<Agents, Long>{

}
