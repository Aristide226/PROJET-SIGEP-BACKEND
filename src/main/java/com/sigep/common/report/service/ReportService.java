package com.sigep.common.report.service;


import org.springframework.stereotype.Service;

import com.sigep.common.report.model.Report;




@Service
public interface ReportService {
	public byte[] createReport(Report report);
}
