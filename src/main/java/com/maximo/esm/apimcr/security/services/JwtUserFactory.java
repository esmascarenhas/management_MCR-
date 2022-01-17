package com.maximo.esm.apimcr.security.services;

import com.maximo.esm.apimcr.domain.entity.Usuario;
import com.maximo.esm.apimcr.domain.enums.PerfilUser;
import com.maximo.esm.apimcr.security.model.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    public JwtUserFactory() {
    }
//Converte e gera um JwtUser com base nos dados de um usuario.

    public static JwtUser create (Usuario usuario){
        return new JwtUser(usuario.getId(),usuario.getUsername(),usuario.getSenha(),
            mapToGrantedAuthorities(usuario.getPerfil()));
}

//Converte o perfil do usuário para o formato utilizado pelo Spring Security.

    private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilUser perfil){
        List<GrantedAuthority>authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(perfil.toString()));
        return authorities;
    }

}
