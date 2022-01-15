package com.maximo.esm.apimcr.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnidadeNaoEncontradaException extends Exception {
    public UnidadeNaoEncontradaException(Integer unidadeid) {
        super(String.format("unidade não encontrada com o id: ", unidadeid));
    }
}
