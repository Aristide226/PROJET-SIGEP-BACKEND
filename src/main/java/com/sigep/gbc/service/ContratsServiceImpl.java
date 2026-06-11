package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.ContratsRequestDto;
import com.sigep.gbc.dto.responseDto.ContratsResponseDto;
import com.sigep.gbc.entity.BudgetType;
import com.sigep.gbc.entity.ContratType;
import com.sigep.gbc.entity.Contrats;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.PpmDac;
import com.sigep.gbc.repository.ContratsRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratsServiceImpl implements ContratsService{
	
	private final ContratsRepository repository;
	private final BudgetTypeService budgetTypeService;
	private final DestinatairesService destinatairesService;
	private final ContratTypeService contratTypeService;
	private final PpmDacService ppmDacService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public ContratsResponseDto add(ContratsRequestDto contratsRequestDto) {
		int numero = repository.getNumero(contratsRequestDto.getAnnee(), contratsRequestDto.getIdBudget());
		int numeroOrdreContratAccordCadre = repository.getNumeroContratAccordCadre(contratsRequestDto.getAnnee(), contratsRequestDto.getIdBudget());
		
		Contrats entity = new Contrats();
		entity.setIdContrat(repository.getIdContrat());
		entity.setCod1(contratsRequestDto.getCod1());
		entity.setCod2(contratsRequestDto.getCod2());
		entity.setCod3(contratsRequestDto.getCod3());
		entity.setCod4(contratsRequestDto.getCod4());
		entity.setCod5(contratsRequestDto.getCod5());
		entity.setAnnee(contratsRequestDto.getAnnee());
		entity.setNumero(numero);
		entity.setObjet(contratsRequestDto.getObjet());
		if (contratsRequestDto.getMleAuto() == true) {
			if (contratsRequestDto.getCodIdentiteExecution().equals("04")) {// SI LE CONTRAT EST ACCORD-CADRE, ON AJOUTE LE NUMERO D'ORDRE
				entity.setReference(contratsRequestDto.getCod1() + "/" + contratsRequestDto.getCod2() + "/" + contratsRequestDto.getCodTypeMarche() + "/" + contratsRequestDto.getCodIdentiteExecution() + "/" + contratsRequestDto.getCod3() + "/" + contratsRequestDto.getCod4() + "/" + contratsRequestDto.getCod5() + "/" + contratsRequestDto.getAnnee() + "/" + String.format("%05d", numero) + "-" + String.format("%02d", numeroOrdreContratAccordCadre));
			} else {
				entity.setReference(contratsRequestDto.getCod1() + "/" + contratsRequestDto.getCod2() + "/" + contratsRequestDto.getCodTypeMarche() + "/" + contratsRequestDto.getCodIdentiteExecution() + "/" + contratsRequestDto.getCod3() + "/" + contratsRequestDto.getCod4() + "/" + contratsRequestDto.getCod5() + "/" + contratsRequestDto.getAnnee() + "/" + String.format("%05d", numero));
			}
		} else {
			entity.setReference(contratsRequestDto.getReference());
		}
		entity.setDelaiNbre(contratsRequestDto.getDelaiNbre());
		entity.setDelaiText(contratsRequestDto.getDelaiText());
		entity.setDateSaisie(contratsRequestDto.getDateSaisie());
		entity.setDateApprob(contratsRequestDto.getDateApprob());
		entity.setActeRef(contratsRequestDto.getActeRef());
		entity.setRefNotif(contratsRequestDto.getRefNotif());
		entity.setDateDemmar(contratsRequestDto.getDateDemmar());
		entity.setMleAuto(contratsRequestDto.getMleAuto());
		entity.setRefPassation(contratsRequestDto.getRefPassation());
		entity.setRefArt(contratsRequestDto.getRefArt());
		entity.setTauxappli(contratsRequestDto.getTauxappli());
		entity.setSuspens(contratsRequestDto.getSuspens());
		entity.setIdLogin(contratsRequestDto.getIdLogin());
		entity.setIdcompte(contratsRequestDto.getIdcompte());
		entity.setAvenant(0);
		entity.setDegage(0);
		entity.setEngage(0);
		entity.setMandate(0);
		entity.setPaie(0);
		entity.setEngageValid(0);
		entity.setMandateValid(0);
		entity.setMontantMaxHtva(contratsRequestDto.getMontantMaxHtva());
		entity.setMontantMinHtva(contratsRequestDto.getMontantMinHtva());
		entity.setMontantMaxTtc(contratsRequestDto.getMontantMaxTtc());
		entity.setMontantMinTtc(contratsRequestDto.getMontantMinTtc());
		entity.setAvecTva(contratsRequestDto.getAvecTva());
		entity.setAvecMiniMax(contratsRequestDto.getAvecMiniMax());
		entity.setDelaiAn(contratsRequestDto.getDelaiAn());
		entity.setDelaiMois(contratsRequestDto.getDelaiMois());
		entity.setDelaiSemaine(contratsRequestDto.getDelaiSemaine());
		entity.setDelaiJours(contratsRequestDto.getDelaiJours());
		entity.setDateCreate(contratsRequestDto.getDateCreate());
		entity.setUserUpdate(contratsRequestDto.getUserUpdate());
		entity.setDateUpdate(contratsRequestDto.getDateUpdate());
		entity.setIdContratParent(contratsRequestDto.getIdContratParent());
		entity.setAbrevEpe(contratsRequestDto.getAbrevEpe());
		entity.setDateAttribution(contratsRequestDto.getDateAttribution());
		entity.setCodTypeMarche(contratsRequestDto.getCodTypeMarche());
		entity.setCodIdentiteExecution(contratsRequestDto.getCodIdentiteExecution());
		entity.setIdPpmExe(contratsRequestDto.getIdPpmExe());
		entity.setIdLot(contratsRequestDto.getIdLot());
		entity.setCodBud(contratsRequestDto.getCodBud());
		entity.setIdSrceFin(contratsRequestDto.getIdSrceFin());
		
		if (contratsRequestDto.getIdBudget() == null) {
			throw new IllegalArgumentException("Contrats need a BudgetType");
		}
		BudgetType budgetType = budgetTypeService.get(contratsRequestDto.getIdBudget());
		entity.setBudgetType(budgetType);
		
		if (contratsRequestDto.getType() == null) {
			throw new IllegalArgumentException("Contrats need a ContratType");
		}
		ContratType contratType = contratTypeService.get(contratsRequestDto.getType());
		entity.setContratType(contratType);
		
		if (contratsRequestDto.getIdFourn() == null) {
			throw new IllegalArgumentException("Contrats need a Destinataire");
		}
		Destinataires destinataires = destinatairesService.get(contratsRequestDto.getIdFourn());
		entity.setDestinataires(destinataires);
		
		if (contratsRequestDto.getIdDac() == null) {
			entity.setPpmDac(null);
		} else {
			PpmDac ppmDac = ppmDacService.get(contratsRequestDto.getIdDac());
			entity.setPpmDac(ppmDac);
		}
		
		repository.save(entity);
		return GbcMapper2.contratsToContratsResponseDto(entity);
	}
	
	@Override
	public List<ContratsResponseDto> getAll() {
		List<Contrats> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.contratsToContratsResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public Contrats get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Contrats with id: " + id + " could not be found"));
	}
	
	@Override
	public ContratsResponseDto getById(Long id) {
		Contrats entity = get(id);
		return GbcMapper2.contratsToContratsResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ContratsResponseDto delete(Long id) {
		Contrats entity = get(id);
		repository.delete(entity);
		return GbcMapper2.contratsToContratsResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public ContratsResponseDto edit(Long id, ContratsRequestDto contratsRequestDto) {
		int numeroOrdreContratAccordCadre = repository.getNumeroContratAccordCadre(contratsRequestDto.getAnnee(), contratsRequestDto.getIdBudget());
		
		Contrats entity = get(id);
		String reference = entity.getReference();
		
		entity.setCod1(contratsRequestDto.getCod1());
		entity.setCod2(contratsRequestDto.getCod2());
		entity.setCod3(contratsRequestDto.getCod3());
		entity.setCod4(contratsRequestDto.getCod4());
		entity.setCod5(contratsRequestDto.getCod5());
		entity.setObjet(contratsRequestDto.getObjet());
		
		if (contratsRequestDto.getMleAuto() == true) {
			if (contratsRequestDto.getCodIdentiteExecution().equals("04") && entity.getCodIdentiteExecution().equals("04")) {// SI LE CONTRAT RESTE ACCORD-CADRE, LE NUMERO D'ORDRE NE CHANGERA PAS
				entity.setReference(contratsRequestDto.getCod1() + "/" + contratsRequestDto.getCod2() + "/" + contratsRequestDto.getCodTypeMarche() + "/" + contratsRequestDto.getCodIdentiteExecution() + "/" + contratsRequestDto.getCod3() + "/" + contratsRequestDto.getCod4() + "/" + contratsRequestDto.getCod5() + "/" + contratsRequestDto.getAnnee() + "/" + String.format("%05d", entity.getNumero()) + "-" + String.format("%02d", Integer.valueOf(reference.substring(reference.length() - 2))));
			} else if (contratsRequestDto.getCodIdentiteExecution() != "04" && entity.getCodIdentiteExecution().equals("04")) {// SI LE CONTRAT N'EST PLUS ACCORD-CADRE, LE NUMERO D'ORDRE NE CHANGERA PAS
				entity.setReference(contratsRequestDto.getCod1() + "/" + contratsRequestDto.getCod2() + "/" + contratsRequestDto.getCodTypeMarche() + "/" + contratsRequestDto.getCodIdentiteExecution() + "/" + contratsRequestDto.getCod3() + "/" + contratsRequestDto.getCod4() + "/" + contratsRequestDto.getCod5() + "/" + contratsRequestDto.getAnnee() + "/" + String.format("%05d", entity.getNumero()));
			} else if (contratsRequestDto.getCodIdentiteExecution().equals("04") && entity.getCodIdentiteExecution() != "04") { // ON VEUT METTRE LE CONTRAT A ACCORD CADRE
				entity.setReference(contratsRequestDto.getCod1() + "/" + contratsRequestDto.getCod2() + "/" + contratsRequestDto.getCodTypeMarche() + "/" + contratsRequestDto.getCodIdentiteExecution() + "/" + contratsRequestDto.getCod3() + "/" + contratsRequestDto.getCod4() + "/" + contratsRequestDto.getCod5() + "/" + contratsRequestDto.getAnnee() + "/" + String.format("%05d", entity.getNumero()) + "-" + String.format("%02d", numeroOrdreContratAccordCadre));
			} else if (contratsRequestDto.getCodIdentiteExecution() != "04" && entity.getCodIdentiteExecution() != "04") {
				entity.setReference(contratsRequestDto.getCod1() + "/" + contratsRequestDto.getCod2() + "/" + contratsRequestDto.getCodTypeMarche() + "/" + contratsRequestDto.getCodIdentiteExecution() + "/" + contratsRequestDto.getCod3() + "/" + contratsRequestDto.getCod4() + "/" + contratsRequestDto.getCod5() + "/" + contratsRequestDto.getAnnee() + "/" + String.format("%05d", entity.getNumero()));
			}
		} else {
			entity.setReference(contratsRequestDto.getReference());
		}
		
		entity.setDelaiNbre(contratsRequestDto.getDelaiNbre());
		entity.setDelaiText(contratsRequestDto.getDelaiText());
		entity.setDateSaisie(contratsRequestDto.getDateSaisie());
		entity.setDateApprob(contratsRequestDto.getDateApprob());
		entity.setActeRef(contratsRequestDto.getActeRef());
		entity.setRefNotif(contratsRequestDto.getRefNotif());
		entity.setDateDemmar(contratsRequestDto.getDateDemmar());
		entity.setMleAuto(contratsRequestDto.getMleAuto());
		entity.setRefPassation(contratsRequestDto.getRefPassation());
		entity.setRefArt(contratsRequestDto.getRefArt());
		entity.setTauxappli(contratsRequestDto.getTauxappli());
		entity.setSuspens(contratsRequestDto.getSuspens());
		entity.setIdcompte(contratsRequestDto.getIdcompte());
		entity.setMontantMaxHtva(contratsRequestDto.getMontantMaxHtva());
		entity.setMontantMinHtva(contratsRequestDto.getMontantMinHtva());
		entity.setMontantMaxTtc(contratsRequestDto.getMontantMaxTtc());
		entity.setMontantMinTtc(contratsRequestDto.getMontantMinTtc());
		entity.setAvecTva(contratsRequestDto.getAvecTva());
		entity.setAvecMiniMax(contratsRequestDto.getAvecMiniMax());
		entity.setDelaiAn(contratsRequestDto.getDelaiAn());
		entity.setDelaiMois(contratsRequestDto.getDelaiMois());
		entity.setDelaiSemaine(contratsRequestDto.getDelaiSemaine());
		entity.setDelaiJours(contratsRequestDto.getDelaiJours());
		entity.setUserUpdate(contratsRequestDto.getUserUpdate());
		entity.setDateUpdate(contratsRequestDto.getDateUpdate());
		entity.setIdContratParent(contratsRequestDto.getIdContratParent());
		entity.setAbrevEpe(contratsRequestDto.getAbrevEpe());
		entity.setDateAttribution(contratsRequestDto.getDateAttribution());
		entity.setCodTypeMarche(contratsRequestDto.getCodTypeMarche());
		entity.setCodIdentiteExecution(contratsRequestDto.getCodIdentiteExecution());
		entity.setIdPpmExe(contratsRequestDto.getIdPpmExe());
		entity.setIdLot(contratsRequestDto.getIdLot());
		entity.setCodBud(contratsRequestDto.getCodBud());
		entity.setIdSrceFin(contratsRequestDto.getIdSrceFin());
		
		if (contratsRequestDto.getIdBudget() != null) {
			BudgetType budgetType = budgetTypeService.get(contratsRequestDto.getIdBudget());
			entity.setBudgetType(budgetType);
		}
		
		if (contratsRequestDto.getType() != null) {
			ContratType contratType = contratTypeService.get(contratsRequestDto.getType());
			entity.setContratType(contratType);
		}
		
		if (contratsRequestDto.getIdFourn() != null) {
			Destinataires destinataires = destinatairesService.get(contratsRequestDto.getIdFourn());
			entity.setDestinataires(destinataires);
		}
		
		if (contratsRequestDto.getIdDac() == null) {
			entity.setPpmDac(null);
		} else {
			PpmDac ppmDac = ppmDacService.get(contratsRequestDto.getIdDac());
			entity.setPpmDac(ppmDac);
		}
		
		return GbcMapper2.contratsToContratsResponseDto(entity);
	}
}
