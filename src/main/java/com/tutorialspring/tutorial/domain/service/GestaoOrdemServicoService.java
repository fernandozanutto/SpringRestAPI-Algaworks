package com.tutorialspring.tutorial.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tutorialspring.tutorial.api.model.Comentario;
import com.tutorialspring.tutorial.domain.exception.EntidadeNaoEncontradaException;
import com.tutorialspring.tutorial.domain.exception.NegocioException;
import com.tutorialspring.tutorial.domain.model.Cliente;
import com.tutorialspring.tutorial.domain.model.OrdemServico;
import com.tutorialspring.tutorial.domain.model.StatusOrdemServico;
import com.tutorialspring.tutorial.domain.repository.ClienteRepository;
import com.tutorialspring.tutorial.domain.repository.ComentarioRepository;
import com.tutorialspring.tutorial.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRespository;

	@Autowired
	private ComentarioRepository comentarioRepository;



	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		ordemServico.finalizar();
		
		ordemServicoRepository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscar(ordemServicoId);

		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);

		return comentarioRepository.save(comentario);
	}

	public OrdemServico criar(OrdemServico ordemServico) {

		Cliente cliente = clienteRespository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));

		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		ordemServico.setCliente(cliente);

		return ordemServicoRepository.save(ordemServico);
	}
	
	private OrdemServico buscar(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada."));
	}
}
