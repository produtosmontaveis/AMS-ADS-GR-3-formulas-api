package com.produtos.montaveis.formulasapi.domain.repository.polinomio;

import com.produtos.montaveis.formulasapi.domain.model.polinomio.Polinomio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolinomioRepository extends JpaRepository<Polinomio, Long> {
}
