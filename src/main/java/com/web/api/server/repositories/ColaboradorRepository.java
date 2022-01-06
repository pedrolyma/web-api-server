package com.web.api.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.api.server.model.ColaboradorModel;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorModel, Long> {

	ColaboradorModel findByNome(String nome);
}
