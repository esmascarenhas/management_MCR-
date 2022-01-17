package com.maximo.esm.apimcr.security.services;

import com.maximo.esm.apimcr.domain.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> findByUsername(String username);
}
