package br.com.portalservicos.controller.nonauthenticated;

import br.com.portalservicos.model.dto.CategoriaDto;
import br.com.portalservicos.model.dto.PaginatedListResponseDto;
import br.com.portalservicos.model.dto.TipoServicoDto;
import br.com.portalservicos.persistence.entity.CategoriaEntity;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import br.com.portalservicos.persistence.repository.CategoriaRepository;
import br.com.portalservicos.persistence.repository.TipoServicoRepository;
import br.com.portalservicos.util.mapper.CategoriaMapper;
import br.com.portalservicos.util.mapper.TipoServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public PaginatedListResponseDto<CategoriaDto> getTiposServico(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CategoriaEntity> categoriaPage = categoriaRepository.findAll(pageRequest);
        List<CategoriaDto> tipoServicoList = CategoriaMapper.INSTANCE.map(categoriaPage.getContent());

        return new PaginatedListResponseDto<>(page, size, categoriaPage.getTotalElements(), tipoServicoList);
    }
}
