package com.maximo.esm.apimcr.domain.service.ocorrencia;

import com.maximo.esm.apimcr.api.dto.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.dto.model.response.EncomendaResponse;
import com.maximo.esm.apimcr.api.dto.model.response.OcorrenciaEncomendaResponse;
import com.maximo.esm.apimcr.api.dto.model.resume.DetalheOcorrenciaEncomenda;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.OcorrenciaEncomenda;
import com.maximo.esm.apimcr.domain.exception.EncomendaNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.OcorrenciaEncomendaRepository;
import com.maximo.esm.apimcr.domain.service.encomenda.BuscaEncomendaService;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OcorrenciaEncomendaService {

    private final BuscaEncomendaService buscarEncomenda;
    private final EncomendaMapper encomendaMapper;
    private final OcorrenciaEncomendaRepository repository;

    @Transactional
    public OcorrenciaEncomenda registar (Integer encomendaid, String descricao) throws EncomendaNaoEncontradaException {
        Encomenda encomenda = encomendaMapper.toEntity2(buscarEncomenda.findById(encomendaid));
        OcorrenciaEncomenda ocorrencia =  encomenda.adicionarOcorrenciaEncomenda(descricao);
        return repository.save(ocorrencia);

    }

    public List<OcorrenciaEncomenda> findAll (){
        return repository.findAll();
    }

/*    public DetalheOcorrenciaEncomenda findById (Integer encomendaid) throws EncomendaNaoEncontradaException {
        OcorrenciaEncomenda ocorencia = repository.findById(encomendaid);
        Encomenda encomenda = encomendaMapper.toEntity2(buscarEncomenda.findById(encomendaid));
        encomenda.getUnidade().getProprietario();
        encomenda.getUnidade().getApartamento();
        encomenda.getUnidade().getTorre();
        DetalheOcorrenciaEncomenda detalhe =
        return repository.save(encomenda);
    }*/
   /* public DetalheOcorrenciaEncomenda buscarOcorrencias ( DetalheOcorrenciaEncomenda detalheOcorrencia){
        OcorrenciaEncomenda ocorrencias = repository.findById(detalheOcorrencia.getEncomenda().)
        return repository.findById()
    }*/

}
