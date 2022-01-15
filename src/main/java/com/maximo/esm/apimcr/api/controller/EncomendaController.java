package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.dto.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.dto.model.request.EncomendaRequest;
import com.maximo.esm.apimcr.api.dto.model.response.EncomendaResponse;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.domain.exception.EncomendaNaoEncontradaException;
import com.maximo.esm.apimcr.domain.exception.UnidadeNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.EncomendaRepository;
import com.maximo.esm.apimcr.domain.service.encomenda.BuscaEncomendaService;
import com.maximo.esm.apimcr.domain.service.encomenda.CadastraEncomendaService;
import com.maximo.esm.apimcr.domain.service.encomenda.FinalizaEncomendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api("Api de Controle de Encomendas do MCR")
public class EncomendaController {

    private final EncomendaRepository repository;
    private final BuscaEncomendaService service;
    private final FinalizaEncomendaService finalizaService;
    private final CadastraEncomendaService cadastraEncomenda;
    private final EncomendaMapper mapper;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Lista encomendas do MCR")
    @GetMapping("/v1/encomenda")
    public List<EncomendaResponse> findAll (){
        return mapper.toCollectionModel(service.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Busca uma encomenda do MCR")
    @GetMapping("/v1/encomenda/{encomendaid}")
    public EncomendaResponse findById (@PathVariable Integer encomendaid) throws EncomendaNaoEncontradaException {
        return service.findById(encomendaid);
    }

    @RequestMapping(value = "/v1/encomenda",method = RequestMethod.POST,produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra encomenda para uma unidade do MCR")
    public MessageResponse create (@Valid @RequestBody EncomendaRequest encomendaRequest) throws UnidadeNaoEncontradaException {
        return cadastraEncomenda.create(encomendaRequest);
    }

    @RequestMapping(value = "/v1/encomenda/{encomendaid}/entregue",method = RequestMethod.PUT,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Finaliza o status de uma encomenda como entregue")
    public void finalizaEncomenda(@PathVariable Integer encomendaid) throws EncomendaNaoEncontradaException {
        finalizaService.finaliza(encomendaid);
    }

    @RequestMapping(value = "/v1/encomenda/{encomendaid}/extraviada",method = RequestMethod.PUT,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Finaliza o status de uma encomenda como extraviada")
    public void encomendaExtraviada(@PathVariable Integer encomendaid) throws EncomendaNaoEncontradaException {
        finalizaService.extraviada(encomendaid);
    }

    @RequestMapping(value = "/v1/encomenda/{encomendaid}/quebrada",method = RequestMethod.PUT,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Finalizao status de uma encomenda como quebrada")
    public void encomendaQuebrada(@PathVariable Integer encomendaid) throws EncomendaNaoEncontradaException {
        finalizaService.quebrada(encomendaid);
    }



}
