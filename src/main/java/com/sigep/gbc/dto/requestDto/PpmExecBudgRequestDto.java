//Aristide
package com.sigep.gbc.dto.requestDto;

import lombok.Data;

@Data
public class PpmExecBudgRequestDto {
    private int idPpmExe;
    private int idLot;
    private Integer idBudget;
    private short exercice;
    private String codBud;
    private String idSrceFin;

    private Long montantEstime;
    
    private long montantMaxHtva;
    private long montantMinHtva;
    private long montantMaxTtc;
    private long montantMinTtc;
    private boolean avecTva;
    private boolean avecMiniMax;
}