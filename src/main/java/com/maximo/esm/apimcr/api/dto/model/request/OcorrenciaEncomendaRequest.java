package com.maximo.esm.apimcr.api.dto.model.request;


import com.maximo.esm.apimcr.domain.entity.Encomenda;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaEncomendaRequest implements Serializable {


    private static final long serialVersionUID = 4594716568159017744L;

    private String descricao;

}
