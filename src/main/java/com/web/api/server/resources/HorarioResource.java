package com.web.api.server.resources;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.web.api.server.model.HorarioModel;
import com.web.api.server.modelDTO.HorarioDTO;
import com.web.api.server.modelrequest.HorarioRequest;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.repositories.HorarioRepository;
import com.web.api.server.repositories.ServicoRepository;
import com.web.api.server.services.HorarioService;

@RestController
@RequestMapping("/api/v1/horarios")
public class HorarioResource {
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private HorarioService horarioService;
	
	@GetMapping
	public Page<HorarioDTO> listar(@PageableDefault(sort = "Horahorario", direction = Sort.Direction.ASC, page=0, size=10) Pageable pageable)
	{
		Page<HorarioModel> listaHorario = horarioRepository.findAll(pageable);
		return HorarioDTO.converter(listaHorario);
	}
	
	@PostMapping
	public ResponseEntity<HorarioDTO> cadastrar(@RequestBody @Valid HorarioRequest horarioRequest, HttpServletResponse response ) {
		HorarioModel horarioModel = horarioRequest.converter(colaboradorRepository, servicoRepository, empresaRepository);
		HorarioModel horarioSalvo = horarioRepository.save(horarioModel);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/Idhorario}")
				.buildAndExpand(horarioSalvo.getIdhorario()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(new HorarioDTO(horarioSalvo));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<HorarioDTO> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<HorarioModel> horarioModel = horarioRepository.findById(codigo);
		if (horarioModel.isPresent()) {
			return ResponseEntity.ok(new HorarioDTO(horarioModel.get()));
		}
		return ResponseEntity.notFound().build();
//		return horarioRepository.findById(codigo)
//				.map(horarioRetorno -> ResponseEntity.ok(horarioRetorno))
//				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<HorarioModel> atualizar(@PathVariable Long codigo, @Valid @RequestBody HorarioModel horarioModel) {
		HorarioModel horarioSalvo = horarioService.atualizar(codigo, horarioModel);
		return ResponseEntity.ok(horarioSalvo);		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		horarioRepository.deleteById(codigo);
	}

}
