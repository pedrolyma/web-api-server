package com.web.api.server.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.web.api.server.model.EmpresaModel;
import com.web.api.server.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public EmpresaModel atualizar(Long codigo, EmpresaModel empresaModel) {
		EmpresaModel empresaSalva = buscarPeloCodigo(codigo);

		BeanUtils.copyProperties(empresaModel, empresaSalva, "codigo");
		return this.empresaRepository.save(empresaSalva);
	}
	
	public EmpresaModel buscarPeloCodigo(Long codigo) {
		EmpresaModel empresaSalva = empresaRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return empresaSalva;
	}
}
