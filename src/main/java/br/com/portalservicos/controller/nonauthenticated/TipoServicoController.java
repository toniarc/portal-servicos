package br.com.portalservicos.controller.nonauthenticated;

import br.com.portalservicos.model.dto.PaginatedListResponseDto;
import br.com.portalservicos.model.dto.TipoServicoDto;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import br.com.portalservicos.persistence.repository.TipoServicoRepository;
import br.com.portalservicos.util.mapper.TipoServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/public/tipos-servico")
public class TipoServicoController {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @GetMapping
    public List<TipoServicoDto> getTiposServico() {
        List<TipoServicoEntity> tipoServicoPage = tipoServicoRepository.findAll(Sort.by("nome"));
        return TipoServicoMapper.INSTANCE.map(tipoServicoPage);
    }
}
