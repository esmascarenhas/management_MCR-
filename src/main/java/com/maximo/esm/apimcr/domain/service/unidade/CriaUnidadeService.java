package com.maximo.esm.apimcr.domain.service.unidade;

import com.maximo.esm.apimcr.api.dto.mapper.UnidadeMapper;
import com.maximo.esm.apimcr.api.dto.model.request.UnidadeRequest;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.exception.UnidadeNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CriaUnidadeService {

    private UnidadeRepository repository;
    private final UnidadeMapper mapper;
    private final BuscaUnidadeService buscaService;


  public MessageResponse create(UnidadeRequest unidadeRequest){
      Unidade novaUnidade = mapper.toEntity(unidadeRequest);
      Unidade unidadeCadastrada = repository.save(novaUnidade);
      MessageResponse message = createMessage ("Unidade: " , unidadeCadastrada.getApartamento() , " cadastrada com sucesso - Proprietário: " , unidadeCadastrada.getProprietario());
      return message;
  }

  public MessageResponse createMessage(String msn1, Integer id, String msn2, String name){
      return MessageResponse.builder().message(msn1 + id + msn2 + name).build();
  }


    }



