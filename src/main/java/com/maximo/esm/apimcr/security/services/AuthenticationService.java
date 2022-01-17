package com.maximo.esm.apimcr.security.services;

import com.maximo.esm.apimcr.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario>usuario = usuarioService.findByUsername(username);
        if(usuario.isPresent()){
            return JwtUserFactory.create(usuario.get());}
            throw new UsernameNotFoundException("Username não encontrado.");
// busca no repositório pelo usuário e verificar se ele existe e devolver para o processo de autenticação
        }
    }

