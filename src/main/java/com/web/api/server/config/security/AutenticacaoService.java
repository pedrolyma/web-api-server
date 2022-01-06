package com.web.api.server.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.api.server.model.Usuario;
import com.web.api.server.repositories.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuarioRetorno = usuarioRepository.findByEmailusuario(username);
        if (usuarioRetorno.isPresent()) {
        	return usuarioRetorno.get();
        }
        throw new UsernameNotFoundException("Dados Invalidos !!");
	}

}
