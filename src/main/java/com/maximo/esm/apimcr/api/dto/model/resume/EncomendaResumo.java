package com.maximo.esm.apimcr.api.dto.model.resume;


import com.maximo.esm.apimcr.api.dto.model.response.DestinatarioResponse;
import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncomendaResumo implements Serializable {

    private static final long serialVersionUID = 824998644600153314L;

    private Integer id;
    private UnidadeResume unidade;
    private DestinatarioResponse destinatario;
    private String notaFiscal;
    private StatusEncomenda statusEncomenda;
    private OffsetDateTime entradaEncomenda;
    private OffsetDateTime baixaEncomenda;
}
