package com.maximo.esm.apimcr.domain.repository;

import com.maximo.esm.apimcr.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByUsername (String username);
}
