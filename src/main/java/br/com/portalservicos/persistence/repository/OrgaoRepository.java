package br.com.portalservicos.persistence.repository;

import br.com.portalservicos.persistence.entity.OrgaoEntity;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoRepository extends JpaRepository<OrgaoEntity, Long> {
}
