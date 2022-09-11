package com.produtos.montaveis.formulasapi.domain.repository;

import com.produtos.montaveis.formulasapi.domain.model.Sentenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentencaRepository extends JpaRepository<Sentenca, Long> {
}
