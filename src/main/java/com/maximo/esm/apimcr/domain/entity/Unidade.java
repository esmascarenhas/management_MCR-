package com.maximo.esm.apimcr.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Unidade {

    @Id
    @EqualsAndHashCode.Include
    @ApiModelProperty(value = "Código da unidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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


    @ElementCollection
    @OneToMany(mappedBy = "unidade",cascade = CascadeType.ALL)
    private List<Encomenda> encomendas = new ArrayList<>();

/*
    @ElementCollection
    @OneToMany(mappedBy = "unidade",cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();*/
}
