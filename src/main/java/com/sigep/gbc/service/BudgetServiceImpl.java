package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.BudgetRequestDto;
import com.sigep.gbc.dto.responseDto.BudgetResponseDto;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.Gestion;

import com.sigep.gbc.entity.NomenclatureD;
import com.sigep.gbc.entity.PlanComptable;
import com.sigep.gbc.repository.BudgetRepository;
import com.sigep.gbc.repository.NomenclatureDRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService{
	
	private final BudgetRepository repository;
	private final PlanComptableService pcService;
	private final NomenclatureDService nDService;
	private final BudgetTypeService btService;
	private final GestionService gService;
	private final NomenclatureDRepository ndRepository;

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetResponseDto add(BudgetRequestDto budgetRequestDto) {
		
		
		
		Long dotN1 = repository.getDotation((short) (budgetRequestDto.getGestion() - 1), budgetRequestDto.getIdBudget(), budgetRequestDto.getNumNo());
		Long execN1 = repository.getExecution((short) (budgetRequestDto.getGestion() - 1), budgetRequestDto.getIdBudget(), budgetRequestDto.getNumNo());
		Long dotN2 = repository.getDotation((short) (budgetRequestDto.getGestion() - 2), budgetRequestDto.getIdBudget(), budgetRequestDto.getNumNo());
		Long execN2 = repository.getExecution((short) (budgetRequestDto.getGestion() - 2), budgetRequestDto.getIdBudget(), budgetRequestDto.getNumNo());
		Long dotN3 = repository.getDotation((short) (budgetRequestDto.getGestion() - 3), budgetRequestDto.getIdBudget(), budgetRequestDto.getNumNo());
		Long execN3 = repository.getExecution((short) (budgetRequestDto.getGestion() - 3), budgetRequestDto.getIdBudget(), budgetRequestDto.getNumNo());
		
		Budget entity = new Budget();
		entity.setCodBud(budgetRequestDto.getCodBud());
		entity.setIntitule(budgetRequestDto.getIntitule());
		entity.setDotInitiale(budgetRequestDto.getDotInitiale());
		entity.setCaajout(budgetRequestDto.getCaajout());
		entity.setCaannul(budgetRequestDto.getCaannul());
		entity.setReam(budgetRequestDto.getReam());
		entity.setTotalEngag(budgetRequestDto.getTotalEngag());
		entity.setDotN1(dotN1);
		entity.setExecN1(execN1);
		entity.setDotN2(dotN2);
		entity.setExecN2(execN2);
		entity.setDotN3(dotN3);
		entity.setExecN3(execN3);
		
		if (budgetRequestDto.getIdPlan() == null) {
			throw new IllegalArgumentException("Budget need a PlanComptable");
		}
		PlanComptable planComptable = pcService.get(budgetRequestDto.getIdPlan());
		entity.setPlanComptable(planComptable);
		
		if (budgetRequestDto.getNumNo() == null) {
			throw new IllegalArgumentException("Budget need a NomenclatureD");
		}
		NomenclatureD nomenclatureD = nDService.get(budgetRequestDto.getNumNo());
		entity.setNomenclatureD(nomenclatureD);
		
		if (budgetRequestDto.getGestion() == null) {
			throw new IllegalArgumentException("Budget need a Gestion");
		}
		Gestion gestion = gService.get(budgetRequestDto.getGestion());
		entity.setGestion(gestion);
		
		if (budgetRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("Budget need a BudgetType");
		}
		BudgetType budgetType = btService.get(budgetRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		repository.save(entity);
		return GbcMapper.BToBResponseDto(entity);
	}

	@Override
	public List<BudgetResponseDto> getAll() {
		List<Budget> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.BToBResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Budget get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Budget with id: " + id + " could not be found"));
	}

	@Override
	public BudgetResponseDto getById(String id) {
		Budget entity = get(id);
		return GbcMapper.BToBResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetResponseDto delete(String id) {
		Budget entity = get(id);
		repository.delete(entity);
		return GbcMapper.BToBResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetResponseDto edit(String id, BudgetRequestDto budgetRequestDto) {
		Budget entity = get(id);
		entity.setIntitule(budgetRequestDto.getIntitule());
		entity.setDotInitiale(budgetRequestDto.getDotInitiale());
		entity.setCaajout(budgetRequestDto.getCaajout());
		entity.setCaannul(budgetRequestDto.getCaannul());
		entity.setReam(budgetRequestDto.getReam());
		entity.setTotalEngag(budgetRequestDto.getTotalEngag());
		
		if (budgetRequestDto.getIdPlan() != null) {
			PlanComptable planComptable = pcService.get(budgetRequestDto.getIdPlan());
			entity.setPlanComptable(planComptable);
		}
		
		if (budgetRequestDto.getNumNo() != null) {
			NomenclatureD nomenclatureD = nDService.get(budgetRequestDto.getNumNo());
			entity.setNomenclatureD(nomenclatureD);
		}
		
		
		if (budgetRequestDto.getGestion() != null) {
			Gestion gestion = gService.get(budgetRequestDto.getGestion());
			entity.setGestion(gestion);
		}
		
		if (budgetRequestDto.getIdBudget() != null) {
			BudgetType budgetType = btService.get(budgetRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		return GbcMapper.BToBResponseDto(entity);
	}

	@Override
	public List<BudgetResponseDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		Gestion gestion2 = gService.get(gestion);
		BudgetType budgetType = btService.get(idBudget);
		List<Budget> list = repository.findByGestionAndBudgetType(gestion2, budgetType);
		return list
				.stream().map(element  -> GbcMapper.BToBResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<BudgetResponseDto> getByNumNo(String numNo) {
		NomenclatureD nomenclatureD = nDService.get(numNo);
		List<Budget> list = repository.findByNomenclatureD(nomenclatureD);
		return list
				.stream().map(element  -> GbcMapper.BToBResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Boolean exits(Short gestion, Integer idBudget) {
		Gestion gestion2 = gService.get(gestion);
		BudgetType budgetType = btService.get(idBudget);
		List<Budget> list = repository.findByGestionAndBudgetType(gestion2, budgetType);
		return list.isEmpty();	
	}

	@Override
	public List<BudgetResponseDto> creerBudgetSuivantAPartirDuBudgetPrecent(Short gestion, Integer idBudget) {
		Integer un = gestion - 1;    
		Gestion gestion2 = gService.get(un.shortValue());
		BudgetType budgetType = btService.get(idBudget);
		List<Budget> budgetPrecedents = repository.findByGestionAndBudgetType(gestion2, budgetType);
		
		for (Budget bp: budgetPrecedents) {
			Long dotN1 = repository.getDotation((short) (gestion - 1), bp.getBudgetType().getIdBudget(), bp.getPlanComptable().getIdPlan());
			Long execN1 = repository.getExecution((short) (gestion - 1), bp.getBudgetType().getIdBudget(), bp.getPlanComptable().getIdPlan());
			Long dotN2 = repository.getDotation((short) (gestion - 2), bp.getBudgetType().getIdBudget(), bp.getPlanComptable().getIdPlan());
			Long execN2 = repository.getExecution((short) (gestion - 2), bp.getBudgetType().getIdBudget(), bp.getPlanComptable().getIdPlan());
			Long dotN3 = repository.getDotation((short) (gestion - 3), bp.getBudgetType().getIdBudget(), bp.getPlanComptable().getIdPlan());
			Long execN3 = repository.getExecution((short) (gestion - 3), bp.getBudgetType().getIdBudget(), bp.getPlanComptable().getIdPlan());
			
			Budget entity = new Budget();
			entity.setCodBud(bp.getCodBud().replace(String.valueOf(gestion - 1), String.valueOf(gestion)));
			entity.setIntitule(bp.getIntitule());
			entity.setDotInitiale(0);
			entity.setCaajout(0);
			entity.setCaannul(0);
			entity.setReam(0);
			entity.setTotalEngag(0);
			entity.setDotN1((dotN1 == null)? 0 : dotN1);
			entity.setExecN1((execN1 == null)? 0 : execN1);
			entity.setDotN2((dotN2 == null)? 0 : dotN2);
			entity.setExecN2((execN2 == null)? 0 : execN2);
			entity.setDotN3((dotN3 == null)? 0 : dotN3);
			entity.setExecN3((execN3 == null)? 0 : execN3);
			entity.setPlanComptable(bp.getPlanComptable());
			entity.setNomenclatureD(bp.getNomenclatureD());
			entity.setGestion(gService.get(gestion));
			entity.setBudgetType(bp.getBudgetType());
			repository.save(entity);
		}
		
		return getByGestionAndIdBudget(gestion, idBudget);
	}
	
	@Override
	public List<BudgetResponseDto> creerBudgetSuivantAPartirDesRecettesEtDepenses(Short gestion, Integer idBudget) {
		List<NomenclatureD> nomenclatureDs = ndRepository.getRecettesEtDepenses();
		
		for (NomenclatureD nd: nomenclatureDs) {
			Budget entity = new Budget();
			entity.setCodBud(gestion + "." + nd.getNumNo() + ".0" + idBudget);
			entity.setIntitule(nd.getIntitule());
			entity.setDotInitiale(0);
			entity.setCaajout(0);
			entity.setCaannul(0);
			entity.setReam(0);
			entity.setTotalEngag(0);
			entity.setDotN1(0L);
			entity.setExecN1(0L);
			entity.setDotN2(0L);
			entity.setExecN2(0L);
			entity.setDotN3(0L);
			entity.setExecN3(0L);
			entity.setPlanComptable(pcService.get(String.valueOf(nd.getIdPlan())));
			entity.setNomenclatureD(nd);
			entity.setGestion(gService.get(gestion));
			entity.setBudgetType(btService.get(idBudget));
			repository.save(entity);
		}
		
		return getByGestionAndIdBudget(gestion, idBudget);
	}

	@Override
	public List<BudgetResponseDto> getRecettes(Short gestion, Integer idBudget) {
		List<Budget> list = repository.getRecettes(gestion, idBudget);
		return list
				.stream().map(element  -> GbcMapper.BToBResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<BudgetResponseDto> getDepenses(Short gestion, Integer idBudget) {
		List<Budget> list = repository.getDepenses(gestion, idBudget);
		return list
				.stream().map(element  -> GbcMapper.BToBResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetResponseDto editCAajoutCAannul(String codBud) {
		repository.editCAajoutCAannul(codBud);
		Budget entity = get(codBud);
		return GbcMapper.BToBResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public BudgetResponseDto editReam(String codBud) {
		repository.editReam(codBud);
		Budget entity = get(codBud);
		return GbcMapper.BToBResponseDto(entity);
	}
}
