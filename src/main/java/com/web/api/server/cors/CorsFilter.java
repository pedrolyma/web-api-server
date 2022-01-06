package com.web.api.server.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.api.server.config.properties.WebApiServerProperty;

public class CorsFilter implements Filter {
	
	@Autowired
	private WebApiServerProperty webApiServerProperty;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request; // converter
		HttpServletResponse resp = (HttpServletResponse) response;
		
		resp.setHeader("Access-Control-Allow-Origin", webApiServerProperty.getOriginPermitida());
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		
		if ("OPTIONS".equals(req.getMethod()) && webApiServerProperty.getOriginPermitida().equals(req.getHeader("Origin"))) {
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
			resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			resp.setHeader("Access-Control-Max-Age", "3600");
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
