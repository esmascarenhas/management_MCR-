package com.maximo.esm.apimcr.api.controller;

import com.maximo.esm.apimcr.api.dto.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.dto.mapper.OcorrenciaEncomendaMapper;
import com.maximo.esm.apimcr.api.dto.model.request.OcorrenciaEncomendaRequest;
import com.maximo.esm.apimcr.api.dto.model.response.OcorrenciaEncomendaResponse;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaEncomenda;
import com.maximo.esm.apimcr.domain.exception.EncomendaNaoEncontradaException;
import com.maximo.esm.apimcr.domain.service.encomenda.BuscaEncomendaService;
import com.maximo.esm.apimcr.domain.service.ocorrencia.OcorrenciaEncomendaService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Api("Controle de ocorrências do MCR")
public class OcorrenciaEncomendaController {

    private final OcorrenciaEncomendaService ocorrenciaService;
    private final BuscaEncomendaService buscarEncomenda;
    private final EncomendaMapper mapperEncomenda;
    private final OcorrenciaEncomendaMapper mapper;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/v1/ocorrenciaEncomenda",method = RequestMethod.GET, produces = "application/json")
    public List<OcorrenciaEncomendaResponse> ocorrencias(){
        return mapper.toCollectionModel(ocorrenciaService.findAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/v1/ocorrenciaEncomenda/{encomendaid}",method = RequestMethod.POST, produces = "application/json")
    public OcorrenciaEncomendaResponse registrar(@PathVariable Integer encomendaid,
                                                 @Valid @RequestBody OcorrenciaEncomendaRequest request) throws EncomendaNaoEncontradaException {
        OcorrenciaEncomenda ocorrencia = ocorrenciaService.registar(encomendaid,request.getDescricao());
        return mapper.toModel(ocorrencia);

    }

}



