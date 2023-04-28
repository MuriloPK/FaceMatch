package br.com.credsystem.unico.facematchpoc.application.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.credsystem.unico.facematchpoc.application.api.FaceMatchRequest;
import br.com.credsystem.unico.facematchpoc.application.api.FaceMatchResponse;

@FeignClient(name = "faceMatchFeignClient", url = "https://crediariohomolog.acesso.io/credsystemhml/services/v3")
public interface FaceMatchFeignClient {
	@PostMapping(value = "/AcessoService.svc/faces/match", produces = MediaType.APPLICATION_JSON_VALUE)
	FaceMatchResponse enviarSolicitacaoFaceMatch(
			@RequestHeader(value = "APIKEY") String apiKey,
			@RequestHeader(value = "Authorization") String token,
			@RequestBody FaceMatchRequest request);
}