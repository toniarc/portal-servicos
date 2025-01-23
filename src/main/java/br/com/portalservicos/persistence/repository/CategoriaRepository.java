package br.com.portalservicos.persistence.repository;

import br.com.portalservicos.persistence.entity.CategoriaEntity;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
