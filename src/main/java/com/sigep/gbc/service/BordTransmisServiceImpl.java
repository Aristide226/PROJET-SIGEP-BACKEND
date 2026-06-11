package com.sigep.gbc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.model.InfosPourReceptionnerBordTransmis;
import com.sigep.gbc.dto.requestDto.BordTransmisRequestDto;
import com.sigep.gbc.dto.responseDto.BordTransmisResponseDto;
import com.sigep.gbc.entity.BordTransmis;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.entity.Mandats;
import com.sigep.gbc.entity.MotifsRejetDossier;
import com.sigep.gbc.repository.BordTransmisRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BordTransmisServiceImpl implements BordTransmisService{
	
	private final BordTransmisRepository repository;
	private final BudgetTypeService btService;
	private final EngagementsService eService;
	private final MandatsService mService;
	private final MotifsRejetDossierService motifsRejetDossierService;

	@Override
	@Transactional("gbcTransactionManager")
	public BordTransmisResponseDto add(BordTransmisRequestDto bordTransmisRequestDto) {
		BordTransmis entity = new BordTransmis();
		entity.setCodBord(repository.getCodBord());
		entity.setGestion(bordTransmisRequestDto.getGestion());
		entity.setDossier(bordTransmisRequestDto.getDossier());
		entity.setDateCreation(new Date());
		entity.setExpeditaire(bordTransmisRequestDto.getExpeditaire());
		if (bordTransmisRequestDto.getExpeditaire().equals("AD")) entity.setDestinataire("CF");
		if (bordTransmisRequestDto.getExpeditaire().equals("CF")) entity.setDestinataire("AD");
		if (bordTransmisRequestDto.getExpeditaire().equals("AC")) entity.setDestinataire("OR");
		if (bordTransmisRequestDto.getExpeditaire().equals("OR")) entity.setDestinataire("AC");
		entity.setIdLogin(bordTransmisRequestDto.getIdLogin());
		entity.setDateReception(bordTransmisRequestDto.getDateReception());
		entity.setIdLoginRecep(bordTransmisRequestDto.getIdLoginRecep());
		entity.setNumero(repository.getNumero(bordTransmisRequestDto.getGestion(), bordTransmisRequestDto.getIdBudget(), bordTransmisRequestDto.getExpeditaire()));
		entity.setIdentiteRecept(bordTransmisRequestDto.getIdentiteRecept());
		
		if (bordTransmisRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("BordTransmis need a BudgetType");
		}
		BudgetType budgetType = btService.get(bordTransmisRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		if (!bordTransmisRequestDto.getNumBesBordTransEng().isEmpty()) {
			List<Engagements> engagementsBordTransEng = new ArrayList<>();
			for (Long numBe: bordTransmisRequestDto.getNumBesBordTransEng()) {
				Engagements engagement = eService.get(numBe);
				engagementsBordTransEng.add(engagement);
			}
			entity.setEngagementsBordTransEng(engagementsBordTransEng);
		} 
		
		if (!bordTransmisRequestDto.getNumMandsBordTransMand().isEmpty()) {
			List<Mandats> mandatsBordTransMand = new ArrayList<>();
			for (Long numMand: bordTransmisRequestDto.getNumMandsBordTransMand()) {
				Mandats mandat = mService.get(numMand);
				mandatsBordTransMand.add(mandat);
			}
			entity.setMandatsBordTransMand(mandatsBordTransMand);
		}
		
		if (!bordTransmisRequestDto.getNumMandsBordTransLiq().isEmpty()) {
			List<Mandats> mandatsBordTransLiq = new ArrayList<>();
			for (Long numMand: bordTransmisRequestDto.getNumMandsBordTransLiq()) {
				Mandats mandat = mService.get(numMand);
				mandatsBordTransLiq.add(mandat);
			}
			entity.setMandatsBordTransLiq(mandatsBordTransLiq);
		} 
		
		if (!bordTransmisRequestDto.getIdMotifs().isEmpty()) {
			List<MotifsRejetDossier> motifsRejetDossiers = new ArrayList<>();
			for (String idMotif: bordTransmisRequestDto.getIdMotifs()) {
				MotifsRejetDossier motifsRejetDossier = motifsRejetDossierService.get(idMotif);
				motifsRejetDossiers.add(motifsRejetDossier);
			}
			entity.setMotifsRejetDossiers(motifsRejetDossiers);
		} 
		
		repository.save(entity);
		return GbcMapper.bordtToBordtResponseDto(entity);
	}

	@Override
	public List<BordTransmisResponseDto> getAll() {
		List<BordTransmis> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.bordtToBordtResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public BordTransmis get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("BordTransmis with id: " + id + " could not be found"));
	}

	@Override
	public BordTransmisResponseDto getById(Long id) {
		BordTransmis entity = get(id);
		return GbcMapper.bordtToBordtResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BordTransmisResponseDto delete(Long id) {
		BordTransmis entity = get(id);
		repository.delete(entity);
		return GbcMapper.bordtToBordtResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BordTransmisResponseDto edit(Long id, BordTransmisRequestDto bordTransmisRequestDto) {
		BordTransmis entity = get(id);
		entity.setGestion(bordTransmisRequestDto.getGestion());
		entity.setDossier(bordTransmisRequestDto.getDossier());
		entity.setExpeditaire(bordTransmisRequestDto.getExpeditaire());
		if (bordTransmisRequestDto.getExpeditaire().equals("AD")) entity.setDestinataire("CF");
		if (bordTransmisRequestDto.getExpeditaire().equals("CF")) entity.setDestinataire("AD");
		entity.setIdLogin(bordTransmisRequestDto.getIdLogin());
		entity.setDateReception(bordTransmisRequestDto.getDateReception());
		entity.setIdLoginRecep(bordTransmisRequestDto.getIdLoginRecep());
		entity.setIdentiteRecept(bordTransmisRequestDto.getIdentiteRecept());
		
		if (!bordTransmisRequestDto.getNumBesBordTransEng().isEmpty()) {
			List<Engagements> engagementsBordTransEng = new ArrayList<>();
			for (Long numBe: bordTransmisRequestDto.getNumBesBordTransEng()) {
				Engagements engagement = eService.get(numBe);
				engagementsBordTransEng.add(engagement);
			}
			entity.setEngagementsBordTransEng(engagementsBordTransEng);
		} 
		
		if (!bordTransmisRequestDto.getNumMandsBordTransMand().isEmpty()) {
			List<Mandats> mandatsBordTransMand = new ArrayList<>();
			for (Long numMand: bordTransmisRequestDto.getNumMandsBordTransMand()) {
				Mandats mandat = mService.get(numMand);
				mandatsBordTransMand.add(mandat);
			}
			entity.setMandatsBordTransMand(mandatsBordTransMand);
		}
		
		if (!bordTransmisRequestDto.getNumMandsBordTransLiq().isEmpty()) {
			List<Mandats> mandatsBordTransLiq = new ArrayList<>();
			for (Long numMand: bordTransmisRequestDto.getNumMandsBordTransLiq()) {
				Mandats mandat = mService.get(numMand);
				mandatsBordTransLiq.add(mandat);
			}
			entity.setMandatsBordTransLiq(mandatsBordTransLiq);
		}
		
		return GbcMapper.bordtToBordtResponseDto(entity);
	}

	@Override
	public List<BordTransmisResponseDto> getByGestionAndIdBudgetAndExpeditaire(Short gestion, Integer idBudget, String expeditaire) {
		List<BordTransmis> list = repository.getByGestionAndIdBudgetAndExpeditaire(gestion, idBudget, expeditaire);
		return list
				.stream().map(element  -> GbcMapper.bordtToBordtResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean receptionner(InfosPourReceptionnerBordTransmis infosPourReceptionnerBordTransmis) {
		try {
			for (Long codBord : infosPourReceptionnerBordTransmis.getIds()) {
				BordTransmis entity = get(codBord);
				entity.setDateReception(infosPourReceptionnerBordTransmis.getDate());
				entity.setIdLoginRecep(infosPourReceptionnerBordTransmis.getIdUser());	
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	
}
