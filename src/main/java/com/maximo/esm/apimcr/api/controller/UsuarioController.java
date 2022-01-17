package com.maximo.esm.apimcr.api.controller;


import com.maximo.esm.apimcr.api.dto.mapper.UsuarioMapper;
import com.maximo.esm.apimcr.api.dto.model.request.UserRequest;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UserResponse;
import com.maximo.esm.apimcr.domain.exception.UsuarioNaoEncontradaException;
import com.maximo.esm.apimcr.domain.service.usuario.UserService;
import com.maximo.esm.apimcr.security.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api("Controle de usuários do MCR")
@CrossOrigin("*")
public class UsuarioController {

    private final UserService service;
    private final UsuarioMapper mapper;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation("Lista os usuários do MCR")
    public List<UserResponse> findAll(){
        return service.findAll();
    }
    @GetMapping("/v1/usuario/{usuarioid}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')" )
    @ApiOperation("Lista uma usuário do MCR")
    public UserResponse findById(@PathVariable Integer usuarioid) throws UsuarioNaoEncontradaException {
        return service.findById(usuarioid);
    }

    @PostMapping("/v1/usuario")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')" )
    @ApiOperation(" Cadastra um usuário no MCR")
    public MessageResponse create (@Valid @RequestBody UserRequest request){
        return service.create(request);
    }
}
