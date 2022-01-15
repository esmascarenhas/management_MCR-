package com.maximo.esm.apimcr.domain.service.encomenda;

import com.maximo.esm.apimcr.api.dto.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.dto.model.response.EncomendaResponse;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.exception.EncomendaNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.EncomendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BuscaEncomendaService {

    private final EncomendaRepository repository;
    private final EncomendaMapper mapper;

    public List<Encomenda> findAll (){
        return repository.findAll();
    }

    public EncomendaResponse findById (Integer encomendaid) throws EncomendaNaoEncontradaException {
        Encomenda encomenda = repository.findById(encomendaid)
                .orElseThrow(()-> new EncomendaNaoEncontradaException(encomendaid));
        return mapper.toModel(encomenda);
    }

}
