package com.web.api.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_empresa")
public class EmpresaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idempresa;
	@NotNull
	private String razaosocial;
	private String Nomefantasia; 
	private String Cep; 
	private String Logradouro; 
	private String Bairro; 
	private String Cidade; 
	private String Estado; 
	private String Emailempresa; 
	private String Cnpjcpf; 
	private String Logoempresa; 

    public EmpresaModel() {
    	
    }
    
    public EmpresaModel(String Razaosocial, String nomeFantasia, String Cep, String Logradouro, String Bairro, String Cidade,
    		String Estado, String Emailempresa, String Cnpjcpf, String Logoempresa) {
    	this.razaosocial = Razaosocial;
    	this.Nomefantasia = nomeFantasia;
    	this.Cep = Cep;
    	this.Logradouro = Logradouro;
    	this.Bairro = Bairro;
    	this.Cidade = Cidade;
    	this.Estado = Estado;
    	this.Emailempresa = Emailempresa;
    	this.Cnpjcpf = Cnpjcpf;
    	this.Logoempresa = Logoempresa;
    			
    }

	public Long getIdempresa() {
		return Idempresa;
	}

	public void setIdempresa(Long idempresa) {
		Idempresa = idempresa;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String Razaosocial) {
		razaosocial = Razaosocial;
	}

	public String getNomefantasia() {
		return Nomefantasia;
	}

	public void setNomefantasia(String Nomefantasia) {
		this.Nomefantasia = Nomefantasia;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getEmailempresa() {
		return Emailempresa;
	}

	public void setEmailempresa(String emailempresa) {
		Emailempresa = emailempresa;
	}

	public String getCnpjcpf() {
		return Cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		Cnpjcpf = cnpjcpf;
	}

	public String getLogoempresa() {
		return Logoempresa;
	}

	public void setLogoempresa(String logoempresa) {
		Logoempresa = logoempresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Idempresa == null) ? 0 : Idempresa.hashCode());
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
		EmpresaModel other = (EmpresaModel) obj;
		if (Idempresa == null) {
			if (other.Idempresa != null)
				return false;
		} else if (!Idempresa.equals(other.Idempresa))
			return false;
		return true;
	}
    
}
