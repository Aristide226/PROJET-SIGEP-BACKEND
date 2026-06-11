package com.sigep.gbc.model;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class InfosPourReceptionnerBordTransmis {
	private List<Long> ids;
	private Date date;
	private String idUser;
}
