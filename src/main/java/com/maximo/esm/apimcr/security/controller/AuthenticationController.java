package com.maximo.esm.apimcr.security.controller;


import com.maximo.esm.apimcr.api.dto.model.request.UserRequest;
import com.maximo.esm.apimcr.api.dto.model.response.Response;
import com.maximo.esm.apimcr.security.model.TokenDTO;
import com.maximo.esm.apimcr.security.utils.JwtTokenUtil;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
@ApiOperation(value = "Sistema de Controle MCR - Realiza autenticação do usuário." )
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

//Gera e retorna um novo token JWT.

    @PostMapping("/v1/auth")
    @ApiOperation(value = "Gera um Token de acesso")
    public ResponseEntity<Response<TokenDTO>>gerarTokenJwt(@Valid @RequestBody UserRequest authenticationDto,
                                                           BindingResult result) throws AuthenticationException {
     Response<TokenDTO>response = new Response<TokenDTO>();

     if(result.hasErrors()){
         log.error("Error: {}", result.getAllErrors());
         result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
         return ResponseEntity.badRequest().body(response);
     }
     log.info("Gerando token para o Username: {}.",authenticationDto.getUsername());

     Authentication authentication = authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(),authenticationDto.getSenha()));
             SecurityContextHolder.getContext().setAuthentication(authentication);

             UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getUsername());

             String token = jwtTokenUtil.obterToken(userDetails);
             response.setData(new TokenDTO(token));
             return ResponseEntity.ok(response);

}
}