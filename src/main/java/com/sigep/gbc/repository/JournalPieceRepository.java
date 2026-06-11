package com.sigep.gbc.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.JournalPiece;

@Repository
public interface JournalPieceRepository extends JpaRepository<JournalPiece, BigInteger>{

}
