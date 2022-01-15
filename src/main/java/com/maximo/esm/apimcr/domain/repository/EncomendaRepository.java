package com.maximo.esm.apimcr.domain.repository;

import com.maximo.esm.apimcr.domain.entity.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda,Integer> {

    Optional<Encomenda>findByNotaFiscal(String notaFiscal);
}
