package br.com.portalservicos.persistence.repository;

import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServicoEntity, Long> {
}
