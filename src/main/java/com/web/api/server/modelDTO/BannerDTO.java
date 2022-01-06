package com.web.api.server.modelDTO;

import org.springframework.data.domain.Page;

import com.web.api.server.model.BannerModel;

public class BannerDTO {
	
	private Long idbanner;
	private String Descricaobanner;
	private String Urlbanner;
	private String Nameempresa;
	
	public BannerDTO(BannerModel bannerModel) {
		this.idbanner = bannerModel.getIdbanner();
		this.Descricaobanner = bannerModel.getDescricaobanner();
		this.Urlbanner = bannerModel.getUrlbanner();
		this.Nameempresa = bannerModel.getEmpresaModel().getRazaosocial();
	}

	public Long getidbanner() {
		return idbanner;
	}

	public String getDescricaobanner() {
		return Descricaobanner;
	}

	public String getUrlbanner() {
		return Urlbanner;
	}

	public String getNameempresa() {
		return Nameempresa;
	}
	
	public static Page<BannerDTO> converter(Page<BannerModel> bannerModel) {
		return bannerModel.map(BannerDTO::new);
	}
}
