package com.maximo.esm.apimcr.domain.entity;

import com.maximo.esm.apimcr.domain.enums.StatusEncomenda;
import com.maximo.esm.apimcr.domain.exception.NegocioException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Encomenda {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    //@ApiModelProperty(value = "Codigo da unidade")
    private Unidade unidade;

    @Embedded
    private Destinatario destinatario;

    @NotEmpty
    @Column(unique = true)
    private String notaFiscal;

    @Enumerated(EnumType.STRING )
    private StatusEncomenda statusEncomenda;

    private OffsetDateTime entradaEncomenda;
    private OffsetDateTime baixaEncomenda;


        public void baixarEncomenda(){
        if(naopodeserbaixado()){
            throw new NegocioException("Encomenda não pode ser baixada");
        }
        setStatusEncomenda(StatusEncomenda.ENTREGUE);
        setBaixaEncomenda(OffsetDateTime.now());
            }

    public void encomendaExtraviada(){
        if(naopodeserbaixado()){
            throw new NegocioException("Encomenda não pode ser baixada");
        }
        setStatusEncomenda(StatusEncomenda.EXTRAVIADA);
        setBaixaEncomenda(OffsetDateTime.now());
    }

    public void encomendaQuebrada(){
        if(naopodeserbaixado()){
            throw new NegocioException("Encomenda não pode ser baixada");
        }
        setStatusEncomenda(StatusEncomenda.QUEBRADADA);
        setBaixaEncomenda(OffsetDateTime.now());
    }
    public boolean naopodeserbaixado(){

        return !podeserbaixado();
    }

    public boolean podeserbaixado() {

        return statusEncomenda.PENDENTE.equals(getStatusEncomenda());
    }



    @OneToMany(mappedBy = "encomenda" , cascade = CascadeType.ALL)
    private List<OcorrenciaEncomenda> ocorrenciaEncomendas = new ArrayList<>();

    public OcorrenciaEncomenda adicionarOcorrenciaEncomenda(String descricao){
        OcorrenciaEncomenda ocorrenciaEncomenda = new OcorrenciaEncomenda();

        ocorrenciaEncomenda.setDescricao(descricao);
        ocorrenciaEncomenda.setDataRegistro(OffsetDateTime.now());
        ocorrenciaEncomenda.setEncomenda(this);

        return ocorrenciaEncomenda;
    }
}
