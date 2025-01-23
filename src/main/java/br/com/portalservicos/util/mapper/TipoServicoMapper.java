package br.com.portalservicos.util.mapper;

import br.com.portalservicos.model.dto.TipoServicoDto;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoServicoMapper {
    TipoServicoMapper INSTANCE = Mappers.getMapper(TipoServicoMapper.class);

    List<TipoServicoDto> map(List<TipoServicoEntity> content);
}
