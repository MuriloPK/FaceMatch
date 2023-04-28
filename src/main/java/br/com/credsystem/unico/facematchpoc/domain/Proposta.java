package br.com.credsystem.unico.facematchpoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.credsystem.unico.facematchpoc.application.api.FaceMatchResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "UNICO_FACEMATCH")
public class Proposta {

	@Id
	@Column(name = "ID_PROPOSTA")
	private Long idProposta;
	@Column(name = "IMAGEM_SELF")
	private String imagemSelf;
	@Column(name = "IMAGEM_DOCUMENTO")
	private String imagemDocumento;
	@Column(name = "PROCESSADO")
	private String processado;
	@Column(name = "RETORNO")
	private Boolean retorno;
	@Column(name = "DESC_ERRO")
	private String descricaoErro;
	@Column(name = "ID_BUCKET_FOTO")
	private String idBucketFoto;
	@Column(name = "ID_BUCKET_DOCUMENTO")
	private String idBucketDocumento;

	public void atualiza(FaceMatchResponse response) {
		this.setRetorno(response.isRetorno());
		this.setDescricaoErro(response.getDescricaoErro());
		this.setProcessado("S");
	}
}