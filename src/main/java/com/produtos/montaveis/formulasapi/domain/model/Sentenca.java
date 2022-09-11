package com.produtos.montaveis.formulasapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.Polinomio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tb_sentenca")
public class Sentenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "sentenca")
    private Set<Polinomio> polinomios;

    public void addPolinomioToSentenca(Polinomio polinomio) {
        polinomios.add(polinomio);
    }
}
