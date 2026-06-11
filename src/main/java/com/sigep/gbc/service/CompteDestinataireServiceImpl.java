package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.CompteDestinataireInstitutFinAgenceDto;
import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.CompteDestinataireRequestDto;
import com.sigep.gbc.dto.responseDto.CompteDestinataireResponseDto;
import com.sigep.gbc.entity.CompteDestinataire;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.InstitutFinAgence;
import com.sigep.gbc.entity.InstitutFinancier;
import com.sigep.gbc.entity.TiersCaissePop;
import com.sigep.gbc.repository.CompteDestinataireRepository;
import com.sigep.gbc.repository.LiquidationRepository;
import com.sigep.gbc.repository.MandatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompteDestinataireServiceImpl implements CompteDestinataireService {
	
	private final CompteDestinataireRepository repository;
	private final TiersCaissePopService tiersCaissePopService;
	private final DestinatairesService destinatairesService;
	private final InstitutFinancierService institutFinancierService;
	private final InstitutFinAgenceService institutFinAgenceService;
	private final MandatsRepository mandatsRepository;
	private final LiquidationRepository liquidationRepository;
	
	@Override
	@Transactional("gbcTransactionManager")
	public CompteDestinataireResponseDto add(CompteDestinataireRequestDto compteDestinataireRequestDto) {
		CompteDestinataire entity = new CompteDestinataire();
		entity.setCodeBanque(compteDestinataireRequestDto.getCodeBanque());
		entity.setCodeAgence(compteDestinataireRequestDto.getCodeAgence());
		entity.setNumCompte(compteDestinataireRequestDto.getNumCompte());
		entity.setCleRib(compteDestinataireRequestDto.getCleRib());
		entity.setCaissePop(compteDestinataireRequestDto.getCaissePop());
		entity.setNumCaissePop(compteDestinataireRequestDto.getNumCaissePop());
		entity.setCodeBic(compteDestinataireRequestDto.getCodeBic());
		entity.setIban(compteDestinataireRequestDto.getIban());
		entity.setCodeAgence(compteDestinataireRequestDto.getCodeAgence());
		
		if (compteDestinataireRequestDto.getIdCaissePop() == null) {
			throw new IllegalArgumentException("CompteDestinataire need a TiersCaissePop");
		}
		TiersCaissePop tiersCaissePop = tiersCaissePopService.get(compteDestinataireRequestDto.getIdCaissePop());
		entity.setTiersCaissePop(tiersCaissePop);
		
		if (compteDestinataireRequestDto.getIdDest() == null) {
			throw new IllegalArgumentException("CompteDestinataire need a Destinataires");
		}
		Destinataires destinataires = destinatairesService.get(compteDestinataireRequestDto.getIdDest());
		entity.setDestinataires(destinataires);
		
		if (compteDestinataireRequestDto.getAbreviation() == null) {
			throw new IllegalArgumentException("CompteDestinataire need a InstitutFinancier");
		}
		InstitutFinancier institutFinancier = institutFinancierService.get(compteDestinataireRequestDto.getAbreviation());
		entity.setInstitutFinancier(institutFinancier);
		
		if (compteDestinataireRequestDto.getCodeAgence() == null) {
			throw new IllegalArgumentException("CompteDestinataire need a InstitutFinAgence");
		}
		InstitutFinAgence institutFinAgence = institutFinAgenceService.get(compteDestinataireRequestDto.getIdAgence());
		entity.setInstitutFinAgence(institutFinAgence);
		
		repository.save(entity);
		return GbcMapper2.cdToCdResponseDto(entity);
	}
	
	@Override
	public List<CompteDestinataireResponseDto> getAll() {
		List<CompteDestinataire> list = repository.findAll();
		return list
				.stream().map(element  -> {
					CompteDestinataireResponseDto dto = GbcMapper2.cdToCdResponseDto(element);
					dto.setIsUsed(isUsed(element.getId()));
					return dto;
				}).collect(Collectors.toList());
	}
	
	@Override
	public CompteDestinataire get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("CompteDestinataire with id: " + id + " could not be found"));
	}
	
	@Override
	public CompteDestinataireResponseDto getById(String id) {
		CompteDestinataire entity = get(id);
		CompteDestinataireResponseDto dto = GbcMapper2.cdToCdResponseDto(entity);
		dto.setIsUsed(isUsed(id));
		return dto;
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public CompteDestinataireResponseDto delete(String id) {
		if (isUsed(id)) {
			throw new IllegalStateException("CompteDestinataire with id: " + id + " is used. Can not delete");
		}
		CompteDestinataire entity = get(id);
		repository.delete(entity);
		return GbcMapper2.cdToCdResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public CompteDestinataireResponseDto edit(String id, CompteDestinataireRequestDto compteDestinataireRequestDto) {
		CompteDestinataire entity = get(id);
		entity.setCodeBanque(compteDestinataireRequestDto.getCodeBanque());
		entity.setCodeAgence(compteDestinataireRequestDto.getCodeAgence());
		entity.setNumCompte(compteDestinataireRequestDto.getNumCompte());
		entity.setCleRib(compteDestinataireRequestDto.getCleRib());
		entity.setCaissePop(compteDestinataireRequestDto.getCaissePop());
		entity.setNumCaissePop(compteDestinataireRequestDto.getNumCaissePop());
		entity.setCodeBic(compteDestinataireRequestDto.getCodeBic());
		entity.setIban(compteDestinataireRequestDto.getIban());
		entity.setCodeAgence(compteDestinataireRequestDto.getCodeAgence());
		
		if (compteDestinataireRequestDto.getIdCaissePop() != null) {
			TiersCaissePop tiersCaissePop = tiersCaissePopService.get(compteDestinataireRequestDto.getIdCaissePop());
			entity.setTiersCaissePop(tiersCaissePop);
		}
		
		if (compteDestinataireRequestDto.getIdDest() != null) {
			Destinataires destinataires = destinatairesService.get(compteDestinataireRequestDto.getIdDest());
			entity.setDestinataires(destinataires);
		}
		
		if (compteDestinataireRequestDto.getAbreviation() != null) {
			InstitutFinancier institutFinancier = institutFinancierService.get(compteDestinataireRequestDto.getAbreviation());
			entity.setInstitutFinancier(institutFinancier);
		}
		
		if (compteDestinataireRequestDto.getCodeAgence() != null) {
			InstitutFinAgence institutFinAgence = institutFinAgenceService.get(compteDestinataireRequestDto.getIdAgence());
			entity.setInstitutFinAgence(institutFinAgence);
		}
		
		return GbcMapper2.cdToCdResponseDto(entity);
	}

	@Override
	public List<CompteDestinataireInstitutFinAgenceDto> getByDestinataires(Long idDest) {
		return repository.getByDestinataires(idDest);
	}

	@Override
	public boolean isUsed(String id) {
		CompteDestinataire entity = get(id);
		return mandatsRepository.existsByCompteDestinataire(entity) || liquidationRepository.existsByCompteDestinataire(entity);
	}
}
