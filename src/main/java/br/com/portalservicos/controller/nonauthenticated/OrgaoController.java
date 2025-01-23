package br.com.portalservicos.controller.nonauthenticated;

import br.com.portalservicos.model.dto.OrgaoDto;
import br.com.portalservicos.model.dto.PaginatedListResponseDto;
import br.com.portalservicos.model.dto.TipoServicoDto;
import br.com.portalservicos.persistence.entity.OrgaoEntity;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import br.com.portalservicos.persistence.repository.OrgaoRepository;
import br.com.portalservicos.persistence.repository.TipoServicoRepository;
import br.com.portalservicos.util.mapper.OrgaoMapper;
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
@RequestMapping("/public/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoRepository orgaoRepository;

    @GetMapping
    public PaginatedListResponseDto<OrgaoDto> getTiposServico(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrgaoEntity> orgaoPage = orgaoRepository.findAll(pageRequest);
        List<OrgaoDto> tipoServicoList = OrgaoMapper.INSTANCE.map(orgaoPage.getContent());

        return new PaginatedListResponseDto<>(page, size, orgaoPage.getTotalElements(), tipoServicoList);
    }
}
