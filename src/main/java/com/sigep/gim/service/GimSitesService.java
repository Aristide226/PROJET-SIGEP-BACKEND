package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.SiteStatistiqueDto;
import com.sigep.gim.dto.requestDto.SitesRequestDto;
import com.sigep.gim.dto.responseDto.SitesResponseDto;
import com.sigep.gim.entity.Sites;

@Service
public interface GimSitesService {
	public SitesResponseDto add(SitesRequestDto sitesRequestDto);
	public List<SitesResponseDto> getAll();
	public Sites get(int id);
	public SitesResponseDto getById(int id);
	public SitesResponseDto delete(int id);
	public SitesResponseDto edit(int id, SitesRequestDto sitesRequestDto);
	public List<SiteStatistiqueDto> getStatistiquesPatrimoineParCategorie();
}