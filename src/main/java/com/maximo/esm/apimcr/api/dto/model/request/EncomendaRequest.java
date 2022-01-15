package com.maximo.esm.apimcr.api.dto.model.request;

import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EncomendaRequest implements Serializable {


    private static final long serialVersionUID = 1418511369063325678L;

    @ManyToOne()
    //@ApiModelProperty(value = "Codigo da unidade")
    @JoinColumn(name = "unidadeid")
    private UnidadeRequestId unidadeid;

    @Valid
    @NotEmpty
    private DestinatarioRequest destinatario;

    @NotEmpty
    @Column(unique = true)
    private String notaFiscal;





}
