package com.produtos.montaveis.formulasapi.domain.model;

import com.produtos.montaveis.formulasapi.domain.model.binomio.Binomio;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.Polinomio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "tb_sentenca")
public class Sentenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(mappedBy = "sentenca")
    private Binomio binomio;

    @OneToOne(mappedBy = "sentenca")
    private Polinomio polinomio;
}
