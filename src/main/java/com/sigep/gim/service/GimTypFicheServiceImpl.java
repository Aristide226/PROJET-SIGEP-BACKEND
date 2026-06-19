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

import com.sigep.gim.dto.requestDto.TypFicheRequestDto;
import com.sigep.gim.dto.responseDto.TypFicheResponseDto;
import com.sigep.gim.entity.TypFiche;
import com.sigep.gim.repository.GimTypFicheRepository;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@RequiredArgsConstructor
public class GimTypFicheServiceImpl implements GimTypFicheService {
	
	private final GimTypFicheRepository repository;
	private final ModelMapper modelMapper;
	
	
	@Autowired
    @Qualifier("gimDataSource")
    private DataSource dataSource;
	
	@Override
	@Transactional
	public TypFicheResponseDto add(TypFicheRequestDto typFicheRequestDto) {
		TypFiche entity = new TypFiche();
		entity.setIdTypFiche(typFicheRequestDto.getIdTypFiche());
		entity.setLibTypFiche(typFicheRequestDto.getLibTypFiche());
		repository.save(entity);
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	public List<TypFicheResponseDto> getAll() {
		List<TypFiche> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, TypFicheResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public TypFiche get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("TypFiche with id "+id+"could not be found")
		);
	}
	
	@Override
	public TypFicheResponseDto getById(String id) {
		TypFiche entity = get(id);
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypFicheResponseDto delete(String id) {
		TypFiche entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	@Transactional
	public TypFicheResponseDto edit(String id,TypFicheRequestDto typFicheRequestDto) {
		TypFiche entity = get(id);
		entity.setLibTypFiche(typFicheRequestDto.getLibTypFiche());
		return modelMapper.map(entity, TypFicheResponseDto.class);
	}
	
	@Override
	public byte[] typFicheReport() throws JRException, FileNotFoundException {
	    final String cheminDuRapport = "gim/TypesDeFiches.jrxml";

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
