package com.sigep.gbc.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.view.entity.FournisseursView;

@Repository
public interface FournisseursViewRepository extends JpaRepository<FournisseursView, Long>{

}
