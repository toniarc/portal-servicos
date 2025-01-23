package br.com.portalservicos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticatedDto {

    private String id;
    private String pessoaFisicaId;
    private String name;
    private String cpf;
    private String email;

}
