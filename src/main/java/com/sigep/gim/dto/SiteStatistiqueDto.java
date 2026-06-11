package com.sigep.gim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiteStatistiqueDto {
	private int codeSite;
    private String nomSite;
    private Long nombreTotalGeneral;
    private Long nombreTotalBatiments;
    private Long nombreTotalMateriels;
}
