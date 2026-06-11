package com.sigep.common.report.model;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Report {
	//private Long id;
	private String name;
	private List<Param> params = new ArrayList<>();
}
