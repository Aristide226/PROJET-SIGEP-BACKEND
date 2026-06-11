package com.sigep.gbc.model;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class InfosPourValiderEngagement {
	private List<Long> ids;
	private Date date;
	private String idUser;
}
