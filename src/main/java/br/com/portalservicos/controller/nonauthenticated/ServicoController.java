package br.com.portalservicos.controller.nonauthenticated;


import br.com.portalservicos.model.dto.PaginatedListResponseDto;
import br.com.portalservicos.model.dto.ServicoDto;
import br.com.portalservicos.persistence.entity.ServicoEntity;
import br.com.portalservicos.persistence.repository.ServicoRepository;
import br.com.portalservicos.persistence.repository.ServicoSpecification;
import br.com.portalservicos.util.mapper.ServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public PaginatedListResponseDto<ServicoDto> getServicos(
            @RequestParam(required = false) Long categoriaServicoId,
            @RequestParam(required = false) Long tipoServicoId,
            @RequestParam(required = false) Long orgaoId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Specification<ServicoEntity> spec = Specification.where(ServicoSpecification.hasCategoriaServicoId(categoriaServicoId))
                .and(ServicoSpecification.hasTipoServicoId(tipoServicoId))
                .and(ServicoSpecification.hasOrgaoId(orgaoId));

        Page<ServicoEntity> servicoPage = servicoRepository.findAll(spec, pageable);
        List<ServicoDto> servicoList = ServicoMapper.INSTANCE.map(servicoPage.getContent());

        return new PaginatedListResponseDto<>(page, size, servicoPage.getTotalElements(), servicoList);
    }

    @GetMapping("/{id}")
    public ServicoDto getServicoById(@PathVariable(name = "id") Long id) {
        ServicoEntity servicoEntity = servicoRepository.findById(id).orElse(null);
        return ServicoMapper.INSTANCE.map(servicoEntity);
    }
}