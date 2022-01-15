package com.maximo.esm.apimcr.api.dto.model.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeResponse {

    private Integer id;
    private String contato;
    private String email;
    private Integer apartamento;
    private String proprietario;
    private String torre;






}
