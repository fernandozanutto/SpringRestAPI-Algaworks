package com.tutorialspring.tutorial.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorialspring.tutorial.domain.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
