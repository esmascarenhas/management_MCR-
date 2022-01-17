package com.maximo.esm.apimcr.domain.service.usuario;

import com.maximo.esm.apimcr.api.dto.mapper.UsuarioMapper;
import com.maximo.esm.apimcr.api.dto.model.request.UserRequest;
import com.maximo.esm.apimcr.api.dto.model.response.MessageResponse;
import com.maximo.esm.apimcr.api.dto.model.response.UserResponse;
import com.maximo.esm.apimcr.domain.entity.Usuario;
import com.maximo.esm.apimcr.domain.enums.PerfilUser;
import com.maximo.esm.apimcr.domain.exception.UsuarioNaoEncontradaException;
import com.maximo.esm.apimcr.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;


    public List<UserResponse> findAll (){
        return mapper.toCollectionModel(repository.findAll());
    }

    public UserResponse findById(Integer usuarioid) throws UsuarioNaoEncontradaException {
        Usuario usuario = repository.findById(usuarioid)
                .orElseThrow(() -> new UsuarioNaoEncontradaException(usuarioid));
        return mapper.toModel(usuario);

    }

    @Transactional
    public MessageResponse create (UserRequest usuario){
        Usuario novoUsuario = mapper.toEntity(usuario);
        novoUsuario.setPerfil(PerfilUser.ROLE_USUARIO);
        Usuario usuarioSalvo = repository.save(novoUsuario);
        MessageResponse message = createMessage("Usuário: " + usuarioSalvo.getUsername() + " cadastrado com sucesso. ");
        return message;
    }


    private MessageResponse createMessage(String msn1){
        return MessageResponse.builder().message(msn1).build();
    }


}
