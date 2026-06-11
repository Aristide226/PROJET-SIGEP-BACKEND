package com.sigep.common.report.service;

import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.stereotype.Service;

import com.sigep.common.report.exception.ReportNotFoundException;
import com.sigep.common.report.exception.ReprotGenerationException;
import com.sigep.common.report.model.Param;
import com.sigep.common.report.model.Report;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	
	private final DataSource dataSource;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

	@Override
	public byte[] createReport(Report report) {
		try {
			// CHARGER LE FICHIER .JRXM
			InputStream reportStream = getClass().getClassLoader().getResourceAsStream("reports/" + report.getName() + ".jrxml");
			if (reportStream == null) throw new ReportNotFoundException("Rapport non trouvé :" + report.getName());
			
			// COMPILER LE RAPPORT 
			JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
			
			// LES PARAMETTRES
			Map<String, Object> parameters = new HashMap<>();
			for (Param param: report.getParams()) {
				if (param.getKey().startsWith("date")) {
					try {
						parameters.put(param.getKey(),  new java.sql.Date(formatter.parse(param.getValue().toString()).getTime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (param.getKey().startsWith("SUBREPORT")) {
					parameters.put(param.getKey(), JasperCompileManager.compileReport(getClass().getClassLoader().getResourceAsStream("reports/" + param.getValue() + ".jrxml")));	
				} else {
					parameters.put(param.getKey(), param.getValue());
				}
			}
			
			// REMPLIR LE RAPPORT AVEC LES DONNEES
			Connection connection = dataSource.getConnection();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            return JasperExportManager.exportReportToPdf(jasperPrint);
            
		} catch (JRException e) {
			// GERER LES ERREURS DE JASPER REPORT
			throw new ReprotGenerationException("Erreur lors de la generation du rapport", e);
		} catch (Exception e) {
			// GERER LES AUTRES ERREURS
	        throw new ReprotGenerationException("Erreur inattendue lors de la génération du rapport", e); 
	    }
	}
}
