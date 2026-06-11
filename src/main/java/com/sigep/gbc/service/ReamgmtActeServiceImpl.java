package com.sigep.gbc.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.ReamgmtActeRequestDto;
import com.sigep.gbc.dto.responseDto.ReamgmtActeResponseDto;
import com.sigep.gbc.entity.ActeNature;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Gestion;
import com.sigep.gbc.entity.ReamgmtActe;
import com.sigep.gbc.repository.ReamgmtActeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReamgmtActeServiceImpl implements ReamgmtActeService{
	
	private final ReamgmtActeRepository repository;
	private final ActeNatureService acteNatureService;
	private final GestionService gestionService;
	private final BudgetTypeService budgetTypeService;
	private final BudgetModifActeService budgetModifActeService;
	private final DecimalFormat decFormat = new DecimalFormat("0000");
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamgmtActeResponseDto add(ReamgmtActeRequestDto reamgmtActeRequestDto) {
		ReamgmtActe entity = new ReamgmtActe();
		entity.setCodReam(budgetModifActeService.getCodReamCodBMA());
		entity.setDateSaisie(new Date());
		entity.setValide(reamgmtActeRequestDto.getValide());
		entity.setActe(reamgmtActeRequestDto.getActe());
		
		if (reamgmtActeRequestDto.getNumAuto() == true) {
			entity.setNumero(reamgmtActeRequestDto.getActeAn() + "-" + decFormat.format(repository.getActeNum(reamgmtActeRequestDto.getGestion(), reamgmtActeRequestDto.getActe())) + "/" + reamgmtActeRequestDto.getActeNumComplema());
		} else {
			if (reamgmtActeRequestDto.getActeNum() <= 0) {
				entity.setNumero(reamgmtActeRequestDto.getActeAn() + "____________" + reamgmtActeRequestDto.getActeNumComplema());
			} else {
				entity.setNumero(reamgmtActeRequestDto.getActeAn() + "-" + decFormat.format(reamgmtActeRequestDto.getActeNum()) + "/" + reamgmtActeRequestDto.getActeNumComplema());
			}	
		}
	
		entity.setDateActe(reamgmtActeRequestDto.getDateActe());
		entity.setIdLogin(reamgmtActeRequestDto.getIdLogin());
		entity.setDateValid(reamgmtActeRequestDto.getDateValid());
		entity.setIdValid(reamgmtActeRequestDto.getIdValid());
		entity.setDep(reamgmtActeRequestDto.getDep());
		entity.setActeTitre(reamgmtActeRequestDto.getActeTitre());
		entity.setActeAn(reamgmtActeRequestDto.getActeAn());
		
		if (reamgmtActeRequestDto.getNumAuto() == true) {
			entity.setActeNum(repository.getActeNum(reamgmtActeRequestDto.getGestion(), reamgmtActeRequestDto.getActe()));
		} else {
			entity.setActeNum(reamgmtActeRequestDto.getActeNum());
		}
		
		entity.setActeNumComplema(reamgmtActeRequestDto.getActeNumComplema());
		entity.setNumAuto(reamgmtActeRequestDto.getNumAuto());
		entity.setSignataireFonct(reamgmtActeRequestDto.getSignataireFonct());
		entity.setSignataireNom(reamgmtActeRequestDto.getSignataireNom());
		entity.setSignataireTh(reamgmtActeRequestDto.getSignataireTh());
		entity.setComplemaVisa(reamgmtActeRequestDto.getComplemaVisa());
		entity.setComplemaVisaLib(reamgmtActeRequestDto.getComplemaVisaLib());
		entity.setDernierArticleReam(reamgmtActeRequestDto.getDernierArticleReam());
		
		if (reamgmtActeRequestDto.getIdActe() == null) {
			throw new IllegalArgumentException("ReamgmtActe need a ActeNature");
		}
		ActeNature acteNature = acteNatureService.get(reamgmtActeRequestDto.getIdActe());
		entity.setActeNature(acteNature);
		
		if (reamgmtActeRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("ReamgmtActe need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(reamgmtActeRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		if (reamgmtActeRequestDto.getGestion() == null) {
			entity.setGestion(null);
		} else {
			Gestion gestion = gestionService.get(reamgmtActeRequestDto.getGestion());
			entity.setGestion(gestion);
		}
		
		repository.save(entity);
		return GbcMapper2.reamgmtActeReamgmtActeResponseDto(entity);
	}
	
	@Override
	public List<ReamgmtActeResponseDto> getAll() {
		List<ReamgmtActe> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.reamgmtActeReamgmtActeResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public ReamgmtActe get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("ReamgmtActe with id: " + id + " could not be found"));
	}
	
	@Override
	public ReamgmtActeResponseDto getById(Long id) {
		ReamgmtActe entity = get(id);
		return GbcMapper2.reamgmtActeReamgmtActeResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamgmtActeResponseDto delete(Long id) {
		ReamgmtActe entity = get(id);
		repository.delete(entity);
		return GbcMapper2.reamgmtActeReamgmtActeResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ReamgmtActeResponseDto edit(Long id, ReamgmtActeRequestDto reamgmtActeRequestDto) {
		ReamgmtActe entity = get(id);
		entity.setValide(reamgmtActeRequestDto.getValide());
		entity.setActe(reamgmtActeRequestDto.getActe());
		
		if (reamgmtActeRequestDto.getNumAuto() == true) {
			entity.setNumero(reamgmtActeRequestDto.getActeAn() + "-" + decFormat.format(repository.getActeNum_(reamgmtActeRequestDto.getGestion(), reamgmtActeRequestDto.getActe())) + "/" + reamgmtActeRequestDto.getActeNumComplema());
		} else {
			if (reamgmtActeRequestDto.getActeNum() <= 0) {
				entity.setNumero(reamgmtActeRequestDto.getActeAn() + "____________" + reamgmtActeRequestDto.getActeNumComplema());
			} else {
				entity.setNumero(reamgmtActeRequestDto.getActeAn() + "-" + decFormat.format(reamgmtActeRequestDto.getActeNum()) + "/" + reamgmtActeRequestDto.getActeNumComplema());
			}	
		}
		
		entity.setDateActe(reamgmtActeRequestDto.getDateActe());
		entity.setIdLogin(reamgmtActeRequestDto.getIdLogin());
		entity.setDateValid(reamgmtActeRequestDto.getDateValid());
		entity.setIdValid(reamgmtActeRequestDto.getIdValid());
		entity.setDep(reamgmtActeRequestDto.getDep());
		entity.setActeTitre(reamgmtActeRequestDto.getActeTitre());
		entity.setActeAn(reamgmtActeRequestDto.getActeAn());
		
		if (reamgmtActeRequestDto.getNumAuto() == false) entity.setActeNum(reamgmtActeRequestDto.getActeNum());
		
		entity.setActeNumComplema(reamgmtActeRequestDto.getActeNumComplema());
		entity.setNumAuto(reamgmtActeRequestDto.getNumAuto());
		entity.setSignataireFonct(reamgmtActeRequestDto.getSignataireFonct());
		entity.setSignataireNom(reamgmtActeRequestDto.getSignataireNom());
		entity.setSignataireTh(reamgmtActeRequestDto.getSignataireTh());
		entity.setComplemaVisa(reamgmtActeRequestDto.getComplemaVisa());
		entity.setComplemaVisaLib(reamgmtActeRequestDto.getComplemaVisaLib());
		entity.setDernierArticleReam(reamgmtActeRequestDto.getDernierArticleReam());
		
		if (reamgmtActeRequestDto.getIdActe() != null) {
			ActeNature acteNature = acteNatureService.get(reamgmtActeRequestDto.getIdActe());
			entity.setActeNature(acteNature);
		}
		
		if (reamgmtActeRequestDto.getIdBudget() != null) {
			BudgetType budgetType = budgetTypeService.get(reamgmtActeRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);;
		}
		
		if (reamgmtActeRequestDto.getGestion() == null) {
			entity.setGestion(null);
		} else {
			Gestion gestion = gestionService.get(reamgmtActeRequestDto.getGestion());
			entity.setGestion(gestion);
		}
		return GbcMapper2.reamgmtActeReamgmtActeResponseDto(entity);
	}

	@Override
	public Boolean existsByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide) {
		return repository.existsByGestionAndBudgetTypeAndValide(
				gestionService.get(gestion), 
				budgetTypeService.get(idBudget),
				valide);
	}

	@Override
	public List<ReamgmtActeResponseDto> getByGestionAndIdBudgetAndValide(Short gestion, Integer idBudget, Boolean valide) {
		List<ReamgmtActe> list = repository.getByGestionAndBudgetTypeAndValideOrderByDateSaisieDesc(
				gestionService.get(gestion), 
				budgetTypeService.get(idBudget), 
				valide);
		return list
				.stream().map(element  -> GbcMapper2.reamgmtActeReamgmtActeResponseDto(element))
				.collect(Collectors.toList());
	}
}
