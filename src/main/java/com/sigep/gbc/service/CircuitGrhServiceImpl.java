package com.sigep.gbc.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.entity.CircuitGrh;
import com.sigep.gbc.repository.CircuitGrhRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CircuitGrhServiceImpl implements CircuitGrhService{

	private final CircuitGrhRepository repository;
	
	@Override
	@Transactional("gbcTransactionManager")
	public CircuitGrh add(CircuitGrh circuitGrh) {
		CircuitGrh circuitGrh2 = new CircuitGrh();
		circuitGrh2.setIdCircuitGrh(circuitGrh.getIdCircuitGrh());
		circuitGrh2.setDescriptionCircuit(circuitGrh.getDescriptionCircuit());
		return repository.save(circuitGrh2);
	}

	@Override
	public List<CircuitGrh> getAll() {
		List<CircuitGrh> circuitGrhs = repository.findAll();
		return circuitGrhs;
	}

	@Override
	public CircuitGrh get(int id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CircuitGrh with id: " + id + " could not be found"));
	}

	@Override
	public CircuitGrh getById(int id) {
		CircuitGrh circuitGrh = get(id);
		return circuitGrh;
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CircuitGrh delete(int id) {
		CircuitGrh circuitGrh = get(id);
		repository.delete(circuitGrh);
		return circuitGrh;
	}

	@Override
	@Transactional("gbcTransactionManager")
	public CircuitGrh edit(int id, CircuitGrh circuitGrh) {
		CircuitGrh circuitGrh2 = get(id);
		circuitGrh2.setDescriptionCircuit(circuitGrh.getDescriptionCircuit());
		return circuitGrh2;
	}

}
