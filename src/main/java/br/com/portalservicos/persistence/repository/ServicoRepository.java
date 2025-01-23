package br.com.portalservicos.persistence.repository;

import br.com.portalservicos.persistence.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long>, JpaSpecificationExecutor<ServicoEntity> {
}