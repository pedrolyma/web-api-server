package com.web.api.server.modelDTO;

import java.time.LocalDate;

import com.web.api.server.model.AgendamentoModel;

public class AgendamentoDTO {

	private Long Idagenda;
    private LocalDate Dataagenda;
    private LocalDate Horaagenda;
    private Double Valorservico;
    private String StatusAgenda;
    private String Razaosocial;
    private String Nomecliente;
    private String Descricaoservico;
    private String Nomecolaborador;
    
    public AgendamentoDTO(AgendamentoModel agendamentoModel) {
    	this.Idagenda = agendamentoModel.getIdagenda();
    	this.Idagenda = agendamentoModel.getIdagenda();
    	this.Dataagenda = agendamentoModel.getDataagenda();
    	this.Horaagenda = agendamentoModel.getHoraagenda();
    	this.Valorservico = agendamentoModel.getValorservico();
    	this.StatusAgenda = agendamentoModel.getStatusagenda().toString();
    	this.Razaosocial = agendamentoModel.getEmpresaModel().getRazaosocial();
    	this.Nomecliente = agendamentoModel.getClienteModel().getNomecliente();
    	this.Descricaoservico = agendamentoModel.getServicoModel().getDescricaoservico();
    	this.Nomecolaborador = agendamentoModel.getColaboradorModel().getNome();
    }

	public Long getIdagenda() {
		return Idagenda;
	}

	public void setIdagenda(Long idagenda) {
		Idagenda = idagenda;
	}

	public LocalDate getDataagenda() {
		return Dataagenda;
	}

	public void setDataagenda(LocalDate dataagenda) {
		Dataagenda = dataagenda;
	}

	public LocalDate getHoraagenda() {
		return Horaagenda;
	}

	public void setHoraagenda(LocalDate horaagenda) {
		Horaagenda = horaagenda;
	}

	public Double getValorservico() {
		return Valorservico;
	}

	public void setValorservico(Double valorservico) {
		Valorservico = valorservico;
	}

	public String getStatusAgenda() {
		return StatusAgenda;
	}

	public void setStatusAgenda(String statusAgenda) {
		StatusAgenda = statusAgenda;
	}

	public String getRazaosocial() {
		return Razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		Razaosocial = razaosocial;
	}

	public String getNomecliente() {
		return Nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		Nomecliente = nomecliente;
	}

	public String getDescricaoservico() {
		return Descricaoservico;
	}

	public void setDescricaoservico(String descricaoservico) {
		Descricaoservico = descricaoservico;
	}

	public String getNomecolaborador() {
		return Nomecolaborador;
	}

	public void setNomecolaborador(String nomecolaborador) {
		Nomecolaborador = nomecolaborador;
	}
    
    
}
