package com.maximo.esm.apimcr.api.dto.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Builder
@ToString
@AllArgsConstructor
public class UserRequest {

    private String username;
    private String senha;

    public UserRequest() {
    }
    @NotEmpty(message = "Username não pode ser vazio")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "Senha não pode ser vazia")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
