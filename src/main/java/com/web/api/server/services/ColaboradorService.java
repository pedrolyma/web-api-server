package com.web.api.server.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.web.api.server.model.ColaboradorModel;
import com.web.api.server.model.ServicoModel;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.ServicoRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public ColaboradorModel atualizar(Long codigo, ColaboradorModel colaboradorModel) {
		ColaboradorModel colaboradorSalva = buscarPeloCodigo(codigo);

		BeanUtils.copyProperties(colaboradorModel, colaboradorSalva, "codigo");
		return this.colaboradorRepository.save(colaboradorSalva);
	}
	
	public ColaboradorModel buscarPeloCodigo(Long codigo) {
		ColaboradorModel colaboradorSalva = colaboradorRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return colaboradorSalva;
	}
}
