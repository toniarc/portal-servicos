package br.com.portalservicos.util.mapper;

import br.com.portalservicos.model.dto.ServicoDto;
import br.com.portalservicos.persistence.entity.ServicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServicoMapper {
    ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);

    List<ServicoDto> map(List<ServicoEntity> content);

    ServicoDto map(ServicoEntity servicoEntity);
}
