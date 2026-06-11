package com.sigep.gim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinancementStatistiqueDto {
	private String codSourceFin;
	private String libSourceFin;
	private Long nombreTotalGeneral;
    private Long nombreTotalBatiments;
    private Long nombreTotalMateriels;
}
