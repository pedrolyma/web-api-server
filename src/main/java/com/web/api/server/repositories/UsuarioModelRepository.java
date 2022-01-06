package com.web.api.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.api.server.model.UsuarioModel;

public interface UsuarioModelRepository extends JpaRepository<UsuarioModel, Long> {

}
