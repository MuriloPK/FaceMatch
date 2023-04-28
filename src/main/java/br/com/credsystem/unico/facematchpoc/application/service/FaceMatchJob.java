package br.com.credsystem.unico.facematchpoc.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.credsystem.unico.facematchpoc.application.api.FaceMatchResponse;
import br.com.credsystem.unico.facematchpoc.application.repository.FaceMatchRequestRepository;
import br.com.credsystem.unico.facematchpoc.domain.Proposta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class FaceMatchJob{
	private final FaceMatchIntegration faceMatchIntegration;
	private final FaceMatchRequestRepository faceMatchRequestRepository;

	public void executa() {
		log.info("[inicia] FaceMatchJob - executa");
		List<Proposta> propostas = faceMatchRequestRepository.findByProcessado("N");
		log.info("[propostas] {}", propostas);
		propostas.forEach(p -> validaProposta(p));
		log.info("[finaliza] FaceMatchJob - executa");
	}

	@Transactional
	private void validaProposta(Proposta proposta) {
		log.info("[inicia] FaceMatchJob - validaProposta");
		FaceMatchResponse response = faceMatchIntegration.fazerFaceMatch(proposta);
		proposta.atualiza(response);
		faceMatchRequestRepository.save(proposta);
		log.info("[finaliza] FaceMatchJob - validaProposta");
	}
}