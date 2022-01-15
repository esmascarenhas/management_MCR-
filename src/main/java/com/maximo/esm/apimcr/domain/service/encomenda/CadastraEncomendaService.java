package com.maximo.esm.apimcr.domain.service.encomenda;

import com.maximo.esm.apimcr.api.dto.mapper.EncomendaMapper;
import com.maximo.esm.apimcr.api.dto.mapper.UnidadeMapper;
import com.maximo.esm.apimcr.api.dto.model.request.EncomendaRequest;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UnidadeResponse;
import com.maximo.esm.apimcr.domain.entity.Encomenda;
import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import com.maximo.esm.apimcr.domain.exception.UnidadeNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.EncomendaRepository;
import com.maximo.esm.apimcr.domain.service.unidade.BuscaUnidadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class CadastraEncomendaService {

    private final EncomendaRepository repository;
    private final EncomendaMapper mapper;
    private final BuscaUnidadeService buscarUnidade;
    private final UnidadeMapper mapperUnidade;

    @Transactional
    public MessageResponse create (EncomendaRequest encomendaRequest) throws UnidadeNaoEncontradaException {
        Encomenda novaEncomenda = mapper.toEntity(encomendaRequest);

        boolean NFcadastrada = repository.findByNotaFiscal(novaEncomenda.getNotaFiscal())
                .stream().anyMatch(NFexiste -> !NFexiste.equals(encomendaRequest.getNotaFiscal()));
        if(NFcadastrada){
            throw new NegocioException("Nota Fiscal já cadastrada.");
        }
        UnidadeResponse unidade = buscarUnidade.findById(encomendaRequest.getUnidadeid().getId());

        novaEncomenda.setUnidade(mapperUnidade.toEntity2(unidade));
        novaEncomenda.setStatusEncomenda(StatusEncomenda.PENDENTE);
        novaEncomenda.setEntradaEncomenda(OffsetDateTime.now());

        Encomenda encomendaCadastrada = repository.save(novaEncomenda);

        MessageResponse message = createMessage("Encomenda cadastrada com o id: ", encomendaCadastrada.getId()," - Destinatário: "+ encomendaCadastrada.getDestinatario().getNome() + " - apartamento: ", encomendaCadastrada.getUnidade().getApartamento());

        return message;
    }

    public MessageResponse createMessage(String msn1, Integer id, String msn2, Integer apt){
        return MessageResponse.builder().message(msn1 + id + msn2 + apt).build();
    }

}
