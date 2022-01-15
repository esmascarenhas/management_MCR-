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

@Builder
@Data
@AllArgsConstructor
public class UnidadeRequest implements Serializable {


    private static final long serialVersionUID = -4574964125781298470L;

    @NotEmpty
    @Size(min = 2, max = 80)
    private String proprietario;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String contato;

    @NotEmpty
    @Size(min = 2, max = 120)
    @Email
    private String email;

    @NotNull
    private Integer apartamento;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String torre;



/*
    @OneToMany(mappedBy = "unidade",cascade = CascadeType.ALL)
    private List<Encomenda> encomendaList = new ArrayList<>();
*/


}
