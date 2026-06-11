package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TableRapportRequestDto;
import com.sigep.gim.dto.responseDto.TableRapportResponseDto;
import com.sigep.gim.entity.TableRapport;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimTableRapportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimTableRapportServiceImpl implements GimTableRapportService {
	
	private final GimTableRapportRepository repository;
	
	@Override
	@Transactional
	public TableRapportResponseDto add(TableRapportRequestDto tableRapportRequestDto) {
		TableRapport entity = new TableRapport();
		entity.setMle(tableRapportRequestDto.getMle());
	    entity.setId(tableRapportRequestDto.getId());
	    entity.setIdFiche(tableRapportRequestDto.getIdFiche());
	    entity.setCodCategorie(tableRapportRequestDto.getCodCategorie());
	    entity.setCodStruct(tableRapportRequestDto.getCodStruct());
	    entity.setCodSourceFin(tableRapportRequestDto.getCodSourceFin());
	    entity.setCodMat(tableRapportRequestDto.getCodMat());
	    entity.setAnneAcq(tableRapportRequestDto.getAnneAcq());
	    entity.setDateEntre(tableRapportRequestDto.getDateEntre());
	    entity.setQuantième(tableRapportRequestDto.getQuantième());
	    entity.setEtatEntre(tableRapportRequestDto.getEtatEntre());
	    entity.setValUnit(tableRapportRequestDto.getValUnit());
	    entity.setDureeVie(tableRapportRequestDto.getDureeVie());
	    entity.setAmrtisable(tableRapportRequestDto.getAmrtisable());
	    entity.setAmorType(tableRapportRequestDto.getAmorType());
	    entity.setFormat(tableRapportRequestDto.getFormat());
	    entity.setStatPatri(tableRapportRequestDto.getStatPatri());
	    entity.setIdMagasin(tableRapportRequestDto.getIdMagasin());
	    entity.setIdFicheAffec(tableRapportRequestDto.getIdFicheAffec());
	    entity.setMleAffect(tableRapportRequestDto.getMleAffect());
	    entity.setCodDirect(tableRapportRequestDto.getCodDirect());
	    entity.setCodeDir(tableRapportRequestDto.getCodeDir());
	    entity.setCodService(tableRapportRequestDto.getCodService());
	    entity.setCodeSite(tableRapportRequestDto.getCodeSite());
	    entity.setCodReg(tableRapportRequestDto.getCodReg());
	    entity.setCodProv(tableRapportRequestDto.getCodProv());
	    entity.setEtatActuel(tableRapportRequestDto.getEtatActuel());
	    entity.setIdInvent(tableRapportRequestDto.getIdInvent());
	    entity.setIdFicheEntreProv(tableRapportRequestDto.getIdFicheEntreProv());
	    entity.setIdFicheEnCours(tableRapportRequestDto.getIdFicheEnCours());
	    entity.setNomAgentUtil(tableRapportRequestDto.getNomAgentUtil());
	    entity.setMleAgentUtil(tableRapportRequestDto.getMleAgentUtil());
	    entity.setMarqueType(tableRapportRequestDto.getMarqueType());
		repository.save(entity);
		return GimMapper.TableRapportToTableRapportResponseDto(entity);
	}
	
	@Override
	public List<TableRapportResponseDto> getAll() {
		List<TableRapport> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.TableRapportToTableRapportResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public TableRapport get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("TableRapport with id "+id+"could not be found")
		);
	}
	
	@Override
	public TableRapportResponseDto getById(String id) {
		TableRapport entity = get(id);
		return GimMapper.TableRapportToTableRapportResponseDto(entity);
	}
	
	@Override
	@Transactional
	public TableRapportResponseDto delete(String id) {
		TableRapport entity = get(id);
		repository.delete(entity);
		return GimMapper.TableRapportToTableRapportResponseDto(entity);
	}
	
	@Override
	@Transactional
	public TableRapportResponseDto edit(String id,TableRapportRequestDto tableRapportRequestDto) {
		TableRapport entity = get(id);
	    entity.setId(tableRapportRequestDto.getId());
	    entity.setIdFiche(tableRapportRequestDto.getIdFiche());
	    entity.setCodCategorie(tableRapportRequestDto.getCodCategorie());
	    entity.setCodStruct(tableRapportRequestDto.getCodStruct());
	    entity.setCodSourceFin(tableRapportRequestDto.getCodSourceFin());
	    entity.setCodMat(tableRapportRequestDto.getCodMat());
	    entity.setAnneAcq(tableRapportRequestDto.getAnneAcq());
	    entity.setDateEntre(tableRapportRequestDto.getDateEntre());
	    entity.setQuantième(tableRapportRequestDto.getQuantième());
	    entity.setEtatEntre(tableRapportRequestDto.getEtatEntre());
	    entity.setValUnit(tableRapportRequestDto.getValUnit());
	    entity.setDureeVie(tableRapportRequestDto.getDureeVie());
	    entity.setAmrtisable(tableRapportRequestDto.getAmrtisable());
	    entity.setAmorType(tableRapportRequestDto.getAmorType());
	    entity.setFormat(tableRapportRequestDto.getFormat());
	    entity.setStatPatri(tableRapportRequestDto.getStatPatri());
	    entity.setIdMagasin(tableRapportRequestDto.getIdMagasin());
	    entity.setIdFicheAffec(tableRapportRequestDto.getIdFicheAffec());
	    entity.setMleAffect(tableRapportRequestDto.getMleAffect());
	    entity.setCodDirect(tableRapportRequestDto.getCodDirect());
	    entity.setCodeDir(tableRapportRequestDto.getCodeDir());
	    entity.setCodService(tableRapportRequestDto.getCodService());
	    entity.setCodeSite(tableRapportRequestDto.getCodeSite());
	    entity.setCodReg(tableRapportRequestDto.getCodReg());
	    entity.setCodProv(tableRapportRequestDto.getCodProv());
	    entity.setEtatActuel(tableRapportRequestDto.getEtatActuel());
	    entity.setIdInvent(tableRapportRequestDto.getIdInvent());
	    entity.setIdFicheEntreProv(tableRapportRequestDto.getIdFicheEntreProv());
	    entity.setIdFicheEnCours(tableRapportRequestDto.getIdFicheEnCours());
	    entity.setNomAgentUtil(tableRapportRequestDto.getNomAgentUtil());
	    entity.setMleAgentUtil(tableRapportRequestDto.getMleAgentUtil());
	    entity.setMarqueType(tableRapportRequestDto.getMarqueType());
		return GimMapper.TableRapportToTableRapportResponseDto(entity);
	}
}
