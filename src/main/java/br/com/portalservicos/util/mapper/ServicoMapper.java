package br.com.portalservicos.util.mapper;

import br.com.portalservicos.model.dto.*;
import br.com.portalservicos.model.valueobject.EnderecoVO;
import br.com.portalservicos.persistence.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

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

    MunicipioDto map(MunicipioEntity entity);

    @Mapping(target = "localAtendimento", ignore = true)
    HorarioAtendimentoDto map(HorarioAtendimentoEntity entity);

    default ServicoPresencialDto map(ServicoPresencialEntity entity) {

        if(entity == null || entity.getHorariosAtendimento() == null) return null;

        List<LocalAtendimentoDto> locaisAtendimento = entity.getHorariosAtendimento().stream()
                .map(HorarioAtendimentoEntity::getLocalAtendimento)
                .distinct()
                .map(localAtendimentoEntity -> {
                    LocalAtendimentoDto localAtendimentoDto = new LocalAtendimentoDto();
                    localAtendimentoDto.setId(localAtendimentoEntity.getId());

                    localAtendimentoDto.setEndereco(new EnderecoVO());

                    localAtendimentoDto.getEndereco().setLogradouro(localAtendimentoEntity.getLogradouro());
                    localAtendimentoDto.getEndereco().setBairro(localAtendimentoEntity.getBairro());
                    localAtendimentoDto.getEndereco().setCep(localAtendimentoEntity.getCep());
                    localAtendimentoDto.getEndereco().setMunicipio(map(localAtendimentoEntity.getMunicipio()));
                    localAtendimentoDto.getEndereco().setComplemento(localAtendimentoEntity.getComplemento());
                    localAtendimentoDto.getEndereco().setNumero(localAtendimentoEntity.getNumero());
                    return localAtendimentoDto;
                })
                .toList();

        locaisAtendimento.forEach(la -> {
            la.setHorarios(entity.getHorariosAtendimento().stream()
                    .filter(ha -> ha.getLocalAtendimento().getId().equals(la.getId()))
                    .map(this::map)
                    .collect(Collectors.toList()));
        });

        ServicoPresencialDto dto = new ServicoPresencialDto();
        dto.setId(entity.getId());
        dto.setLocaisAtendimento(locaisAtendimento);
        return dto;
    }

}
