package com.produtos.montaveis.formulasapi.domain.repository;

import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonomioRepository extends JpaRepository<Monomio, Long> {
}
