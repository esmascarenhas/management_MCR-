package com.maximo.esm.apimcr.api.dto.model.resume;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeResume implements Serializable {

    private static final long serialVersionUID = -8844611783367594664L;

    private Integer id;
    private String proprietario;
    private Integer apartamento;
    private String torre;






}
