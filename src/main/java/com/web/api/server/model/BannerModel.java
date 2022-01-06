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
@Table(name = "tb_banner")
public class BannerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idbanner;
	@NotNull
	private String Descricaobanner;
	@NotNull
	private String Urlbanner;
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private EmpresaModel empresaModel;
	
	public BannerModel() {
	}
	
	public BannerModel(String descricaoBanner, String urlBanner, EmpresaModel empresaModel) {
		this.Descricaobanner = descricaoBanner;
		this.Urlbanner = urlBanner;
		this.empresaModel = empresaModel;
	}
	
	public Long getIdbanner() {
		return idbanner;
	}
	public void setIdbanner(Long idbanner) {
		this.idbanner = idbanner;
	}
	public String getDescricaobanner() {
		return Descricaobanner;
	}
	public void setDescricaobanner(String descricaobanner) {
		Descricaobanner = descricaobanner;
	}
	public String getUrlbanner() {
		return Urlbanner;
	}
	public void setUrlbanner(String urlbanner) {
		Urlbanner = urlbanner;
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
		result = prime * result + ((idbanner == null) ? 0 : idbanner.hashCode());
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
		BannerModel other = (BannerModel) obj;
		if (idbanner == null) {
			if (other.idbanner != null)
				return false;
		} else if (!idbanner.equals(other.idbanner))
			return false;
		return true;
	}
	
}
