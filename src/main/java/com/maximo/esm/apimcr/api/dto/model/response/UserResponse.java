package com.maximo.esm.apimcr.api.dto.model.response;

import com.maximo.esm.apimcr.api.dto.model.resume.UnidadeResume;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.enums.PerfilUser;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {


    private static final long serialVersionUID = 3960030757029692122L;


    private Integer id;
    private String username;
    private String senha;
    private PerfilUser perfil;
    //private UnidadeResume unidade;
}
