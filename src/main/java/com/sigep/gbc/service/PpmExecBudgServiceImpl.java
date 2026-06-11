//Aristide
package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmExecBudgRequestDto;
import com.sigep.gbc.dto.responseDto.PpmExecBudgResponseDto;
import com.sigep.gbc.entity.Budget;
import com.sigep.gbc.entity.CodSourceFin;
import com.sigep.gbc.entity.PpmExecBudg;
import com.sigep.gbc.entity.PpmExecBudgId;
import com.sigep.gbc.repository.PpmExecBudgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PpmExecBudgServiceImpl implements PpmExecBudgService {
  
  private final PpmExecBudgRepository repository;
 
  //private final PpmExecService ppmExecService;
  private final BudgetService budgetService;
  private final CodSourceFinService codSourceFinService;
  
  

  @Override
  public PpmExecBudgResponseDto add(PpmExecBudgRequestDto ppmExecBudgRequestDto) {
    
      PpmExecBudg entity = new PpmExecBudg();
      PpmExecBudgId id = new PpmExecBudgId();
      
      if(ppmExecBudgRequestDto.getIdPpmExe() == 0 || ppmExecBudgRequestDto.getIdPpmExe() <0 ) {
    	  throw new IllegalArgumentException("PpmExec budg need a ppm");
      }
      id.setIdPpmExe(ppmExecBudgRequestDto.getIdPpmExe());
      id.setIdLot(ppmExecBudgRequestDto.getIdLot());
	  id.setIdBudget(ppmExecBudgRequestDto.getIdBudget());
	  id.setExercice(ppmExecBudgRequestDto.getExercice());
	  
	  if (ppmExecBudgRequestDto.getCodBud() == null) {
		  throw new IllegalArgumentException("PpmBudgExec need a Budget");
	  }
	  Budget budget = budgetService.get(ppmExecBudgRequestDto.getCodBud());
	  id.setCodBud(budget.getCodBud());
	  
	  if (ppmExecBudgRequestDto.getIdSrceFin() == null) {
		  throw new IllegalArgumentException("PpmBudgExec need a CodSourceFin");
	  }
	  CodSourceFin codSourceFin = codSourceFinService.get(ppmExecBudgRequestDto.getIdSrceFin());
	  id.setIdSrceFin(codSourceFin.getCod5());
	  entity.setId(id);
	  
	  entity.setMontantEstime(ppmExecBudgRequestDto.getMontantEstime());
	  
	  if(ppmExecBudgRequestDto.getMontantMaxHtva() == 0) {
		  entity.setMontantMaxHtva(ppmExecBudgRequestDto.getMontantEstime());
	  } else {
		  entity.setMontantMaxHtva(ppmExecBudgRequestDto.getMontantMaxHtva());
	  }
	  entity.setMontantMinHtva(ppmExecBudgRequestDto.getMontantMinHtva());
	  entity.setMontantMaxTtc(ppmExecBudgRequestDto.getMontantMaxTtc());
	  entity.setMontantMinTtc(ppmExecBudgRequestDto.getMontantMinTtc());
	  entity.setAvecTva(ppmExecBudgRequestDto.isAvecTva());
	  entity.setAvecMiniMax(ppmExecBudgRequestDto.isAvecMiniMax());
	  
      repository.save(entity);
      return GbcMapper2.PpmExecBudgToPpmExecBudgResponseDto(entity);
  }
  
  @Override
  public List<PpmExecBudgResponseDto> getAll() {
	  List<PpmExecBudg> list = repository.findAll();
      return list 
    		  .stream().map(element -> GbcMapper2.PpmExecBudgToPpmExecBudgResponseDto(element))
              .collect(Collectors.toList());
  }
  
  @Override
  public PpmExecBudg get(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin) {
	  PpmExecBudgId id = new PpmExecBudgId();
      id.setIdPpmExe(idPpmExe);
      id.setIdLot(idLot);
      id.setIdBudget(idBudget);
      id.setExercice(exercice);
      id.setCodBud(codBud);
      id.setIdSrceFin(idSrceFin);
      return repository.findById(id).orElseThrow(() -> 
      new IllegalArgumentException("PpmBudgExec with id: " + id + " could not be found"));
  }

  @Override
  public PpmExecBudgResponseDto getById(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin) {
	  PpmExecBudg entity = get(idPpmExe,idLot,idBudget,exercice,codBud,idSrceFin);
	  return GbcMapper2.PpmExecBudgToPpmExecBudgResponseDto(entity);
  }
  
  @Override
  @Transactional("gbcTransactionManager")
  public PpmExecBudgResponseDto edit(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin, PpmExecBudgRequestDto ppmExecBudgRequestDto) {
      PpmExecBudg entity = get(idPpmExe,idLot,idBudget,exercice,codBud,idSrceFin);
      entity.setMontantEstime(ppmExecBudgRequestDto.getMontantEstime());
      return GbcMapper2.PpmExecBudgToPpmExecBudgResponseDto(entity);
  }

  @Override
  public PpmExecBudgResponseDto delete(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin) {
      PpmExecBudg entity = get(idPpmExe,idLot,idBudget,exercice,codBud,idSrceFin);
      repository.delete(entity);
      return GbcMapper2.PpmExecBudgToPpmExecBudgResponseDto(entity);
  }
  
  @Override
  public Long getMontantCumuleByIdPpmBudg(String idPpm, String codBud, String idSrceFin) {
	  return repository.sumMontantEstimeByPpmBudgKey(idPpm, codBud, idSrceFin)
              .orElse(0L);
  }
  
  @Override
  public List<PpmExecBudgResponseDto> getLignesByLot(int idPpmExe, int idLot, Integer idBudget, short exercice) {
      List<PpmExecBudg> list = repository.findById_IdPpmExeAndId_IdLotAndId_IdBudgetAndId_Exercice(
          idPpmExe, 
          idLot, 
          idBudget, 
          exercice
      );
      
      return list
          .stream()
          .map(GbcMapper2::PpmExecBudgToPpmExecBudgResponseDto)
          .collect(Collectors.toList());
  }
  
  @Override
  public Long getMontantCumuleExcluantLotEnCours(
          String idPpm, 
          String codBud, 
          String idSrceFin, 
          int idPpmExeToExclude, 
          int idLotToExclude, 
          Integer idBudgetToExclude, 
          short exerciceToExclude) {
      
      return repository.sumMontantEstimeExcludingLot(
              idPpm, 
              codBud, 
              idSrceFin, 
              idPpmExeToExclude, 
              idLotToExclude
          ).orElse(0L);
  }
  
  @Override
  @Transactional("gbcTransactionManager")
  public void deleteAllByLotId(int idPpmExec, int idLot, Integer idBudget, short exercice){
	  List<PpmExecBudg> lignesASupprimer = repository.findById_IdPpmExeAndId_IdLotAndId_IdBudgetAndId_Exercice(
		        idPpmExec, 
		        idLot, 
		        idBudget, 
		        exercice
		    );
	  repository.deleteAll(lignesASupprimer);
  }
}