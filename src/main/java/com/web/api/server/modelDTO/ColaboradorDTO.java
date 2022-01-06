package com.web.api.server.modelDTO;

import org.springframework.data.domain.Page;
import com.web.api.server.model.ColaboradorModel;

public class ColaboradorDTO {

	private Long Idcolaborador;
	private String Nome; 
	private String Whatsapp; 
	private String Tiktok; 
	private String Twitter; 
	private String Instagran; 
	private String Foto; 
	private String Razaosocial;
	
	public ColaboradorDTO(ColaboradorModel colaboradorModel) {
		this.Idcolaborador = colaboradorModel.getIdcolaborador();
		this.Nome = colaboradorModel.getNome();
		this.Whatsapp = colaboradorModel.getWhatsapp();
		this.Tiktok = colaboradorModel.getTiktok();
		this.Twitter = colaboradorModel.getTwitter();
		this.Instagran = colaboradorModel.getInstagran();
		this.Foto = colaboradorModel.getFoto();
		this.Razaosocial = colaboradorModel.getEmpresaModel().getRazaosocial();
	}
	
	public Long getIdcolaborador() {
		return Idcolaborador;
	}

	public void setIdcolaborador(Long idcolaborador) {
		Idcolaborador = idcolaborador;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
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

	public String getRazaosocial() {
		return Razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		Razaosocial = razaosocial;
	}

	public static Page<ColaboradorDTO> converter(Page<ColaboradorModel> colaboradorModel) {
		return colaboradorModel.map(ColaboradorDTO::new);
	}
}
