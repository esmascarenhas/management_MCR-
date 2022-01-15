package com.maximo.esm.apimcr.api.dto.model.response;


import com.maximo.esm.apimcr.domain.entity.Encomenda;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaEncomendaResponse implements Serializable {


    private static final long serialVersionUID = -7353231483957171261L;

    private Integer id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
