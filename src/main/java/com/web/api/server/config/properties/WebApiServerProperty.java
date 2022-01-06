package com.web.api.server.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("webapiserver")
@Component
public class WebApiServerProperty {

	private String originPermitida = "http://localhost:4200";
	
	private final Seguranca seguranca = new Seguranca();
		
	public Seguranca getSeguranca() {
		return seguranca;
	}
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public static class Seguranca {
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
	}
}
