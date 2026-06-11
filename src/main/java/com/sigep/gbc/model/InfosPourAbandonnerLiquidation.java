package com.sigep.gbc.model;


import java.util.Date;

import lombok.Data;

@Data
public class InfosPourAbandonnerLiquidation {
	private Long id;
	private Date date;
	private String idUser;
}
