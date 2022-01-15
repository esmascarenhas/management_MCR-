package com.maximo.esm.apimcr.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEncomenda {


    PENDENTE("Pendente"), ENTREGUE("Entregue"),
    EXTRAVIADA("Extraviada"), QUEBRADADA("Quebrada");

    public final String status;
}
