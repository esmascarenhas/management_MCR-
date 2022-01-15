package com.maximo.esm.apimcr.api.dto.mapper;

import com.maximo.esm.apimcr.api.dto.model.request.UnidadeRequest;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UnidadeMapper {

    public ModelMapper modelMapper;

    public UnidadeResponse toModel ( Unidade unidade){
        UnidadeResponse unidadeResponse = modelMapper.map(unidade,UnidadeResponse.class);
        return unidadeResponse;
    }
    public Unidade toEntity (UnidadeRequest unidadeRequest){
        Unidade unidade = modelMapper.map(unidadeRequest,Unidade.class);
        return unidade;
    }

    public List<UnidadeResponse> toCollectionModel(List<Unidade>unidades){
        return unidades.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Unidade toEntity2(UnidadeResponse unidade) {
        Unidade unidade1 = modelMapper.map(unidade,Unidade.class);
        return unidade1;
    }
}
