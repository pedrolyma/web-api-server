package com.web.api.server.modelrequest;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.web.api.server.model.BannerModel;
import com.web.api.server.model.ColaboradorModel;
import com.web.api.server.model.EmpresaModel;
import com.web.api.server.repositories.EmpresaRepository;

public class ColaboradorRequest {

	@NotNull
	private String nome; 
	private String Whatsapp; 
	private String Tiktok; 
	private String Twitter; 
	private String Instagran; 
	private String Foto; 
	private Long id_empresa;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setWhatsapp(String whatsapp) {
		Whatsapp = whatsapp;
	}

	public void setTiktok(String tiktok) {
		Tiktok = tiktok;
	}

	public void setTwitter(String twitter) {
		Twitter = twitter;
	}

	public void setInstagran(String instagran) {
		Instagran = instagran;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public ColaboradorModel converter(EmpresaRepository empresaRepository) {
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		return new ColaboradorModel(nome, Whatsapp, Tiktok, Twitter, Instagran, Foto, empresaModel.get());
	}
	
}
