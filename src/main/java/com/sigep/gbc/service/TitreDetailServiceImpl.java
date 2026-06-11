package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.TitreDetailRequestDto;
import com.sigep.gbc.dto.responseDto.TitreDetailResponseDto;
import com.sigep.gbc.entity.Agents;
import com.sigep.gbc.entity.BordTransmis;
import com.sigep.gbc.entity.BordereauEmismandats;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.EtatDossier;
import com.sigep.gbc.entity.EtatTransmission;
import com.sigep.gbc.entity.TitreDetail;
import com.sigep.gbc.entity.TitreRegulApartir;
import com.sigep.gbc.repository.TitreDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TitreDetailServiceImpl implements TitreDetailService{
	
	private final TitreDetailRepository repository;
	private final AgentsService aService;
	private final BudgetTypeService btService;
	private final BudgetService bService;
	private final BordereauEmismandatsService bordereauEmismandatsService;
	private final BordTransmisService bordTransmisService;
	private final EtatDossierService etatDossierService;
	private final EtatTransmissionService etatTransmissionService;
	private final TitreRegulApartirService titreRegulApartirService;
	

	@Override
	@Transactional("gbcTransactionManager")
	public TitreDetailResponseDto add(TitreDetailRequestDto titreDetailRequestDto) {
		TitreDetail entity = new TitreDetail();
		entity.setIdDetailTitre(titreDetailRequestDto.getIdDetailTitre());
		entity.setMontant(titreDetailRequestDto.getMontant());
		entity.setGestion(titreDetailRequestDto.getGestion());
		entity.setDate(titreDetailRequestDto.getDate());
		entity.setReftitre(titreDetailRequestDto.getReftitre());
		entity.setIdLogin(titreDetailRequestDto.getIdLogin());
		entity.setDateEtat(titreDetailRequestDto.getDateEtat());
		entity.setNumero(titreDetailRequestDto.getNumero());
		entity.setNumAuto(titreDetailRequestDto.getNumAuto());
		entity.setTitreSignataire(titreDetailRequestDto.getTitreSignataire());
		entity.setNumComplema(titreDetailRequestDto.getNumComplema());
		entity.setDatePec(titreDetailRequestDto.getDatePec());
		entity.setReceptionne(titreDetailRequestDto.getReceptionne());
		entity.setDateValid(titreDetailRequestDto.getDateValid());
		
		if (titreDetailRequestDto.getMle() == null) {
			entity.setAgents(null);
		} else {
			Agents agents = aService.get(titreDetailRequestDto.getMle());
			entity.setAgents(agents);
		}
		
		if (titreDetailRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("TitreDetail need a IdBudget");
		}
		BudgetType budgetType = btService.get(titreDetailRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		if (titreDetailRequestDto.getCodBud() == null) {
			throw new IllegalArgumentException("TitreDetail need a Budget");
		}
		Budget budget = bService.get(titreDetailRequestDto.getCodBud());
		entity.setBudget(budget);
		
		if (titreDetailRequestDto.getIdBordEmis() == null) {
			entity.setBordereauEmismandats(null);
		} else {
			BordereauEmismandats bordereauEmismandats = bordereauEmismandatsService.get(titreDetailRequestDto.getIdBordEmis());
			entity.setBordereauEmismandats(bordereauEmismandats);
		}
		
		if (titreDetailRequestDto.getCodBord() == null) {
			entity.setBordTransmis(null);
		} else {
			BordTransmis bordTransmis = bordTransmisService.get(titreDetailRequestDto.getCodBord());
			entity.setBordTransmis(bordTransmis);
		}
		
		if (titreDetailRequestDto.getEtat() == null) {
			throw new IllegalArgumentException("TitreDetail need a EtatDossier");
		}
		EtatDossier etatDossier = etatDossierService.get(titreDetailRequestDto.getEtat());
		entity.setEtatDossier(etatDossier);
		
		if (titreDetailRequestDto.getIdEtatTrans() == null) {
			throw new IllegalArgumentException("TitreDetail need a EtatTransmission");
		}
		EtatTransmission etatTransmission = etatTransmissionService.get(titreDetailRequestDto.getIdEtatTrans());
		entity.setEtatTransmission(etatTransmission);
		
		if (titreDetailRequestDto.getIdApartir() == null) {
			throw new IllegalArgumentException("TitreDetail need a TitreRegulApartir");
		}
		TitreRegulApartir titreRegulApartir = titreRegulApartirService.get(titreDetailRequestDto.getIdApartir());
		entity.setTitreRegulApartir(titreRegulApartir);
		
		repository.save(entity);
		return GbcMapper.titreDetailToTitreDetailResponseDto(entity);
	}

	@Override
	public List<TitreDetailResponseDto> getAll() {
		List<TitreDetail> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.titreDetailToTitreDetailResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public TitreDetail get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("TitreDetail with id: " + id + " could not be found"));
	}

	@Override
	public TitreDetailResponseDto getById(Long id) {
		TitreDetail entity = get(id);
		return GbcMapper.titreDetailToTitreDetailResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public TitreDetailResponseDto delete(Long id) {
		TitreDetail entity = get(id);
		repository.delete(entity);
		return GbcMapper.titreDetailToTitreDetailResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public TitreDetailResponseDto edit(Long id, TitreDetailRequestDto titreDetailRequestDto) {
		TitreDetail entity = get(id);
		entity.setMontant(titreDetailRequestDto.getMontant());
		entity.setGestion(titreDetailRequestDto.getGestion());
		entity.setDate(titreDetailRequestDto.getDate());
		entity.setReftitre(titreDetailRequestDto.getReftitre());
		entity.setIdLogin(titreDetailRequestDto.getIdLogin());
		entity.setDateEtat(titreDetailRequestDto.getDateEtat());
		entity.setNumero(titreDetailRequestDto.getNumero());
		entity.setNumAuto(titreDetailRequestDto.getNumAuto());
		entity.setTitreSignataire(titreDetailRequestDto.getTitreSignataire());
		entity.setNumComplema(titreDetailRequestDto.getNumComplema());
		entity.setDatePec(titreDetailRequestDto.getDatePec());
		entity.setReceptionne(titreDetailRequestDto.getReceptionne());
		entity.setDateValid(titreDetailRequestDto.getDateValid());
		
		if (titreDetailRequestDto.getMle() == null) {
			entity.setAgents(null);
		} else {
			Agents agents = aService.get(titreDetailRequestDto.getMle());
			entity.setAgents(agents);
		}
		
		if (titreDetailRequestDto.getIdBudget() != null) {
			BudgetType budgetType = btService.get(titreDetailRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		if (titreDetailRequestDto.getCodBud() != null) {
			Budget budget = bService.get(titreDetailRequestDto.getCodBud());
			entity.setBudget(budget);
		}
		
		if (titreDetailRequestDto.getIdBordEmis() == null) {
			entity.setBordereauEmismandats(null);
		} else {
			BordereauEmismandats bordereauEmismandats = bordereauEmismandatsService.get(titreDetailRequestDto.getIdBordEmis());
			entity.setBordereauEmismandats(bordereauEmismandats);
		}
		
		if (titreDetailRequestDto.getCodBord() == null) {
			entity.setBordTransmis(null);
		} else {
			BordTransmis bordTransmis = bordTransmisService.get(titreDetailRequestDto.getCodBord());
			entity.setBordTransmis(bordTransmis);
		}
		
		if (titreDetailRequestDto.getEtat() != null) {
			EtatDossier etatDossier = etatDossierService.get(titreDetailRequestDto.getEtat());
			entity.setEtatDossier(etatDossier);
		}
		
		if (titreDetailRequestDto.getIdEtatTrans() != null) {
			EtatTransmission etatTransmission = etatTransmissionService.get(titreDetailRequestDto.getIdEtatTrans());
			entity.setEtatTransmission(etatTransmission);
		}
		
		if (titreDetailRequestDto.getIdApartir() != null) {
			TitreRegulApartir titreRegulApartir = titreRegulApartirService.get(titreDetailRequestDto.getIdApartir());
			entity.setTitreRegulApartir(titreRegulApartir);
		}
		
		return GbcMapper.titreDetailToTitreDetailResponseDto(entity);
	}
}
