package com.maximo.esm.apimcr.domain.entity;

import com.maximo.esm.apimcr.domain.enums.PerfilUser;
import io.cucumber.java.bs.A;
import lombok.*;

import javax.naming.directory.SearchResult;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {


    private static final long serialVersionUID = -4681701271581623461L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilUser perfil;

/*    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;*/
}
