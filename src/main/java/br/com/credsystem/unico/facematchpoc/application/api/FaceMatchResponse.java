package br.com.credsystem.unico.facematchpoc.application.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaceMatchResponse {
	@JsonProperty("Status")
	private boolean retorno;
	private String processado;
	private String descricaoErro;

	public void confirmaProcessamento() {
		this.processado = "S";
	}
}