package com.maximo.esm.apimcr.api.dto.mapper;

import com.maximo.esm.apimcr.api.dto.model.request.EncomendaRequest;
import com.maximo.esm.apimcr.api.dto.model.response.EncomendaResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EncomendaMapper {

    public ModelMapper modelMapper;

    public EncomendaResponse toModel (Encomenda encomenda){
        EncomendaResponse encomendaResponse = modelMapper.map(encomenda,EncomendaResponse.class);
        return encomendaResponse;

    }
    public Encomenda toEntity(EncomendaRequest encomendaRequest){
        Encomenda encomenda = modelMapper.map(encomendaRequest,Encomenda.class);
        return encomenda;
    }
    public Encomenda toEntity2(EncomendaResponse encomendaResponse){
        Encomenda encomenda = modelMapper.map(encomendaResponse,Encomenda.class);
        return encomenda;
    }

    public List<EncomendaResponse> toCollectionModel(List<Encomenda>encomendas){
        return encomendas.stream().map(this::toModel).collect(Collectors.toList());
    }

}
