package com.web.api.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.api.server.model.AgendamentoModel;

@Repository
public interface AgendaRepository extends JpaRepository<AgendamentoModel, Long> {

}
