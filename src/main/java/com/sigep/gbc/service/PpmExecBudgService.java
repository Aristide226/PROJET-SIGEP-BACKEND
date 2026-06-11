//Aristide
package com.sigep.gbc.service;

import java.util.List;
import com.sigep.gbc.dto.requestDto.PpmExecBudgRequestDto;
import com.sigep.gbc.dto.responseDto.PpmExecBudgResponseDto;
import com.sigep.gbc.entity.PpmExecBudg;

public interface PpmExecBudgService {
    
    public PpmExecBudgResponseDto add(PpmExecBudgRequestDto requestDto);
    public List<PpmExecBudgResponseDto> getAll();
    public PpmExecBudg get(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin);
    public PpmExecBudgResponseDto getById(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin);
    public PpmExecBudgResponseDto edit(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin, PpmExecBudgRequestDto requestDto);
    public PpmExecBudgResponseDto delete(int idPpmExe, int idLot, Integer idBudget, short exercice, String codBud, String idSrceFin);
    public Long getMontantCumuleByIdPpmBudg(String idPpm, String codBud, String idSrceFin);
    public List<PpmExecBudgResponseDto> getLignesByLot(int idPpmExe, int idLot, Integer idBudget, short exercice);
    public Long getMontantCumuleExcluantLotEnCours(
            String idPpm, 
            String codBud, 
            String idSrceFin, 
            int idPpmExeToExclude, 
            int idLotToExclude, 
            Integer idBudgetToExclude, 
            short exerciceToExclude);
	public void deleteAllByLotId(int idPpmExec, int idLot, Integer idBudget, short exercice);
}