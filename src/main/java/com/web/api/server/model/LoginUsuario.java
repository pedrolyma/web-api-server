package com.web.api.server.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginUsuario {

	private String Emailusuario;
	private String Senhausuario;
	
	public void setEmailusuario(String emailusuario) {
		Emailusuario = emailusuario;
	}
	public void setSenhausuario(String senhausuario) {
		Senhausuario = senhausuario;
	}
	public String getEmailusuario() {
		return Emailusuario;
	}
	public String getSenhausuario() {
		return Senhausuario;
	}
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(Emailusuario, Senhausuario);
	}
	
}
