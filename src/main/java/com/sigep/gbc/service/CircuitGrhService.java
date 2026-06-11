package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.entity.CircuitGrh;


@Service
public interface CircuitGrhService {
	public CircuitGrh add(CircuitGrh circuitGrh);
	public List<CircuitGrh> getAll();
	public CircuitGrh get(int id);
	public CircuitGrh getById(int id);
	public CircuitGrh delete(int id);
	public CircuitGrh edit(int id, CircuitGrh circuitGrh);
}
