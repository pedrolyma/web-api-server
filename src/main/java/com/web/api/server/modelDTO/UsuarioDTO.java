package com.web.api.server.modelDTO;

import org.springframework.data.domain.Page;

import com.web.api.server.model.UsuarioModel;

public class UsuarioDTO {
	
	private Long Idusuario;
	private String Nomeusuario;
	private String emailusuario;
	private String Razaosocial;

	public UsuarioDTO(UsuarioModel usuarioModel) {
		this.Idusuario = usuarioModel.getIdusuario();
		this.Nomeusuario = usuarioModel.getNomeusuario();
		this.emailusuario = usuarioModel.getEmailusuario();
		this.Razaosocial = usuarioModel.getEmpresaModel().getRazaosocial();
	}

	public Long getIdusuario() {
		return Idusuario;
	}

	public String getNomeusuario() {
		return Nomeusuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public String getRazaosocial() {
		return Razaosocial;
	}
	
	public static Page<UsuarioDTO> converter(Page<UsuarioModel> usuarioModel) {
		return usuarioModel.map(UsuarioDTO::new);
	}
}
