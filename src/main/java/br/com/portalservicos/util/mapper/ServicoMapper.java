package br.com.portalservicos.util.mapper;

import br.com.portalservicos.model.dto.LocalAtendimentoDto;
import br.com.portalservicos.model.dto.ServicoDto;
import br.com.portalservicos.persistence.entity.LocalAtendimentoEntity;
import br.com.portalservicos.persistence.entity.ServicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServicoMapper {
    ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);

    List<ServicoDto> map(List<ServicoEntity> content);

    ServicoDto map(ServicoEntity servicoEntity);


    @Mapping(source = "logradouro", target = "endereco.logradouro")
    @Mapping(source = "bairro", target = "endereco.bairro")
    @Mapping(source = "cep", target = "endereco.cep")
    @Mapping(source = "municipio", target = "endereco.municipio")
    @Mapping(source = "complemento", target = "endereco.complemento")
    @Mapping(source = "numero", target = "endereco.numero")
    LocalAtendimentoDto map(LocalAtendimentoEntity entity);
}
