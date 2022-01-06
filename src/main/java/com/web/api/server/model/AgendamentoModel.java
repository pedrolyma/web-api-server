package com.web.api.server.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Agendamento")
public class AgendamentoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idagenda;
	@NotNull
    private LocalDate Dataagenda;
	@NotNull
    private LocalDate Horaagenda;
    private Double Valorservico;
    @Enumerated(EnumType.STRING)
    private StatusAgenda statusagenda;
    @JoinColumn(name = "id_empresa")
    @ManyToOne
    private EmpresaModel empresaModel;
    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private ClienteModel clienteModel;
    @JoinColumn(name = "id_servico")
    @ManyToOne
    private ServicoModel servicoModel;
    @JoinColumn(name = "id_colaborador")
    @ManyToOne
    private ColaboradorModel colaboradorModel;

    public AgendamentoModel(LocalDate Dataagenda, LocalDate Horaagenda, ClienteModel clienteModel, ServicoModel servicoModel,
    		ColaboradorModel colaboradorModel, EmpresaModel empresaModel) {
    	this.Dataagenda = Dataagenda;
    	this.Horaagenda = Horaagenda;
    	this.clienteModel = clienteModel;
    	this.servicoModel = servicoModel;
    	this.colaboradorModel = colaboradorModel;
    	this.empresaModel = empresaModel;
    }

    public AgendamentoModel() {
    	
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

	public StatusAgenda getStatusagenda() {
		return statusagenda;
	}

	public void setStatusagenda(StatusAgenda statusagenda) {
		this.statusagenda = statusagenda.Agendado;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public ServicoModel getServicoModel() {
		return servicoModel;
	}

	public void setServicoModel(ServicoModel servicoModel) {
		this.servicoModel = servicoModel;
	}

	public ColaboradorModel getColaboradorModel() {
		return colaboradorModel;
	}

	public void setColaboradorModel(ColaboradorModel colaboradorModel) {
		this.colaboradorModel = colaboradorModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Idagenda == null) ? 0 : Idagenda.hashCode());
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
		AgendamentoModel other = (AgendamentoModel) obj;
		if (Idagenda == null) {
			if (other.Idagenda != null)
				return false;
		} else if (!Idagenda.equals(other.Idagenda))
			return false;
		return true;
	}
    
}
