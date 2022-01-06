package com.web.api.server.resources;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.api.server.model.UsuarioModel;
import com.web.api.server.modelDTO.UsuarioDTO;
import com.web.api.server.modelrequest.UsuarioRequest;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.repositories.UsuarioModelRepository;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioModelRepository usuarioRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@PostMapping
	public ResponseEntity<UsuarioDTO> registrar(@RequestBody @Valid UsuarioRequest usuarioRequest, HttpServletResponse response) {
		
		UsuarioModel usuarioModel = usuarioRequest.converter(empresaRepository);
		UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioModel);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idusuario}")
				.buildAndExpand(usuarioSalvo.getIdusuario()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(new UsuarioDTO(usuarioSalvo));
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		usuarioRepository.deleteById(codigo);
	}
}
