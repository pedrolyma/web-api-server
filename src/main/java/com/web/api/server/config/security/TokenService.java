package com.web.api.server.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.web.api.server.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${web-api-server.jwt.expiration}")
	private String expiration;
	
	@Value("${web-api-server.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuarioModel = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("API de Agendamento")
				.setSubject(usuarioModel.getIdusuario().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValido(String token) {
		try {
        Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
        return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
