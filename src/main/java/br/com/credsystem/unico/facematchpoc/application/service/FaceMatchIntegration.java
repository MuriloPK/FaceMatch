package br.com.credsystem.unico.facematchpoc.application.service;

import br.com.credsystem.unico.facematchpoc.application.api.FaceMatchResponse;
import br.com.credsystem.unico.facematchpoc.domain.Proposta;

public interface FaceMatchIntegration {
	FaceMatchResponse fazerFaceMatch(Proposta proposta);
}