package com.web.api.server.resources;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.api.server.model.ColaboradorModel;
import com.web.api.server.modelDTO.ColaboradorDTO;
import com.web.api.server.modelrequest.ColaboradorRequest;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.services.ColaboradorService;

@RestController
@RequestMapping("/api/v1/colaborador")
public class ColaboradorResource {

	@Autowired 
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public Page<ColaboradorDTO> listar(@PageableDefault(sort="Idcolaborador", direction = Direction.ASC, page=0, size=10) Pageable pageable) {
		Page<ColaboradorModel> colaborador = colaboradorRepository.findAll(pageable);
		return ColaboradorDTO.converter(colaborador);
	}
	
	@PostMapping
	public ResponseEntity<ColaboradorDTO> criar(@RequestBody @Valid ColaboradorRequest colaboradorRequest, HttpServletResponse response) {

		ColaboradorModel colaboradorModel = colaboradorRequest.converter(empresaRepository);
		ColaboradorModel colaboradorSalvo = colaboradorRepository.save(colaboradorModel);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idcolaborador")
				.buildAndExpand(colaboradorSalvo.getIdcolaborador()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(new ColaboradorDTO(colaboradorSalvo));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<ColaboradorDTO> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<ColaboradorModel> colaboradorModel = colaboradorRepository.findById(codigo);
		if (colaboradorModel.isPresent()) {
           return ResponseEntity.ok(new ColaboradorDTO(colaboradorModel.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		colaboradorRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<ColaboradorModel> atualizar(@PathVariable Long codigo, @Valid @RequestBody ColaboradorModel colaboradorModel) {
		ColaboradorModel colaboradorSalvo = colaboradorService.atualizar(codigo, colaboradorModel);
		return ResponseEntity.ok(colaboradorSalvo);
	}	
}
