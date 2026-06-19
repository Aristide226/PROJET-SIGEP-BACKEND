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

import com.sigep.gim.dto.requestDto.EtatFicheRequestDto;
import com.sigep.gim.dto.responseDto.EtatFicheResponseDto;
import com.sigep.gim.entity.EtatFiche;
import com.sigep.gim.repository.GimEtatFicheRepository;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@RequiredArgsConstructor
public class GimEtatFicheServiceImpl implements GimEtatFicheService {
	
	private final GimEtatFicheRepository repository;
	private final ModelMapper modelMapper;
	
	@Autowired
    @Qualifier("gimDataSource")
    private DataSource dataSource;
	
	@Override
	@Transactional
	public EtatFicheResponseDto add(EtatFicheRequestDto etatFicheRequestDto) {
		EtatFiche entity = new EtatFiche();
		entity.setEtat(etatFicheRequestDto.getEtat());
		entity.setLibEtat(etatFicheRequestDto.getLibEtat());
		repository.save(entity);
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	public List<EtatFicheResponseDto> getAll() {
		List<EtatFiche> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, EtatFicheResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public EtatFiche get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("EtatFiche with id "+id+"could not be found")
		);
	}
	
	@Override
	public EtatFicheResponseDto getById(String id) {
		EtatFiche entity = get(id);
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public EtatFicheResponseDto delete(String id) {
		EtatFiche entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public EtatFicheResponseDto edit(String id,EtatFicheRequestDto etatFicheRequestDto) {
		EtatFiche entity = get(id);
		entity.setLibEtat(etatFicheRequestDto.getLibEtat());
		return modelMapper.map(entity, EtatFicheResponseDto.class);
	}
	
	@Override
	public byte[] etatFicheReport() throws JRException, FileNotFoundException {
	    final String cheminDuRapport = "gim/etatsDeFiche.jrxml";

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
