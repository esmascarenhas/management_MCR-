package com.maximo.esm.apimcr.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ocorrencia_encomenda")
public class OcorrenciaEncomenda implements Serializable {

    private static final long serialVersionUID = -4415526121975761685L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "encomenda_id")
    private Encomenda encomenda;

    private String descricao;
    private OffsetDateTime dataRegistro;
}
