package br.com.portalservicos.persistence.repository;


import br.com.portalservicos.persistence.entity.ServicoEntity;
import org.springframework.data.jpa.domain.Specification;

public class ServicoSpecification {

    public static Specification<ServicoEntity> hasCategoriaServicoId(Long categoriaServicoId) {
        return (root, query, criteriaBuilder) ->
                categoriaServicoId == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("categoriaServicoId"), categoriaServicoId);
    }

    public static Specification<ServicoEntity> hasTipoServicoId(Long tipoServicoId) {
        return (root, query, criteriaBuilder) ->
                tipoServicoId == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("tipoServicoId"), tipoServicoId);
    }

    public static Specification<ServicoEntity> hasOrgaoId(Long orgaoId) {
        return (root, query, criteriaBuilder) ->
                orgaoId == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("orgaoId"), orgaoId);
    }
}