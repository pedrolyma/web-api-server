package com.web.api.server.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.web.api.server.model.HorarioModel;
import com.web.api.server.repositories.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository horarioRepository;
	
	public HorarioModel atualizar(Long codigo, HorarioModel horarioModel) {
		HorarioModel horarioSalvo = buscarPeloCodigo(codigo);

		BeanUtils.copyProperties(horarioModel, horarioSalvo, "codigo");
		return this.horarioRepository.save(horarioSalvo);
	}
	
	public HorarioModel buscarPeloCodigo(Long codigo) {
		HorarioModel horarioSalvo = horarioRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return horarioSalvo;
	}
}
