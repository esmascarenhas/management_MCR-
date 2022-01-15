package com.maximo.esm.apimcr.domain.service.encomenda;

import com.maximo.esm.apimcr.domain.repository.EncomendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlteraEncomendaService {

    private final EncomendaRepository repository;
    private final BuscaEncomendaService buscaService;

}
