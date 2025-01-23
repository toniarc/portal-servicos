package br.com.portalservicos.util.mapper;

import br.com.portalservicos.model.dto.CategoriaDto;
import br.com.portalservicos.model.dto.TipoServicoDto;
import br.com.portalservicos.persistence.entity.CategoriaEntity;
import br.com.portalservicos.persistence.entity.TipoServicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    List<CategoriaDto> map(List<CategoriaEntity> content);
}
