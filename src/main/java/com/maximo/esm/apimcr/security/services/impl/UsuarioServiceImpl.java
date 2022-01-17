package com.maximo.esm.apimcr.security.services.impl;

import com.maximo.esm.apimcr.domain.entity.Usuario;
import com.maximo.esm.apimcr.domain.repository.UsuarioRepository;
import com.maximo.esm.apimcr.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return Optional.ofNullable(this.repository.findByUsername(username));
    }
}
