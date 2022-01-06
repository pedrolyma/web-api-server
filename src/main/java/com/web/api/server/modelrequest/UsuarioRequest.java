package com.web.api.server.modelrequest;

import java.util.Optional;

import com.web.api.server.model.EmpresaModel;
import com.web.api.server.model.UsuarioModel;
import com.web.api.server.repositories.EmpresaRepository;

public class UsuarioRequest {

	private String Nomeusuario;
	private String emailusuario;
	
	private String Senhausuario;
	private Long id_empresa;
	
	public void setNomeusuario(String nomeusuario) {
		Nomeusuario = nomeusuario;
	}
	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}
	public void setSenhausuario(String senhausuario) {
		Senhausuario = senhausuario;
	}
	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public UsuarioModel converter(EmpresaRepository empresaRepository) {
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		return new UsuarioModel(Nomeusuario, emailusuario, Senhausuario, empresaModel.get());
    }
}
