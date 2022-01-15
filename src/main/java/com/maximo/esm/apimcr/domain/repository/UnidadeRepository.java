package com.maximo.esm.apimcr.domain.repository;

import com.maximo.esm.apimcr.domain.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade,Integer> {
}
