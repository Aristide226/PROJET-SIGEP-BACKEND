//Aristide
package com.sigep.gbc.dto.responseDto;

import lombok.Data;

@Data
public class PpmExecBudgResponseDto {
    private int idPpmExe;
    private int idLot;
    private Integer idBudget;
    private short exercice;
    private String codBud;
    private String idSrceFin;
    
    private long montantEstime;
    
    private long montantMaxHtva;
    private long montantMinHtva;
    private long montantMaxTtc;
    private long montantMinTtc;
    private boolean avecTva;
    private boolean avecMiniMax;
    
}