package com.maximo.esm.apimcr.api.dto.model.response;

import com.maximo.esm.apimcr.api.dto.model.resume.UnidadeResume;
import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EncomendaResponse {


    private Integer id;
    private UnidadeResume unidade;
    private DestinatarioResponse destinatario;
    private String notaFiscal;
    private StatusEncomenda statusEncomenda;
    private OffsetDateTime entradaEncomenda;
    private OffsetDateTime baixaEncomenda;


}
