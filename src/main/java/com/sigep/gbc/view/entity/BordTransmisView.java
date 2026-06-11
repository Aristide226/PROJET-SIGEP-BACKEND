package com.sigep.gbc.view.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BordTransmisView {
	
	@Id
	@Column(name = "CodBord", unique = true, nullable = false, precision = 18, scale = 0)
	private long codBord;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "Dossier")
	private String dossier;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateCreation", length = 23)
	private Date dateCreation;
	
	@Column(name = "Expeditaire")
	private String expeditaire;
	
	@Column(name = "Destinataire")
	private String destinataire;
	
	@Column(name = "IdLogin", nullable = false, length = 5)
	private String idLogin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateReception", length = 23)
	private Date dateReception;
	
	@Column(name = "IdLoginRecep", length = 5)
	private String idLoginRecep;
	
	@Column(name = "Numero")
	private Integer numero;
	
	@ReadOnlyProperty
	@Column(name = "BordNumero", length = 250, insertable = false)
	private String bordNumero;
	
	@Column(name = "IdBudget", nullable = false)
	private Integer idBudget;
	
	@Column(name = "IdentiteRecept", length = 150)
	private String identiteRecept;
	
	@Column(name = "NombreEng")
	private long nombreEng;
}
