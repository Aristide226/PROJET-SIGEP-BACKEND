package com.sigep.gbc.dto.responseDto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class EnteteStructureResponseDto {
    private String abrevEpe;
	private String section;
	private String epe;
	private String lieu;
	private byte[] logo;
	private String signataireDg;
	private String nomSignataireDg;
	private String titreHonorifiqueDg;
	private String signataireDaf;
	private String nomSignataireDaf;
	private String titreHonorifiqueDaf;
	private String signataireCf;
	private String nomSignataireCf;
	private String titreHonorifiqueCf;
	private String signataireAc;
	private String nomSignataireAc;
	private String titreHonorifiqueAc;
	private Boolean cfresident;
	private Boolean signatPenal;
	private String adresse;
	private String telephone;
	private String fax;
	private String email;
	private String visa;
	private String articleStruct;
	private String nomPays;
	private String devisePays;
	private String mleCnss;
	private String mleCarfo;
	private int typeSupport;
	private boolean avecReception;
	private byte[] quitFiligrane;
	private BigDecimal tauxTva;
	private char typeAmmortDefaut;
	private boolean gbc;
	private boolean gim;
	private boolean grh;
	private String sectionNum;
	private byte[] filgraneL276cmH185cm;
	private String signataireDrh;
	private String nomSignataireDrh;
	private String titreHonorifiqueDrh;
	private int idCircuitGrh;
	private boolean drhsigneEtat;
	private String libAnnee;
	
	private int mandNumApresVisaCf;
	private List<String> enteteCodUsers;
}
