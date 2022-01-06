package com.web.api.server.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	@NotNull
	private String nomecliente;
	private String Logradourocliente;
	private String Telefonecliente;
	private String Whatsappcliente;
	private String Tiktokcliente;
	private String Twittercliente;
	private String Instagrancliente;
	private LocalDate Datacadastro = LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private EmpresaModel empresaModel;

	public ClienteModel() {
		
	}
	
	public ClienteModel(String nomecliente, String Logradourocliente, String Telefonecliente, String Whatsappcliente,
			            String Tiktokcliente, String Twittercliente, String Instagrancliente, EmpresaModel empresaModel) {
		this.nomecliente = nomecliente;
		this.Logradourocliente = Logradourocliente;
		this.Telefonecliente = Telefonecliente;
		this.Whatsappcliente = Whatsappcliente;
		this.Tiktokcliente = Tiktokcliente;
		this.Twittercliente = Twittercliente;
		this.Instagrancliente = Instagrancliente;
		this.empresaModel = empresaModel;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public String getLogradourocliente() {
		return Logradourocliente;
	}

	public void setLogradourocliente(String logradourocliente) {
		Logradourocliente = logradourocliente;
	}

	public String getTelefonecliente() {
		return Telefonecliente;
	}

	public void setTelefonecliente(String telefonecliente) {
		Telefonecliente = telefonecliente;
	}

	public String getWhatsappcliente() {
		return Whatsappcliente;
	}

	public void setWhatsappcliente(String whatsappcliente) {
		Whatsappcliente = whatsappcliente;
	}

	public String getTiktokcliente() {
		return Tiktokcliente;
	}

	public void setTiktokcliente(String tiktokcliente) {
		Tiktokcliente = tiktokcliente;
	}

	public String getTwittercliente() {
		return Twittercliente;
	}

	public void setTwittercliente(String twittercliente) {
		Twittercliente = twittercliente;
	}

	public String getInstagrancliente() {
		return Instagrancliente;
	}

	public void setInstagrancliente(String instagrancliente) {
		Instagrancliente = instagrancliente;
	}

	public LocalDate getDatacadastro() {
		return Datacadastro;
	}

	public void setDatacadastro(LocalDate datacadastro) {
		Datacadastro = datacadastro;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcliente == null) ? 0 : idcliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		if (idcliente == null) {
			if (other.idcliente != null)
				return false;
		} else if (!idcliente.equals(other.idcliente))
			return false;
		return true;
	}
	
}
