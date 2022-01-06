package com.web.api.server.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.web.api.server.model.ServicoModel;
import com.web.api.server.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public ServicoModel atualizar(Long codigo, ServicoModel servicoModel) {
		ServicoModel servicoSalva = buscarPeloCodigo(codigo);

		BeanUtils.copyProperties(servicoModel, servicoSalva, "codigo");
		return this.servicoRepository.save(servicoSalva);
	}
	
	public ServicoModel buscarPeloCodigo(Long codigo) {
		ServicoModel servicoSalva = servicoRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return servicoSalva;
	}
}
