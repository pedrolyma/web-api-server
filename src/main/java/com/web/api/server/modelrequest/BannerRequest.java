package com.web.api.server.modelrequest;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.web.api.server.model.BannerModel;
import com.web.api.server.model.EmpresaModel;
import com.web.api.server.repositories.EmpresaRepository;

public class BannerRequest {
    @NotNull @NotEmpty @Length(min = 5)
	private String Descricaobanner;
    @NotNull
	private String Urlbanner;
    @NotNull
    private Long id_empresa;
    
	public void setDescricaobanner(String descricaobanner) {
		Descricaobanner = descricaobanner;
	}
	public void setUrlbanner(String urlbanner) {
		Urlbanner = urlbanner;
	}
	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}
	
	public BannerModel converter(EmpresaRepository empresaRepository) {
		Optional<EmpresaModel> empresaModel = empresaRepository.findById(id_empresa);
		return new BannerModel(Descricaobanner, Urlbanner, empresaModel.get());
    }
   
}
