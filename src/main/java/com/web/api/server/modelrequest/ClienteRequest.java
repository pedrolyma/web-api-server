package com.web.api.server.modelrequest;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.web.api.server.model.ClienteModel;
import com.web.api.server.model.EmpresaModel;
import com.web.api.server.repositories.EmpresaRepository;

public class ClienteRequest {

	@NotNull 
	private String Nomecliente;
	private String Logradourocliente;
	private String Telefonecliente;
	@NotNull
	private String Whatsappcliente;
	private String Tiktokcliente;
	private String Twittercliente;
	private String Instagrancliente;
	private Long id_empresa;
	
	public void setNomecliente(String nomecliente) {
		Nomecliente = nomecliente;
	}

	public void setLogradourocliente(String logradourocliente) {
		Logradourocliente = logradourocliente;
	}

	public void setTelefonecliente(String telefonecliente) {
		Telefonecliente = telefonecliente;
	}

	public void setWhatsappcliente(String whatsappcliente) {
		Whatsappcliente = whatsappcliente;
	}

	public void setTiktokcliente(String tiktokcliente) {
		Tiktokcliente = tiktokcliente;
	}

	public void setTwittercliente(String twittercliente) {
		Twittercliente = twittercliente;
	}

	public void setInstagrancliente(String instagrancliente) {
		Instagrancliente = instagrancliente;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public ClienteModel converter(EmpresaRepository empresaRepository) {
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		return new ClienteModel(Nomecliente, Logradourocliente, Telefonecliente, Whatsappcliente, Tiktokcliente, Twittercliente, Instagrancliente, empresaModel.get());
	}
}
