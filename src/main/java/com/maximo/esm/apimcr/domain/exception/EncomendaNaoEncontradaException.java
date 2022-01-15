package com.maximo.esm.apimcr.domain.exception;

public class EncomendaNaoEncontradaException extends Exception{
    public EncomendaNaoEncontradaException(Integer encomendaid) {
        super(String.format("Encomenda não encontrada com o id: ", encomendaid));
    }
}
