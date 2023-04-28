package br.com.credsystem.unico.facematchpoc.infra;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ClientBucket {

	public String buscarImagemBucket(String idBucketFoto) {
		String urlDocumento = construirUrl(idBucketFoto);
		try {
			SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext)
					.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
			HttpGet request = new HttpGet(urlDocumento);
			HttpResponse response = httpClient.execute(request);
			return EntityUtils.toString(response.getEntity()).replaceAll("'", "");
		} catch (Exception e) {
			log.error("Erro ao buscar imagem do bucket: {}", e.getMessage());
			throw new RuntimeException("Erro ao buscar imagem do bucket: " + e.getMessage());
		}
	}

	private String construirUrl(String idBucketFoto) {
		return BUCKET_PREFIX + idBucketFoto;
	}

	private static final String BUCKET_PREFIX = "https://objectstorage.sa-saopaulo-1.oraclecloud.com/p/W8djhkWuTx6u8_Yd0OoT-nU--NmkBViFowuPOhq7MN6KiNwbDWVdJqq-6t2-KVxM/n/grhf47fuhm4l/b/credline-producao/o/";
}
