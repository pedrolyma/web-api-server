package com.web.api.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idusuario;
	@NotNull
	private String Nomeusuario;
	private String emailusuario;
    private String Senhausuario;
	@JoinColumn(name = "id_empresa")
	@ManyToOne
	private EmpresaModel empresaModel;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(String Nomeusuario, String emailusuario, String Senhausuario, EmpresaModel empresaModel) {
	this.Nomeusuario = Nomeusuario;
	this.emailusuario = emailusuario;
	this.Senhausuario = Senhausuario;
	this.empresaModel = empresaModel;
    }

	public Long getIdusuario() {
		return Idusuario;
	}

	public void setIdusuario(Long idusuario) {
		Idusuario = idusuario;
	}

	public String getNomeusuario() {
		return Nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		Nomeusuario = nomeusuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getSenhausuario() {
		return Senhausuario;
	}

	public void setSenhausuario(String senhausuario) {
		Senhausuario = senhausuario;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

}
