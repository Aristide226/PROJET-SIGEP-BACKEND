package com.sigep.common.histoGbk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.common.histoGbk.dto.requestDto.EnteteStructureRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.EnteteStructureResponseDto;
import com.sigep.common.histoGbk.entity.EnteteStructure;
import com.sigep.common.histoGbk.entity.NumerotationMandat;
import com.sigep.common.histoGbk.repository.HistoGbkEnteteStructureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional("histoGbkTransactionManager")
public class HistoGbkEnteteStructureServiceImpl implements HistoGbkEnteteStructureService {
	
	private final HistoGbkEnteteStructureRepository repository;
	private final HistoGbkNumerotationMandatService nmService;
	private final ModelMapper modelMapper;
	
	@Override
	public EnteteStructureResponseDto add(EnteteStructureRequestDto enteteStructureRequestDto) {
		EnteteStructure enteteStructure = new EnteteStructure();
		enteteStructure.setAbrevEpe(enteteStructureRequestDto.getAbrevEpe());
		enteteStructure.setSection(enteteStructureRequestDto.getSection());
		enteteStructure.setEpe(enteteStructureRequestDto.getEpe());
		enteteStructure.setLieu(enteteStructureRequestDto.getLieu());
		enteteStructure.setSignataireDg(enteteStructureRequestDto.getSignataireDg());
		enteteStructure.setNomSignataireDg(enteteStructureRequestDto.getNomSignataireDg());
		enteteStructure.setTitreHonorifiqueDg(enteteStructureRequestDto.getTitreHonorifiqueDg());
		enteteStructure.setSignataireDaf(enteteStructureRequestDto.getSignataireDaf());
		enteteStructure.setNomSignataireDaf(enteteStructureRequestDto.getNomSignataireDaf());
		enteteStructure.setTitreHonorifiqueDaf(enteteStructureRequestDto.getTitreHonorifiqueDaf());
		enteteStructure.setSignataireCf(enteteStructureRequestDto.getSignataireCf());
		enteteStructure.setNomSignataireCf(enteteStructureRequestDto.getNomSignataireCf());
		enteteStructure.setTitreHonorifiqueCf(enteteStructureRequestDto.getTitreHonorifiqueCf());
		enteteStructure.setSignataireAc(enteteStructureRequestDto.getSignataireAc());
		enteteStructure.setNomSignataireAc(enteteStructureRequestDto.getNomSignataireAc());
		enteteStructure.setTitreHonorifiqueAc(enteteStructureRequestDto.getTitreHonorifiqueAc());
		enteteStructure.setCfresident(enteteStructureRequestDto.getCfresident());
		enteteStructure.setSignatPenal(enteteStructureRequestDto.getSignatPenal());
		enteteStructure.setAdresse(enteteStructureRequestDto.getAdresse());
		enteteStructure.setTelephone(enteteStructureRequestDto.getTelephone());
		enteteStructure.setFax(enteteStructureRequestDto.getFax());
		enteteStructure.setEmail(enteteStructureRequestDto.getEmail());
		enteteStructure.setVisa(enteteStructureRequestDto.getVisa());
		enteteStructure.setArticleStruct(enteteStructureRequestDto.getArticleStruct());
		enteteStructure.setNomPays(enteteStructureRequestDto.getNomPays());
		enteteStructure.setDevisePays(enteteStructureRequestDto.getDevisePays());
		enteteStructure.setMleCnss(enteteStructureRequestDto.getMleCnss());
		enteteStructure.setMleCarfo(enteteStructureRequestDto.getMleCarfo());
		enteteStructure.setTypeSupport(enteteStructureRequestDto.getTypeSupport());
		enteteStructure.setAvecReception(enteteStructureRequestDto.isAvecReception());
		enteteStructure.setTauxTva(enteteStructureRequestDto.getTauxTva());
		enteteStructure.setTypeAmmortDefaut(enteteStructureRequestDto.getTypeAmmortDefaut());
		enteteStructure.setGbc(enteteStructureRequestDto.isGbc());
		enteteStructure.setGim(enteteStructureRequestDto.isGim());
		enteteStructure.setGrh(enteteStructureRequestDto.isGrh());
		enteteStructure.setSectionNum(enteteStructureRequestDto.getSectionNum());
		enteteStructure.setSignataireDrh(enteteStructureRequestDto.getSignataireDrh());
		enteteStructure.setNomSignataireDrh(enteteStructureRequestDto.getNomSignataireDrh());
		enteteStructure.setTitreHonorifiqueDrh(enteteStructureRequestDto.getTitreHonorifiqueDrh());
		enteteStructure.setIdCircuitGrh(enteteStructureRequestDto.getIdCircuitGrh());
		enteteStructure.setDrhsigneEtat(enteteStructureRequestDto.isDrhsigneEtat());
		enteteStructure.setLibAnnee(enteteStructureRequestDto.getLibAnnee());
		enteteStructure.setLogo(enteteStructureRequestDto.getLogo());
		enteteStructure.setQuitFiligrane(enteteStructureRequestDto.getQuitFiligrane());
		enteteStructure.setFilgraneL276cmH185cm(enteteStructureRequestDto.getFilgraneL276cmH185cm());
		
		if (enteteStructureRequestDto.getMandNumApresVisaCf() == null) {
			throw new IllegalArgumentException("EnteteStructure need a NumerotationMandat");
		}
		NumerotationMandat numerotationMandat = nmService.get(enteteStructureRequestDto.getMandNumApresVisaCf());
		enteteStructure.setNumerotationMandat(numerotationMandat);
		
		repository.save(enteteStructure);
		return modelMapper.map(enteteStructure, EnteteStructureResponseDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EnteteStructureResponseDto> getAll() {
		List<EnteteStructure> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, EnteteStructureResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public EnteteStructure get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("EnteteStructure with id: " + id + " could not be found"));
	}

	@Override
	@Transactional(readOnly = true)
	public EnteteStructureResponseDto getById(String id) {
		EnteteStructure entity = get(id);
		return modelMapper.map(entity, EnteteStructureResponseDto.class);
	}

	@Override
	public EnteteStructureResponseDto delete(String id) {
		EnteteStructure entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, EnteteStructureResponseDto.class);
	}

	@Override
	public EnteteStructureResponseDto edit(String newId, String oldId, EnteteStructureRequestDto enteteStructureRequestDto) {
		repository.update(
				newId,
				oldId,
				enteteStructureRequestDto.getSection(),
				enteteStructureRequestDto.getEpe(),
				enteteStructureRequestDto.getLieu(),
				(enteteStructureRequestDto.getLogo() != null)? enteteStructureRequestDto.getLogo() : null,
				enteteStructureRequestDto.getSignataireDg(),
				enteteStructureRequestDto.getNomSignataireDg(),
				enteteStructureRequestDto.getTitreHonorifiqueDg(),
				enteteStructureRequestDto.getSignataireDaf(),
				enteteStructureRequestDto.getNomSignataireDaf(),
				enteteStructureRequestDto.getTitreHonorifiqueDaf(),
				enteteStructureRequestDto.getSignataireCf(),
				enteteStructureRequestDto.getNomSignataireCf(),
				enteteStructureRequestDto.getTitreHonorifiqueCf(),
				enteteStructureRequestDto.getSignataireAc(),
				enteteStructureRequestDto.getNomSignataireAc(),
				enteteStructureRequestDto.getTitreHonorifiqueAc(),
				enteteStructureRequestDto.getCfresident(),
				enteteStructureRequestDto.getSignatPenal(),
				enteteStructureRequestDto.getAdresse(),
				enteteStructureRequestDto.getTelephone(),
				enteteStructureRequestDto.getFax(),
				enteteStructureRequestDto.getEmail(),
				enteteStructureRequestDto.getVisa(),
				enteteStructureRequestDto.getArticleStruct(),
				enteteStructureRequestDto.getNomPays(),
				enteteStructureRequestDto.getDevisePays(),
				enteteStructureRequestDto.getMleCnss(),
				enteteStructureRequestDto.getMleCarfo(),
				enteteStructureRequestDto.getTypeSupport(),
				enteteStructureRequestDto.isAvecReception(),
				(enteteStructureRequestDto.getQuitFiligrane() != null)? enteteStructureRequestDto.getQuitFiligrane() : null,
				enteteStructureRequestDto.getTauxTva(),	
				enteteStructureRequestDto.getTypeAmmortDefaut(),
				enteteStructureRequestDto.isGbc(),
				enteteStructureRequestDto.isGim(),
				enteteStructureRequestDto.isGrh(),
				enteteStructureRequestDto.getSectionNum(),
				(enteteStructureRequestDto.getFilgraneL276cmH185cm() != null)? enteteStructureRequestDto.getFilgraneL276cmH185cm() : null,
				enteteStructureRequestDto.getSignataireDrh(),
				enteteStructureRequestDto.getNomSignataireDrh(),
				enteteStructureRequestDto.getTitreHonorifiqueDrh(),
				enteteStructureRequestDto.getIdCircuitGrh(),
				enteteStructureRequestDto.isDrhsigneEtat(),
				enteteStructureRequestDto.getLibAnnee(),
				enteteStructureRequestDto.getMandNumApresVisaCf()
				);
		
		EnteteStructure enteteStructure = get(newId);
		return modelMapper.map(enteteStructure, EnteteStructureResponseDto.class);
	}
}
