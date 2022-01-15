package com.maximo.esm.apimcr.api.dto.mapper;

import com.maximo.esm.apimcr.api.dto.model.response.OcorrenciaEncomendaResponse;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaEncomenda;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OcorrenciaEncomendaMapper {

    public ModelMapper modelMapper;

    public OcorrenciaEncomendaResponse toModel(OcorrenciaEncomenda ocorrencia){
        return modelMapper.map(ocorrencia,OcorrenciaEncomendaResponse.class);
    }

    public List<OcorrenciaEncomendaResponse> toCollectionModel(List<OcorrenciaEncomenda>ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
