package com.maximo.esm.apimcr.api.dto.model.response;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinatarioResponse {

    private String nome;
    private String rg;

}
