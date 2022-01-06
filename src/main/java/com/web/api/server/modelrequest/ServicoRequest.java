package com.web.api.server.modelrequest;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.web.api.server.model.ColaboradorModel;
import com.web.api.server.model.EmpresaModel;
import com.web.api.server.model.ServicoModel;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;

public class ServicoRequest {

	private Long idservico;
	@NotNull
	private String Descricaoservico;
	@NotNull
	private Double Valorservico;
	private String Temposervico;
	private String Materialservico;
	private String Cuidadoservico;
	private Long id_colaborador;
	private Long id_empresa;
	
	public void setIdservico(Long idservico) {
		this.idservico = idservico;
	}

	public void setDescricaoservico(String descricaoservico) {
		Descricaoservico = descricaoservico;
	}

	public void setValorservico(Double valorservico) {
		Valorservico = valorservico;
	}

	public void setTemposervico(String temposervico) {
		Temposervico = temposervico;
	}

	public void setMaterialservico(String materialservico) {
		Materialservico = materialservico;
	}

	public void setCuidadoservico(String cuidadoservico) {
		Cuidadoservico = cuidadoservico;
	}

	public void setId_colaborador(Long id_colaborador) {
		this.id_colaborador = id_colaborador;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public ServicoModel converter(EmpresaRepository empresaRepository, ColaboradorRepository colaboradorRepository) {
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		Optional<ColaboradorModel> colaboradorModel = colaboradorRepository.findById(id_colaborador);
		return new ServicoModel(Descricaoservico, Valorservico, Temposervico, Materialservico, Cuidadoservico, colaboradorModel.get(), empresaModel.get());
	}
	
}
