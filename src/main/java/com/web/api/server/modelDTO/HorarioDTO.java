package com.web.api.server.modelDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.web.api.server.model.HorarioModel;

public class HorarioDTO {

	private Long Idhorario;
	private LocalDate Datahorario;
	private LocalDate Horahorario;
	private String Observacoes;
	private String colaboradorHorario;
	private String servicoHorario;
	private String empresaHorario;
	
	public HorarioDTO(HorarioModel horarioModel) {
		this.Idhorario = horarioModel.getIdhorario();
		this.Datahorario = horarioModel.getDatahorario();
		this.Horahorario = horarioModel.getHorahorario();
		this.Observacoes = horarioModel.getObservacoes();
		this.colaboradorHorario = horarioModel.getColaboradorModel().getNome();
		this.servicoHorario = horarioModel.getServicoModel().getDescricaoservico();
		this.empresaHorario = horarioModel.getEmpresaModel().getRazaosocial();
	}
	
	public Long getIdhorario() {
		return Idhorario;
	}
	public void setIdhorario(Long idhorario) {
		Idhorario = idhorario;
	}
	public LocalDate getDatahorario() {
		return Datahorario;
	}
	public void setDatahorario(LocalDate datahorario) {
		Datahorario = datahorario;
	}
	public LocalDate getHorahorario() {
		return Horahorario;
	}
	public void setHorahorario(LocalDate horahorario) {
		Horahorario = horahorario;
	}
	public String getObservacoes() {
		return Observacoes;
	}
	public void setObservacoes(String observacoes) {
		Observacoes = observacoes;
	}

	public String getColaboradorHorario() {
		return colaboradorHorario;
	}
	public void setColaboradorHorario(String colaboradorHorario) {
		this.colaboradorHorario = colaboradorHorario;
	}
	public String getServicoHorario() {
		return servicoHorario;
	}
	public void setServicoHorario(String servicoHorario) {
		this.servicoHorario = servicoHorario;
	}
	public static Page<HorarioDTO> converter(Page<HorarioModel> horarioModel) {
		return horarioModel.map(HorarioDTO::new);
	}
	public String getEmpresaHorario() {
		return empresaHorario;
	}
	public void setEmpresaHorario(String empresaHorario) {
		this.empresaHorario = empresaHorario;
	}
}
