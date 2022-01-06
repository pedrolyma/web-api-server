package com.web.api.server.resources;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.api.server.model.BannerModel;
import com.web.api.server.modelDTO.BannerDTO;
import com.web.api.server.modelrequest.BannerRequest;
import com.web.api.server.repositories.BannerRepository;
import com.web.api.server.repositories.EmpresaRepository;

@RestController
@RequestMapping("api/v1/banner")
public class BannerResource {
	
	@Autowired
	private BannerRepository bannerRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeBanner")  //guardar o lista em cache de memoria
	public Page<BannerDTO> listar(@PageableDefault(sort="Idbanner", direction=Direction.ASC, page=0, size=6) Pageable paginacao) {
		Page<BannerModel> listaBanner = bannerRepository.findAll(paginacao);
		return BannerDTO.converter(listaBanner);
	}
	
	@PostMapping
	@CacheEvict(value = "listaDeBanner", allEntries = true) // limpar o cache da memoria
	public ResponseEntity<BannerDTO> cadastrar(@RequestBody @Valid BannerRequest bannerRequest, HttpServletResponse response) {
		BannerModel bannerModel = bannerRequest.converter(empresaRepository);

		BannerModel bannerSalvo = bannerRepository.save(bannerModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idbanner}")
				.buildAndExpand(bannerSalvo.getIdbanner()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(new BannerDTO(bannerSalvo));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<BannerDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<BannerModel> bannerModel = bannerRepository.findById(codigo);
		if (bannerModel.isPresent()) {
			return ResponseEntity.ok(new BannerDTO(bannerModel.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping
	@CacheEvict(value = "listaDeBanner", allEntries = true) // limpar o cache da memoria
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		bannerRepository.deleteById(codigo);
	}
}
