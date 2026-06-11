package com.sigep.gim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TypeBienStatistiqueDto {
	private Integer codTyp;
    private String intituleTyp;

    private Long bon;
    private Long passable;
    private Long delabre;
    private Long mauvais;
    private Long enPanne;

    private Long nombreTotal;
}
