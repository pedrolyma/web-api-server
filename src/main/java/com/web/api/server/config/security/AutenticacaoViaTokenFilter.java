package com.web.api.server.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.web.api.server.model.Usuario;
import com.web.api.server.repositories.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			autenticarCliente(token);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuarioModel = usuarioRepository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuarioModel, null, usuarioModel.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}

}
