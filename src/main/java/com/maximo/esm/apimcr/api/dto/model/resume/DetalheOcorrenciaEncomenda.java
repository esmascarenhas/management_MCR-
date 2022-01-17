package com.maximo.esm.apimcr.api.dto.model.resume;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalheOcorrenciaEncomenda implements Serializable {


    private static final long serialVersionUID = 7763189857273274913L;

    private Integer id;
    private String descricao;
    private OffsetDateTime dataRegistro;
    @ManyToOne
    private EncomendaResumo encomenda;

}
