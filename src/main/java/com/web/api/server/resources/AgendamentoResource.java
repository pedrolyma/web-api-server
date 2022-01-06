package com.web.api.server.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.api.server.model.AgendamentoModel;
import com.web.api.server.modelDTO.AgendamentoDTO;
import com.web.api.server.modelrequest.AgendamentoRequest;
import com.web.api.server.repositories.AgendaRepository;
import com.web.api.server.repositories.ClienteRepository;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.repositories.ServicoRepository;

@RestController
@RequestMapping("/api/v1/agendamento")
public class AgendamentoResource {

	@Autowired
	private AgendaRepository agendaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public Page<AgendamentoModel> listar(Pageable pageable) {
		return agendaRepository.findAll(pageable);
	}
	
	@PostMapping
	public ResponseEntity<AgendamentoDTO> registrar(@RequestBody AgendamentoRequest agendamentoRequest, HttpServletResponse response) {
        AgendamentoModel agendamentoModel = agendamentoRequest.converter(clienteRepository, servicoRepository, colaboradorRepository, empresaRepository);
		
		AgendamentoModel agendaSalva = agendaRepository.save(agendamentoModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/Idagenda}")
				.buildAndExpand(agendaSalva.getIdagenda()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(new AgendamentoDTO(agendaSalva));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<AgendamentoModel> buscarPeloCodigo(@PathVariable Long codigo) {
		return agendaRepository.findById(codigo)
				.map(agendaResponse -> ResponseEntity.ok(agendaResponse))
						.orElse(ResponseEntity.notFound().build());
	}
	
}
