package com.sigep.gim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeBudgetaireStatistiqueDto {
	private int codBud;
	private String intituleCodBud;

    private Long bon;
    private Long passable;
    private Long delabre;
    private Long mauvais;

    private Long nombreTotal;
}
