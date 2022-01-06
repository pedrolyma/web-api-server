package com.web.api.server.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.web.api.server.model.ServicoModel;
import com.web.api.server.modelDTO.ServicoDTO;
import com.web.api.server.modelrequest.ServicoRequest;
import com.web.api.server.repositories.ColaboradorRepository;
import com.web.api.server.repositories.EmpresaRepository;
import com.web.api.server.repositories.ServicoRepository;
import com.web.api.server.services.ServicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/servico")
@Api(value="API Rest de Serviços de Agendamento")
@CrossOrigin(origins="*")
public class ServicoResource {
	// usar cache em tabelas de menor movimentacao de crud
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping
	@Cacheable(value = "listaDeServico")  //guardar o lista em cache de memoria
	@ApiOperation(value="retorna uma lista de serviços")
	public Page<ServicoDTO> listar(@PageableDefault(sort = "Idservico", direction=Direction.ASC, page=0, size=10) Pageable paginacao ) {
		Page<ServicoModel> listaServico = servicoRepository.findAll(paginacao);
		return ServicoDTO.converter(listaServico);
	}
	
	@PostMapping
	@Transactional
	@ApiOperation(value="cadastra um servico para o agendamento")
	@CacheEvict(value = "listaDeServico", allEntries = true) // limpar o cache da memoria
	public ResponseEntity<ServicoDTO> criar(@RequestBody @Valid ServicoRequest servicoRequest, HttpServletResponse response) {
		ServicoModel servicoModel = servicoRequest.converter(empresaRepository, colaboradorRepository);
		
		ServicoModel servicoSalvo = servicoRepository.save(servicoModel);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idservico}")
				.buildAndExpand(servicoSalvo.getIdservico()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(new ServicoDTO(servicoSalvo));
	}

	@GetMapping("/{codigo}")
	@ApiOperation(value="retorna um serviços pelo seu codigo")
	public ResponseEntity<ServicoDTO> BuscarPeloCodigo(@PathVariable Long codigo) {
		Optional<ServicoModel> servicoRetorno = servicoRepository.findById(codigo);
		if (servicoRetorno.isPresent()) {
			return ResponseEntity.ok(new ServicoDTO(servicoRetorno.get()));
		}
		return ResponseEntity.notFound().build();
//		return servicoRetorno.isPresent() ? ResponseEntity.ok(new ServicoDTO(servicoRetorno.get())) : ResponseEntity.notFound().build();
		
//		return this.servicoRepository.findById(codigo)
//				  .map(servicoRetorno -> ResponseEntity.ok(servicoRetorno))
//				  .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@CacheEvict(value = "listaDeServico", allEntries = true) // limpar o cache da memoria
	public void remover(@PathVariable Long codigo) {
		servicoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	@CacheEvict(value = "listaDeServico", allEntries = true) // limpar o cache da memoria
	public ResponseEntity<ServicoModel> atualizar(@PathVariable Long codigo, @Valid @RequestBody ServicoModel servicoModel) {
		ServicoModel servicoSalvo = servicoService.atualizar(codigo, servicoModel);
		return ResponseEntity.ok(servicoSalvo);
	}
}
