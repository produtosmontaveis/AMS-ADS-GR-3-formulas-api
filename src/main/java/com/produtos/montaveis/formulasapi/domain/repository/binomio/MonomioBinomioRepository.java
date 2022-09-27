package com.produtos.montaveis.formulasapi.domain.repository.binomio;

import com.produtos.montaveis.formulasapi.domain.model.binomio.MonomioBinomio;
import com.produtos.montaveis.formulasapi.domain.model.binomio.MonomioBinomioKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonomioBinomioRepository extends JpaRepository<MonomioBinomio, MonomioBinomioKey> {
}
