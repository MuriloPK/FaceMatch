package br.com.credsystem.unico.facematchpoc.application.api;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.credsystem.unico.facematchpoc.domain.Proposta;
import br.com.credsystem.unico.facematchpoc.infra.ClientBucket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaceMatchRequest {
	@JsonProperty("Base64Selfie")
	private String imagemSelf;
	@JsonProperty("Base64Documento")
	private String imagemDocumento;

	public FaceMatchRequest(Proposta proposta) {
		this.imagemSelf = proposta.getImagemSelf();
		this.imagemDocumento = proposta.getImagemDocumento();
	}

	public FaceMatchRequest(Proposta proposta, ClientBucket clientBucket) {
		this.imagemSelf = Optional.ofNullable(proposta.getImagemSelf())
				.orElse(clientBucket.buscarImagemBucket(proposta.getIdBucketFoto()));
		this.imagemDocumento = Optional.ofNullable(proposta.getImagemDocumento())
			.orElse(clientBucket.buscarImagemBucket(proposta.getIdBucketDocumento()));
	}
}