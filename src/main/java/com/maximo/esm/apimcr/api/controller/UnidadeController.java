package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.dto.mapper.UnidadeMapper;
import com.maximo.esm.apimcr.api.dto.model.request.UnidadeRequest;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.exception.UnidadeNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import com.maximo.esm.apimcr.domain.service.unidade.AlteraUnidadeService;
import com.maximo.esm.apimcr.domain.service.unidade.BuscaUnidadeService;
import com.maximo.esm.apimcr.domain.service.unidade.CriaUnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
@Api("API de Controle das Unidades MCR")
public class UnidadeController {

    private UnidadeRepository repository;
    private BuscaUnidadeService service;
    private CriaUnidadeService criaUnidadeService;
    private AlteraUnidadeService alteraunidade;
    private UnidadeMapper mapper;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/vi/unidade")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Lista todas unidades cadastrada.")
    public List<UnidadeResponse> listAll(){
        return mapper.toCollectionModel(service.listAll());

    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')" )
    @GetMapping("/vi/unidade/{unidadeid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Busca uma unidade especifica")
    public UnidadeResponse findById(@PathVariable Integer unidadeid) throws UnidadeNaoEncontradaException {
        return service.findById(unidadeid);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/v1/unidade",method = RequestMethod.POST,produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra uma unidade no MCR")
    public MessageResponse create (@Valid @RequestBody UnidadeRequest unidadeRequest){

        return criaUnidadeService.create(unidadeRequest);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/v1/unidade/{unidadeid}",method = RequestMethod.PUT,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Atualiza o cadastro de uma unidade do MCR")
    public MessageResponse update (@PathVariable Integer unidadeid, @Valid @RequestBody UnidadeResponse unidade) throws UnidadeNaoEncontradaException {
        return alteraunidade.update(unidadeid,unidade);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation("Exclui Unidade do cadastro MCR.")
    @DeleteMapping("/vi/unidade/{unidadeid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable Integer unidadeid) throws UnidadeNaoEncontradaException {
        alteraunidade.delete(unidadeid);
     }

}

