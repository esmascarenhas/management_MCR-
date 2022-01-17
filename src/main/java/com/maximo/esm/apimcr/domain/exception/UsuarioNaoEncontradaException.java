package com.maximo.esm.apimcr.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradaException extends Exception {
    public UsuarioNaoEncontradaException(Integer usuarioid) {
        super(String.format("usuario não encontrada com o id: ", usuarioid));
    }
}
