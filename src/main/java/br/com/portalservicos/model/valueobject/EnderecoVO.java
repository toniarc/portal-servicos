package br.com.portalservicos.model.valueobject;

import br.com.portalservicos.model.dto.MunicipioDto;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class EnderecoVO {

    private String logradouro;
    private String bairro;
    private String cep;
    private MunicipioDto municipio;
    private String complemento;
    private String numero;

}
