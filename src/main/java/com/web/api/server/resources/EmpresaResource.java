package com.web.api.server.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.api.server.model.EmpresaModel;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.services.EmpresaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public List<EmpresaModel> listar() {
		return empresaRepository.findAll();
	}

	@PostMapping
	@ApiOperation(value="cadastra uma empresa para o agendamento")
	public ResponseEntity<EmpresaModel> criar(@RequestBody @Valid EmpresaModel empresaModel, HttpServletResponse response) {
		EmpresaModel empresaRetorno = empresaRepository.save(empresaModel);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idempresa}")
				.buildAndExpand(empresaRetorno.getIdempresa()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(empresaRetorno);
	}
	
	@GetMapping("/{codigo}")
	@ApiOperation(value="retorna uma empresa pelo seu codigo")
	public ResponseEntity<EmpresaModel> BuscarPeloCodigo(@PathVariable Long codigo) {
		Optional<EmpresaModel> empresaRetorno = empresaRepository.findById(codigo);
		return empresaRetorno.isPresent() ? ResponseEntity.ok(empresaRetorno.get()) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		empresaRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<EmpresaModel> atualizar(@PathVariable Long codigo, @Valid @RequestBody EmpresaModel empresaModel) {
		EmpresaModel empresaSalva = empresaService.atualizar(codigo, empresaModel);
		return ResponseEntity.ok(empresaSalva);
	}
}
