package com.maximo.esm.apimcr.domain.service.unidade;

import com.maximo.esm.apimcr.api.dto.mapper.UnidadeMapper;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.exception.UnidadeNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AlteraUnidadeService {

    private final UnidadeRepository repository;
    private final BuscaUnidadeService buscaUnidade;
    private final UnidadeMapper mapper;

    @Transactional
    public void delete (Integer unidadeid) throws UnidadeNaoEncontradaException {
        buscaUnidade.findById(unidadeid);
        repository.deleteById(unidadeid);
    }
    public MessageResponse update(Integer unidadeid, UnidadeResponse unidadeResponse) throws UnidadeNaoEncontradaException {
        buscaUnidade.findById(unidadeid);
        unidadeResponse.getApartamento();
        unidadeResponse.getContato();
        unidadeResponse.getProprietario();
        unidadeResponse.getEmail();
        unidadeResponse.getTorre();

        Unidade unityUpdate = mapper.toEntity2(unidadeResponse);
        Unidade unitySaved = repository.save(unityUpdate);
        MessageResponse message = createMessage("Apartamento: ",unitySaved.getApartamento()," Atualizado com sucesso - Proprietário: ", unitySaved.getProprietario());
                return message;
    }

    public MessageResponse createMessage(String msn1, Integer id, String msn2, String name){
        return MessageResponse.builder().message(msn1 + id + msn2 + name).build();
    }

}
