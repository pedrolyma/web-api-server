package com.web.api.server.resources;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.api.server.model.ClienteModel;
import com.web.api.server.modelDTO.ClienteDTO;
import com.web.api.server.modelrequest.ClienteRequest;
import com.web.api.server.repositories.ClienteRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping   // @RequestParam(required = false) para ser opcional
//	public Page<ClienteModel> listar(@RequestParam int pagina, @RequestParam int qtdePorPagina, @RequestParam String ordenacao) {
//	Pageable paginacao = PageRequest.of(pagina, qtdePorPagina, Direction.ASC, ordenacao);
	public Page<ClienteDTO> listar(@PageableDefault(sort="Idcliente", direction = Direction.ASC, page=0, size=10) Pageable pageable)
    {
		Page<ClienteModel> clienteRetorno = clienteRepository.findAll(pageable);
		return ClienteDTO.converter(clienteRetorno);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> criar(@RequestBody @Valid ClienteRequest clienteRequest, HttpServletResponse response) {
        ClienteModel clienteModel = clienteRequest.converter(empresaRepository); 
		ClienteModel clienteSalvo = clienteRepository.save(clienteModel);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idcliente}")
				.buildAndExpand(clienteSalvo.getIdcliente()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(new ClienteDTO(clienteSalvo));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteModel> buscarPeloCodigo(@PathVariable Long codigo) {
		return clienteRepository.findById(codigo)
				.map(clienteRetorno -> ResponseEntity.ok(clienteRetorno))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{coidgo}")
	public ResponseEntity<ClienteModel> atualizar(@PathVariable Long codigo, @Valid @RequestBody ClienteModel clienteModel) {
		ClienteModel clienteSalvo = clienteService.atualizar(codigo, clienteModel);
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		clienteRepository.deleteById(codigo);
	}

}
