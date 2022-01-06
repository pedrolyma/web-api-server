package com.web.api.server.modelDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.web.api.server.model.ServicoModel;

public class ServicoDTO {

	private Long Idservico;
	private String Descricaoservico;
	private Double Valorservico;
	private String Temposervico;
	private String Materialservico;
	private String Cuidadoservico;
	private String Namecolaborador;
	private String Nameempresa;
	
	public ServicoDTO(ServicoModel servicoModel) {
		this.Idservico = servicoModel.getIdservico();
		this.Descricaoservico = servicoModel.getDescricaoservico();
		this.Valorservico = servicoModel.getValorservico();
		this.Temposervico = servicoModel.getTemposervico();
		this.Materialservico = servicoModel.getMaterialservico();
		this.Cuidadoservico = servicoModel.getCuidadoservico();
		this.Namecolaborador = servicoModel.getColaboradorModel().getNome();
		this.Nameempresa = servicoModel.getEmpresaModel().getRazaosocial();
	}

	public Long getIdservico() {
		return Idservico;
	}

	public void setIdservico(Long idservico) {
		Idservico = idservico;
	}

	public String getDescricaoservico() {
		return Descricaoservico;
	}

	public void setDescricaoservico(String descricaoservico) {
		Descricaoservico = descricaoservico;
	}

	public Double getValorservico() {
		return Valorservico;
	}

	public void setValorservico(Double valorservico) {
		Valorservico = valorservico;
	}

	public String getTemposervico() {
		return Temposervico;
	}

	public void setTemposervico(String temposervico) {
		Temposervico = temposervico;
	}

	public String getMaterialservico() {
		return Materialservico;
	}

	public void setMaterialservico(String materialservico) {
		Materialservico = materialservico;
	}

	public String getCuidadoservico() {
		return Cuidadoservico;
	}

	public void setCuidadoservico(String cuidadoservico) {
		Cuidadoservico = cuidadoservico;
	}

	public String getNamecolaborador() {
		return Namecolaborador;
	}

	public void setNamecolaborador(String namecolaborador) {
		Namecolaborador = namecolaborador;
	}

	public String getNameempresa() {
		return Nameempresa;
	}

	public void setNameempresa(String nameempresa) {
		Nameempresa = nameempresa;
	}
	
	public static Page<ServicoDTO> converter(Page<ServicoModel> servicoModel) {
		return servicoModel.map(ServicoDTO::new);
	}

}
