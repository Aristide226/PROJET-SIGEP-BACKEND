package com.sigep.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigep.gbc.entity.ReportDetail;
import com.sigep.gbc.entity.ReportDetailId;

@Repository
public interface ReportDetailRepository extends JpaRepository<ReportDetail, ReportDetailId>{

}
