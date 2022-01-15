package com.maximo.esm.apimcr.domain.service.unidade;

import com.maximo.esm.apimcr.api.dto.mapper.UnidadeMapper;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.exception.UnidadeNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BuscaUnidadeService {

    private UnidadeRepository repository;
    private final UnidadeMapper mapper;


    public List<Unidade> listAll (){
        return repository.findAll();
    }

    public UnidadeResponse findById(Integer unidadeid) throws UnidadeNaoEncontradaException {
       Unidade unidade = repository.findById(unidadeid)
               .orElseThrow(() -> new UnidadeNaoEncontradaException(unidadeid));

        return mapper.toModel(unidade);
    }


    }



