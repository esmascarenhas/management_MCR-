package com.maximo.esm.apimcr.api.dto.model.request;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
//@AllArgsConstructor
public class UnidadeRequestId implements Serializable {


    private static final long serialVersionUID = 1542538089398059989L;

    private Integer id;

    //@Id
    //@EqualsAndHashCode.Include
    //@ApiModelProperty(value = "Código da unidade")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
 /*   public Integer getId() {
        return id;
    }*/
}
