package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.PieceJustifComplement;
import com.sigep.gbc.entity.PieceJustifComplementId;

@Repository
public interface PjcomplementRepository extends JpaRepository<PieceJustifComplement, PieceJustifComplementId>{

}
