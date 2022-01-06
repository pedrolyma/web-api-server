package com.web.api.server.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.web.api.server.model.ClienteModel;
import com.web.api.server.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteModel atualizar(Long codigo, ClienteModel clienteModel) {
		ClienteModel clienteSalva = buscarPeloCodigo(codigo);

		BeanUtils.copyProperties(clienteModel, clienteSalva, "codigo");
		return this.clienteRepository.save(clienteSalva);
	}
	
	public ClienteModel buscarPeloCodigo(Long codigo) {
		ClienteModel clienteSalva = clienteRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return clienteSalva;
	}

}
