package com.produtos.montaveis.formulasapi.domain.repository;

import com.produtos.montaveis.formulasapi.domain.model.polinomio.MonomioPolinomio;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.MonomioPolinomioKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonomioPolinomioRepository extends JpaRepository<MonomioPolinomio, MonomioPolinomioKey> {
}
