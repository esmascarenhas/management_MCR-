package com.maximo.esm.apimcr.api.dto.mapper;

import com.maximo.esm.apimcr.api.dto.model.request.UserRequest;
import com.maximo.esm.apimcr.api.dto.model.response.UserResponse;
import com.maximo.esm.apimcr.domain.entity.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UsuarioMapper {

    public ModelMapper modelMapper;

    public UserResponse toModel (Usuario usuario){
        return modelMapper.map(usuario,UserResponse.class);
    }
    public Usuario toEntity (UserRequest userRequest){
        return modelMapper.map(userRequest,Usuario.class);
    }
    public List<UserResponse> toCollectionModel (List<Usuario>usuarios){
        return usuarios.stream().map(this::toModel).collect(Collectors.toList());
    }



}
