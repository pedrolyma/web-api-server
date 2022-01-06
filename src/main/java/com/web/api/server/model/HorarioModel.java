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
@Table(name = "Tb_Horario")
public class HorarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idhorario;
	@NotNull
	private LocalDate Datahorario;
	@NotNull
	private LocalDate horahorario;
	private String Observacoes;
	@ManyToOne
	@JoinColumn(name = "id_colaborador")
	private ColaboradorModel colaboradorModel;
	@ManyToOne
	@JoinColumn(name = "id_servico")
	private ServicoModel servicoModel;
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private EmpresaModel empresaModel;
	
	public HorarioModel() {
		
	}

	public HorarioModel(LocalDate datahorario, LocalDate horahorario,
			String observacoes, ColaboradorModel colaboradorModel, ServicoModel servicoModel, EmpresaModel empresaModel) {
		Datahorario = datahorario;
		this.horahorario = horahorario;
		Observacoes = observacoes;
		this.colaboradorModel = colaboradorModel;
		this.servicoModel = servicoModel;
		this.empresaModel = empresaModel;
	}

	public Long getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(Long idhorario) {
		this.idhorario = idhorario;
	}

	public LocalDate getDatahorario() {
		return Datahorario;
	}

	public void setDatahorario(LocalDate datahorario) {
		Datahorario = datahorario;
	}

	public LocalDate getHorahorario() {
		return horahorario;
	}

	public void setHorahorario(LocalDate horahorario) {
		this.horahorario = horahorario;
	}

	public String getObservacoes() {
		return Observacoes;
	}

	public void setObservacoes(String observacoes) {
		Observacoes = observacoes;
	}

	public ColaboradorModel getColaboradorModel() {
		return colaboradorModel;
	}

	public void setColaboradorModel(ColaboradorModel colaboradorModel) {
		this.colaboradorModel = colaboradorModel;
	}

	public ServicoModel getServicoModel() {
		return servicoModel;
	}

	public void setServicoModel(ServicoModel servicoModel) {
		this.servicoModel = servicoModel;
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
		result = prime * result + ((idhorario == null) ? 0 : idhorario.hashCode());
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
		HorarioModel other = (HorarioModel) obj;
		if (idhorario == null) {
			if (other.idhorario != null)
				return false;
		} else if (!idhorario.equals(other.idhorario))
			return false;
		return true;
	}

}
