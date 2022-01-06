package com.web.api.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.api.server.model.ServicoModel;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoModel, Long> {

	ServicoModel findByDescricaoservico(String descricaoservico);
}
