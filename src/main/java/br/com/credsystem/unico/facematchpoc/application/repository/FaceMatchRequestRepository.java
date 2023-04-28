package br.com.credsystem.unico.facematchpoc.application.repository;

import java.util.List;

import br.com.credsystem.unico.facematchpoc.domain.Proposta;

public interface FaceMatchRequestRepository {

	List<Proposta> findByProcessado(String processado);

	void save(Proposta proposta);

	List<Proposta> findByIdProposta(Long idProposta);
}