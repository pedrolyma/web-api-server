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
@Table(name = "Tb_Colaborador")
public class ColaboradorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcolaborador;
	@NotNull
	private String nome; 
	private String Whatsapp; 
	private String Tiktok; 
	private String Twitter; 
	private String Instagran; 
	private String Foto; 
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private EmpresaModel empresaModel;

	public ColaboradorModel() {
		
	}
	
	public ColaboradorModel(String nome, String Whatsapp, String Tiktok, String Twitter, String Instagran, String Foto, EmpresaModel empresaModel) {
		this.nome = nome;
		this.Whatsapp = Whatsapp;
		this.Tiktok = Tiktok;
		this.Twitter = Twitter;
		this.Instagran = Instagran;
		this.Foto = Foto;
		this.empresaModel = empresaModel;
	}

	public Long getIdcolaborador() {
		return idcolaborador;
	}

	public void setIdcolaborador(Long idcolaborador) {
		this.idcolaborador = idcolaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String Nome) {
		nome = Nome;
	}

	public String getWhatsapp() {
		return Whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		Whatsapp = whatsapp;
	}

	public String getTiktok() {
		return Tiktok;
	}

	public void setTiktok(String tiktok) {
		Tiktok = tiktok;
	}

	public String getTwitter() {
		return Twitter;
	}

	public void setTwitter(String twitter) {
		Twitter = twitter;
	}

	public String getInstagran() {
		return Instagran;
	}

	public void setInstagran(String instagran) {
		Instagran = instagran;
	}

	public String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
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
		result = prime * result + ((idcolaborador == null) ? 0 : idcolaborador.hashCode());
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
		ColaboradorModel other = (ColaboradorModel) obj;
		if (idcolaborador == null) {
			if (other.idcolaborador != null)
				return false;
		} else if (!idcolaborador.equals(other.idcolaborador))
			return false;
		return true;
	}

}
