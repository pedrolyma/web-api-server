package com.web.api.server.modelrequest;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.web.api.server.model.ColaboradorModel;
import com.web.api.server.model.EmpresaModel;
import com.web.api.server.model.HorarioModel;
import com.web.api.server.model.ServicoModel;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.repositories.ServicoRepository;

public class HorarioRequest {

	@NotNull
	private LocalDate Datahorario;
	@NotNull
	private LocalDate Horahorario;
	private String Observacoes;
	private Long id_colaborador;
	private Long id_servico;
	private Long id_empresa;
	
	public void setDatahorario(LocalDate datahorario) {
		Datahorario = datahorario;
	}

	public void setHorahorario(LocalDate horahorario) {
		Horahorario = horahorario;
	}

	public void setObservacoes(String observacoes) {
		Observacoes = observacoes;
	}

	public void setId_colaborador(Long id_colaborador) {
		this.id_colaborador = id_colaborador;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public HorarioModel converter(ColaboradorRepository colaboradorRepository, ServicoRepository servicoRepository, EmpresaRepository empresaRepository) {
		Optional<ColaboradorModel> colaboradorModel = colaboradorRepository.findById(id_colaborador);
		Optional<ServicoModel> servicoModel = servicoRepository.findById(id_servico);
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		return new HorarioModel(Datahorario, Horahorario, Observacoes, colaboradorModel.get(), servicoModel.get(), empresaModel.get());
	}
}
