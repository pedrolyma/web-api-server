package com.web.api.server.modelrequest;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.web.api.server.model.AgendamentoModel;
import com.web.api.server.model.ClienteModel;
import com.web.api.server.model.ColaboradorModel;
import com.web.api.server.model.EmpresaModel;
import com.web.api.server.model.ServicoModel;
import com.web.api.server.repositories.ClienteRepository;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.repositories.ServicoRepository;

public class AgendamentoRequest {

	@NotNull
    private LocalDate Dataagenda;
	@NotNull
    private LocalDate Horaagenda;
	private Long id_empresa;
	private Long id_cliente;
	private Long id_servico;
	private Long id_colaborador;
    
	public void setDataagenda(LocalDate dataagenda) {
		Dataagenda = dataagenda;
	}

	public void setHoraagenda(LocalDate horaagenda) {
		Horaagenda = horaagenda;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}

	public void setId_colaborador(Long id_colaborador) {
		this.id_colaborador = id_colaborador;
	}

	public AgendamentoModel converter(ClienteRepository clienteRepository, ServicoRepository servicoRepository, 
			ColaboradorRepository colaboradorRepository, EmpresaRepository empresaRepository) {
		Optional<ClienteModel> clienteModel = clienteRepository.findById(id_cliente);
		Optional<ServicoModel> servicoModel = servicoRepository.findById(id_servico);
		Optional<ColaboradorModel> colaboradorModel = colaboradorRepository.findById(id_colaborador);
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		return new AgendamentoModel(Dataagenda, Horaagenda, clienteModel.get(), servicoModel.get(), colaboradorModel.get(), empresaModel.get());
	}
}
