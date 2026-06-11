package com.sigep.gbc.dto.responseDto;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.BordMandId;
import com.sigep.gbc.entity.ChequesVirementsId;
import com.sigep.gbc.entity.MandatPecId;
import com.sigep.gbc.entity.PieceJustifComplementId;

import lombok.Data;

@Data
public class MandatsResponseDto {
	private Long numMand;
	private Integer mandNum;
	private Date dateMand;
	private Long montant;
	private Date dateEtat;
	private Date datePaie;
	private Long montantPaie;
	private String idCompte;
	private String idUser;
	private Date datePosition;
	private Integer benum;
	private Integer numBl;
	private String objet;
	private Long montEngage;
	private Long montDjaLiq;
	private Date dateEtatBl;
	private Date datePec;
	private Boolean receptionne;
	private Boolean genererOv;
	private Boolean avecReversement;
	private Long precompte;
	private Date datePrecompte;
	private String userPrecompte;
	private Date dateValid;
	private Long idFiche;
	private Long montantTotalPec;
	private Date dateCreat;
	private Boolean estOrdre;
	private Integer mandNumApresVisaCf;
	private Integer idEtatTransL;
	private Integer idEtatTransM;
	private String idBordEmis;
	private Long idBord;
	private String codBud;
	private Integer idBudget;
	private String compteFourn;
	private Long idContrat;
	private Long idForun;
	private Short gestion;
	private Long codLiq;
	private String idLettrage;
	private String idModePaie;
	private Long numBe;
	private String etat;
	private String etatBl;
	private Long numMandParent;
	private List<Long> codBordsBordTransMand;
	private List<Long> codBordsBordTransLiq;
	private List<String> idRetenusQuitOrdres;
	private Long idMandatsCloture;
	private List<PieceJustifComplementId> pieceJustifComplemenIds;
	private List<Long> idCompteMouvementMandRs;
	private List<String> idRetenuTitreRecouvs;
	private List<String> idMandLettragPaies;
	private List<ChequesVirementsId> chequesVirementsIds;
	private List<String> codRecouvs;
	private List<Long> numMands;
	private List<BigInteger> idPieceJournalsForNumMand;
	private List<BigInteger> idPieceJournalsForIdMandRetenu;
	private List<String> idJustifs;
	private List<MandatPecId> mandatPecIds;
	private List<BordMandId> bordMandIds;
	private List<String> idRetenus;
}
