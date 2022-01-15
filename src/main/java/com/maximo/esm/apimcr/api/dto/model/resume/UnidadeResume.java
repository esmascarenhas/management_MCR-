package com.maximo.esm.apimcr.api.dto.model.resume;

import lombok.*;

import javax.persistence.Entity;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeResume {

    private Integer id;
    private String proprietario;
    private Integer apartamento;
    private String torre;






}
