package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.view.dto.FournisseursViewDto;


@Service
public interface FournisseursViewService {
	public List<FournisseursViewDto> getAll();
}
