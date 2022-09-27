package com.produtos.montaveis.formulasapi.domain.repository.monomio;

import com.produtos.montaveis.formulasapi.domain.model.monomio.Termo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermoRepository extends JpaRepository<Termo, Long> {
}
