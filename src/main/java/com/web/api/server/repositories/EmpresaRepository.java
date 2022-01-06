package com.web.api.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.api.server.model.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

	EmpresaModel findByRazaosocial(String razaosocial);
}
