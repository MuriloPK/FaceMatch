package br.com.credsystem.unico.facematchpoc.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.credsystem.unico.facematchpoc.domain.Proposta;

public interface CredlineRepositoryInfra extends JpaRepository<Proposta, Long>  {

	List<Proposta> findByProcessado(String processado);
	List<Proposta> findByIdProposta(Long idProposta);

}