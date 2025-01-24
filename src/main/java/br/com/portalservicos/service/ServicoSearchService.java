package br.com.portalservicos.service;

import br.com.portalservicos.model.dto.PaginatedListResponseDto;
import br.com.portalservicos.model.dto.ServicoDto;
import br.com.portalservicos.persistence.entity.ServicoEntity;
import br.com.portalservicos.persistence.repository.ServicoRepository;
import br.com.portalservicos.persistence.repository.ServicoSpecification;
import br.com.portalservicos.util.mapper.ServicoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoSearchService {

    private final ServicoRepository servicoRepository;

    @GetMapping
    public PaginatedListResponseDto<ServicoDto> getServicos(
            Long categoriaServicoId,
            Long tipoServicoId,
            Long orgaoId,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);
        Specification<ServicoEntity> spec = Specification.where(ServicoSpecification.hasCategoriaServicoId(categoriaServicoId))
                .and(ServicoSpecification.hasTipoServicoId(tipoServicoId))
                .and(ServicoSpecification.hasOrgaoId(orgaoId));

        Page<ServicoEntity> servicoPage = servicoRepository.findAll(spec, pageable);
        List<ServicoDto> servicoList = ServicoMapper.INSTANCE.map(servicoPage.getContent());

        return new PaginatedListResponseDto<>(page, size, servicoPage.getTotalElements(), servicoList);
    }
}
