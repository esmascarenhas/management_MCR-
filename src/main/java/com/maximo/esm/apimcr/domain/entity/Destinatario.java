package com.maximo.esm.apimcr.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @NotEmpty
    @Column(name = "destinatario_nome")
    private String nome;


    @NotEmpty
    @Column(name = "destinatario_rg")
    private String rg;

}
