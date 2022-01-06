package com.web.api.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_Servico")
public class ServicoModel {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idservico;
	@NotNull
	private String descricaoservico;
	@NotNull
	private Double Valorservico;
	private String Temposervico;
	private String Materialservico;
	private String Cuidadoservico;
	@ManyToOne
	@JoinColumn(name = "id_colaborador")
	private ColaboradorModel colaboradorModel;
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private EmpresaModel empresaModel;
	
    public ServicoModel() {
    	
    }

	public ServicoModel(String descricaoServico, Double valorServico, String tempoServico, String materialServico, String cuidadoServico, ColaboradorModel colaboradorModel, EmpresaModel empresaModel) {
		this.descricaoservico = descricaoServico;
		this.Valorservico = valorServico;
		this.Temposervico = tempoServico;
		this.Materialservico = materialServico;
		this.Cuidadoservico =  cuidadoServico;
		this.colaboradorModel = colaboradorModel;
		this.empresaModel = empresaModel;
	}

	public Long getIdservico() {
		return idservico;
	}

	public void setIdservico(Long idservico) {
		this.idservico = idservico;
	}

	public String getDescricaoservico() {
		return descricaoservico;
	}

	public void setDescricaoservico(String descricaoservico) {
		this.descricaoservico = descricaoservico;
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

	public ColaboradorModel getColaboradorModel() {
		return colaboradorModel;
	}

	public void setColaboradorModel(ColaboradorModel colaboradorModel) {
		this.colaboradorModel = colaboradorModel;
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
		result = prime * result + ((idservico == null) ? 0 : idservico.hashCode());
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
		ServicoModel other = (ServicoModel) obj;
		if (idservico == null) {
			if (other.idservico != null)
				return false;
		} else if (!idservico.equals(other.idservico))
			return false;
		return true;
	}

}
