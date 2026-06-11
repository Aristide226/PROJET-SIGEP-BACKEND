package com.sigep.grh.orchestration;
// LES ORCHESTRATION SONT DES SERVICE ET PEUVENT AVOIR SERVICE IMPL POUR DES CAS COMPLEXE
// CE ORCHESTRATION CENTRALISE LA LOGIQUE MULTI-MODULE POUR LE LOGIN
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sigep.gbc.facade.GbcAccesCodeFacade;
import com.sigep.grh.dto.AccesCodeDto;
import com.sigep.grh.service.GrhAccesCodeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrhLoginService {
	
	private final GrhAccesCodeService grhAccesCodeService;  
	private final Optional<GbcAccesCodeFacade> gbcAccesCodeFacade;
	private final ModelMapper modelMapper;
	private static final Logger log = LoggerFactory.getLogger(GrhAccesCodeService.class);
	
	public List<AccesCodeDto> getAllAccesCodesForLogin() {
		// Les utilisateurs de GRH (toujours présents)
		List<AccesCodeDto> grhUsers = grhAccesCodeService.getAll();
		// Les utilisateurs de GBC (Optionnel et sécurisé)
		List<AccesCodeDto> gbcUsers = gbcAccesCodeFacade.map(this::safeGetGbcUsers).orElse(List.of());
		// Fusion
		return Stream.concat(grhUsers.stream(), gbcUsers.stream()).toList();
	}
	
	private List<AccesCodeDto> safeGetGbcUsers(GbcAccesCodeFacade facade) {
		try {
			return facade.getAll()
					.stream()
					.map(element  -> modelMapper.map(element, AccesCodeDto.class))
					.toList();
		} catch (Exception e) {
			log.warn("GBC indisponible", e);
			return List.of();
		}
	}
	
}
