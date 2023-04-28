package br.com.credsystem.unico.facematchpoc.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.credsystem.unico.facematchpoc.application.repository.FaceMatchRequestRepository;
import br.com.credsystem.unico.facematchpoc.domain.Proposta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FaceMatchRequestRepositoryInfra implements FaceMatchRequestRepository {

	private final CredlineRepositoryInfra credlineRepositoryInfra;

	@Override
	public List<Proposta> findByProcessado(String processado) {
		log.info("[incia] FaceMatchRequestRepositoryInfra - findByProcessado");
		List<Proposta> buscaProcessado = credlineRepositoryInfra.findByProcessado(processado);
		log.info("[finaliza] FaceMatchRequestRepositoryInfra - findByProcessado");
		return buscaProcessado;
	}

	@Override
	public void save(Proposta proposta) {
		log.info("[incia] FaceMatchRequestRepositoryInfra - save");
		credlineRepositoryInfra.save(proposta);
		log.info("[finaliza] FaceMatchRequestRepositoryInfra - save");

	}

	@Override
	public List<Proposta> findByIdProposta(Long idProposta) {
		log.info("[inicia] FaceMatchRequestRepositoryInfra - findByIdProposta");
		List<Proposta> propostasById = credlineRepositoryInfra.findByIdProposta(idProposta);
		log.info("[finaliza] FaceMatchRequestRepositoryInfra - findByIdProposta");
		return propostasById;
	}
}