package br.com.portalservicos.util.mapper;

import br.com.portalservicos.model.dto.OrgaoDto;
import br.com.portalservicos.persistence.entity.OrgaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrgaoMapper {
    OrgaoMapper INSTANCE = Mappers.getMapper(OrgaoMapper.class);

    List<OrgaoDto> map(List<OrgaoEntity> content);
}
