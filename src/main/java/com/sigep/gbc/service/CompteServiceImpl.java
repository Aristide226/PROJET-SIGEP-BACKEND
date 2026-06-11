package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.CompteDto;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.entity.Compte;
import com.sigep.gbc.entity.PlanComptable;
import com.sigep.gbc.repository.CompteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService{

	private final CompteRepository repository;
	private final PlanComptableService pcService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public CompteDto add(CompteDto compteDto) {
		Compte compte = new Compte();
		
		if (compteDto.getCodCpte() == null) {
			throw new IllegalArgumentException("Compte need a PlanComptable");
		}
		PlanComptable planComptable = pcService.get(compteDto.getCodCpte());
		compte.setPlanComptable(planComptable);
		compte.setNumCompte(compteDto.getNumCompte());
		compte.setIntitule(compteDto.getIntitule());
		compte.setAttente(compteDto.getAttente());
		compte.setAbreviation(compteDto.getAbreviation());
		compte.setCodeBanque(compteDto.getCodeBanque());
		compte.setCodeAgence(compteDto.getCodeAgence());
		compte.setCleRib(compteDto.getCleRib());
		compte.setCaissePop(compteDto.getCaissePop());
		compte.setNumCaissePop(compteDto.getNumCaissePop());
		compte.setSolde(compteDto.getSolde());
		compte.setLibCompte(compteDto.getLibCompte());
		
		repository.save(compte);
		return GbcMapper.cToCResponseDto(compte);
	}
	
	@Override
	public List<CompteDto> getAll() {
		List<Compte> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.cToCResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Compte get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Compte with id: " + id + " could not be found"));
	}
	
	@Override
	public CompteDto getById(String id) {
		Compte entity = get(id);
		return GbcMapper.cToCResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public CompteDto delete(String id) {
		Compte entity = get(id);
		repository.delete(entity);
		return GbcMapper.cToCResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public CompteDto edit(String id, CompteDto compteDto) {
		Compte compte = get(id);
		compte.setNumCompte(compteDto.getNumCompte());
		compte.setIntitule(compteDto.getIntitule());
		compte.setAttente(compteDto.getAttente());
		compte.setAbreviation(compteDto.getAbreviation());
		compte.setCodeBanque(compteDto.getCodeBanque());
		compte.setCodeAgence(compteDto.getCodeAgence());
		compte.setCleRib(compteDto.getCleRib());
		compte.setCaissePop(compteDto.getCaissePop());
		compte.setNumCaissePop(compteDto.getNumCaissePop());
		compte.setSolde(compteDto.getSolde());
		compte.setLibCompte(compteDto.getLibCompte());
		return GbcMapper.cToCResponseDto(compte);
	}
	
}
