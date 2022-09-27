package com.produtos.montaveis.formulasapi.domain.repository.binomio;

import com.produtos.montaveis.formulasapi.domain.model.binomio.Binomio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinomioRepository extends JpaRepository<Binomio, Long> {
}
