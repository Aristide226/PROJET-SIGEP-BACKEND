package com.sigep.gim.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gim.dto.CodeAccesAgentDto;
import com.sigep.gim.dto.CodeAccesDto;
import com.sigep.gim.entity.CodeAcces;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimCodeAccesRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional("gimTransactionManager")
@RequiredArgsConstructor
public class GimCodeAccesServiceImpl implements GimCodeAccesService {
	
	private final GimCodeAccesRepository repository;
	private final GimAgentsService gimAgentsService;
	private final GimCodeAccesTypeService gimCodeAccesTypeService;
	
	@Override
	public CodeAccesDto add(CodeAccesDto codeAccesDto) {
		
		int idUser = repository.getIdUser();
		String userName = "GIM";
		if (idUser < 10) {
			userName = userName + '0' + String.valueOf(idUser);
		}else {
			userName = userName + String.valueOf(idUser);
		}
		
		repository.insert(
				idUser,
				userName,
				"uslKZiTsQ/aqFjz2FZnVQw==", 
				codeAccesDto.getMotDePasse(),
				codeAccesDto.isEtat(),
				codeAccesDto.getNbreConnect(),
				codeAccesDto.getNbreCpte(),
				new Date(),
				codeAccesDto.getMleAgent(),
				codeAccesDto.getIdCodeAccessType());
		
		CodeAcces entity = new CodeAcces();
		entity.setIdUser(idUser);
		entity.setUserName(userName);
		entity.setPassWord("uslKZiTsQ/aqFjz2FZnVQw==");
		entity.setMotDePasse(codeAccesDto.getMotDePasse());
		entity.setEtat(codeAccesDto.isEtat());
		entity.setNbreConnect(codeAccesDto.getNbreConnect());
		entity.setNbreCpte(codeAccesDto.getNbreCpte());
		entity.setDateChangement(new Date());
		entity.setAgents(gimAgentsService.get(codeAccesDto.getMleAgent()));
		entity.setCodeAccesType(gimCodeAccesTypeService.get(codeAccesDto.getIdCodeAccessType()));
		
		return GimMapper.codeAccesDtoToCodeAccesDto(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CodeAccesDto> getAll() {
		List<CodeAcces> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.codeAccesDtoToCodeAccesDto(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public CodeAcces get(int id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CodeAcces with id "+id+"could not be found")
		);
	}

	@Override
	@Transactional(readOnly = true)
	public CodeAccesDto getById(int id) {
		CodeAcces entity = get(id);
		return GimMapper.codeAccesDtoToCodeAccesDto(entity);
	}

	@Override
	public CodeAccesDto delete(int id) {
		CodeAcces entity = get(id);
		repository.delete(entity);
		return GimMapper.codeAccesDtoToCodeAccesDto(entity);
	}

	@Override
	public CodeAccesDto edit(int id, CodeAccesDto codeAccesDto) {
		repository.update(
				codeAccesDto.getMotDePasse(), 
				codeAccesDto.isEtat(), 
				codeAccesDto.getNbreConnect(), 
				codeAccesDto.getNbreCpte(), 
				new Date(), 
				codeAccesDto.getMleAgent(), 
				codeAccesDto.getIdCodeAccessType(),
				id);
		
		CodeAcces codeAcces = get(id);
		return GimMapper.codeAccesDtoToCodeAccesDto(codeAcces);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CodeAccesAgentDto> getUtilisateur() {
		return repository.getUtilisateur();
	}

	@Override
	public CodeAccesDto getByUserName(String username) {
		CodeAcces entity = repository.findByUserName(username);
		return GimMapper.codeAccesDtoToCodeAccesDto(entity);
	}
}
