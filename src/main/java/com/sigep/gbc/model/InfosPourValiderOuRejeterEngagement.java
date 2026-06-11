package com.sigep.gbc.model;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class InfosPourValiderOuRejeterEngagement {
	private List<IdEngAction> idEngActions;
	private Date date;
	private String idUser;
}
