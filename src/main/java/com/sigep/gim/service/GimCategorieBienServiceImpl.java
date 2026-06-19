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

import com.sigep.gim.dto.requestDto.CategorieBienRequestDto;
import com.sigep.gim.dto.responseDto.CategorieBienResponseDto;
import com.sigep.gim.entity.CategorieBien;
import com.sigep.gim.repository.GimCategorieBienRepository;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@RequiredArgsConstructor
public class GimCategorieBienServiceImpl implements GimCategorieBienService {
	
	private final GimCategorieBienRepository repository;
	private final ModelMapper modelMapper;
	
	@Autowired
    @Qualifier("gimDataSource")
    private DataSource dataSource;
	
	@Override
	@Transactional
	public CategorieBienResponseDto add(CategorieBienRequestDto categorieBienRequestDto) {
		
		int maxCodCategorie = findMaxCodCategorie() + 1;
		CategorieBien entity = new CategorieBien();
		entity.setCodCategorie(maxCodCategorie);
		entity.setLibCategorieBien(categorieBienRequestDto.getLibCategorieBien());
		repository.save(entity);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	public List<CategorieBienResponseDto> getAll() {
		List<CategorieBien> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, CategorieBienResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CategorieBien get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CategorieBien with id "+id+"could not be found")
		);
	}
	
	@Override
	public CategorieBienResponseDto getById(int id) {
		CategorieBien entity = get(id);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public CategorieBienResponseDto delete(int id) {
		CategorieBien entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public CategorieBienResponseDto edit(int id,CategorieBienRequestDto categorieBienRequestDto) {
		CategorieBien entity = get(id);
		return modelMapper.map(entity, CategorieBienResponseDto.class);
	}
	
	@Override
	@Transactional
	public Integer findMaxCodCategorie() {
		return repository.findMaxCodCategorie();
	}
	
	@Override
	public byte[] categorieBienReport() throws JRException, FileNotFoundException {
	    final String cheminDuRapport = "gim/CategorieBien.jrxml";

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
