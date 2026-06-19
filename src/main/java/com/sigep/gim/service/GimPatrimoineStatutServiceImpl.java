package com.sigep.gim.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineStatutRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineStatutResponseDto;
import com.sigep.gim.entity.PatrimoineStatut;
import com.sigep.gim.repository.GimPatrimoineStatutRepository;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@RequiredArgsConstructor
public class GimPatrimoineStatutServiceImpl implements GimPatrimoineStatutService {
	
	private final GimPatrimoineStatutRepository repository;
	private final ModelMapper modelMapper;
	
	@Autowired
    @Qualifier("gimDataSource")
    private DataSource dataSource;
	
	@Override
	@Transactional
	public PatrimoineStatutResponseDto add(PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatut entity = new PatrimoineStatut();
		entity.setStatPatri(patrimoineStatutRequestDto.getStatPatri());
		entity.setLibelStatPatri(patrimoineStatutRequestDto.getLibelStatPatri());
		repository.save(entity);
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	
	@Override
	public List<PatrimoineStatutResponseDto> getAll() {
		List<PatrimoineStatut> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, PatrimoineStatutResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public PatrimoineStatut get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("PatrimoineStatut with id "+id+"could not be found")
		);
	}
	
	@Override
	public PatrimoineStatutResponseDto getById(String id) {
		PatrimoineStatut entity = get(id);
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	
	@Override
	@Transactional
	public PatrimoineStatutResponseDto delete(String id) {
		PatrimoineStatut entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	
	@Override
	@Transactional
	public PatrimoineStatutResponseDto edit(String id,PatrimoineStatutRequestDto patrimoineStatutRequestDto) {
		PatrimoineStatut entity = get(id);
		entity.setLibelStatPatri(patrimoineStatutRequestDto.getLibelStatPatri());
		return modelMapper.map(entity, PatrimoineStatutResponseDto.class);
	}
	 
	@Override
	public byte[] statutBienReport() throws JRException, FileNotFoundException {
	    final String cheminDuRapport = "gim/StatutDeBien.jrxml";

	    try (
	        InputStream inputStream = getClass().getClassLoader()
	                .getResourceAsStream(cheminDuRapport)
	    ) {
	        if (inputStream == null) {
	            throw new FileNotFoundException(
	                "Ressource JRXML introuvable : " + cheminDuRapport
	            );
	        }

	        JasperReport mainReport = JasperCompileManager.compileReport(inputStream);

	        Map<String, Object> parameters = new HashMap<>();

	        try (Connection connection = dataSource.getConnection()) {
	            JasperPrint jasperPrint = JasperFillManager.fillReport(
	                    mainReport, parameters, connection
	            );
	            return JasperExportManager.exportReportToPdf(jasperPrint);
	        }

	    } catch (SQLException e) {
	        throw new JRException("Erreur de connexion à la base de données : " + e.getMessage(), e);
	    } catch (JRException e) {
	        throw e;
	    } catch (Exception e) {
	        throw new JRException("Erreur lors de la génération du rapport : " + e.getMessage(), e);
	    }
	}
}
