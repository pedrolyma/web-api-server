package com.web.api.server.modelDTO;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.web.api.server.model.ClienteModel;

public class ClienteDTO {

	private Long Idcliente;
	private String Nomecliente;
	private String Logradourocliente;
	private String Telefonecliente;
	private String Whatsappcliente;
	private String Tiktokcliente;
	private String Twittercliente;
	private String Instagrancliente;
	private LocalDate Datacadastro;
	private String Nameempresa;
	
	public ClienteDTO(ClienteModel clienteModel) {
		this.Idcliente = clienteModel.getIdcliente();
		this.Nomecliente = clienteModel.getNomecliente();
		this.Logradourocliente = clienteModel.getLogradourocliente();
		this.Telefonecliente = clienteModel.getTelefonecliente();
		this.Whatsappcliente = clienteModel.getWhatsappcliente();
		this.Tiktokcliente = clienteModel.getTiktokcliente();
		this.Twittercliente = clienteModel.getTwittercliente();
		this.Instagrancliente = clienteModel.getInstagrancliente();
		this.Datacadastro = clienteModel.getDatacadastro();
		this.Nameempresa = clienteModel.getEmpresaModel().getRazaosocial();
	}

	public Long getIdcliente() {
		return Idcliente;
	}

	public void setIdcliente(Long idcliente) {
		Idcliente = idcliente;
	}

	public String getNomecliente() {
		return Nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		Nomecliente = nomecliente;
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

	public String getNameempresa() {
		return Nameempresa;
	}

	public void setNameempresa(String nameempresa) {
		Nameempresa = nameempresa;
	}
	
	public static Page<ClienteDTO> converter(Page<ClienteModel> clienteModel) {
		return clienteModel.map(ClienteDTO::new);
	}
}
