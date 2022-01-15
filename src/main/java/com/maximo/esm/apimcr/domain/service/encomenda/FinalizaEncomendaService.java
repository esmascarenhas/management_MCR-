package com.maximo.esm.apimcr.domain.service.encomenda;

import com.maximo.esm.apimcr.api.dto.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.exception.EncomendaNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.EncomendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FinalizaEncomendaService {

    private final EncomendaRepository repository;
    private final EncomendaMapper mapper;
    private final BuscaEncomendaService buscaEncomenda;

    public void finaliza(Integer encomendaid) throws EncomendaNaoEncontradaException {
        Encomenda encomenda = mapper.toEntity2(buscaEncomenda.findById(encomendaid));
        encomenda.baixarEncomenda();
        repository.save(encomenda);

    }
    public void extraviada(Integer encomendaid) throws EncomendaNaoEncontradaException {
        Encomenda encomenda = mapper.toEntity2(buscaEncomenda.findById(encomendaid));
        encomenda.encomendaExtraviada();
        repository.save(encomenda);

    }
    public void quebrada(Integer encomendaid) throws EncomendaNaoEncontradaException {
        Encomenda encomenda = mapper.toEntity2(buscaEncomenda.findById(encomendaid));
        encomenda.encomendaQuebrada();
        repository.save(encomenda);

    }
}
